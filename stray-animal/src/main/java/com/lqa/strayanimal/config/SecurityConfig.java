package com.lqa.strayanimal.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lqa.strayanimal.entity.AdminEntity;
import com.lqa.strayanimal.entity.RespBean;
import com.lqa.strayanimal.service.impl.AdminServiceImpl;
import com.lqa.strayanimal.utils.VerifyCodeAuthProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * security配置
 * @author 10411
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AdminServiceImpl adminServiceImpl;

    @Autowired
    AdminFilterInvocationSecurityMetaDataSource adminFilterInvocationSecurityMetaDataSource;

    @Autowired
    AdminUrlDecisionManager adminUrlDecisionManager;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 密码加密
     * @return
     */
    @Bean
    VerifyCodeAuthProvider verifyCodeAuthProvider() {
        VerifyCodeAuthProvider verifyCodeAuthProvider = new VerifyCodeAuthProvider();
        verifyCodeAuthProvider.setPasswordEncoder(passwordEncoder());
        verifyCodeAuthProvider.setUserDetailsService(adminServiceImpl);
        return verifyCodeAuthProvider;
    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        ProviderManager providerManager = new ProviderManager(Arrays.asList(verifyCodeAuthProvider()));
        return providerManager;
    }

    @Override
    @Autowired
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(adminServiceImpl);
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
                    @Override
                    public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                        o.setAccessDecisionManager(adminUrlDecisionManager);
                        o.setSecurityMetadataSource(adminFilterInvocationSecurityMetaDataSource);
                        return o;
                    }
                })
                .and()
                .formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                /**
                 * 表单验证跳转地址，可作为中转站
                 */
                .loginProcessingUrl("/doLogin")
                /**
                 * 登录界面
                 */
                .loginPage("/login")
                /**
                 * 登陆成功回调函数
                 */
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter printWriter = response.getWriter();
                        AdminEntity adminEntity = (AdminEntity) authentication.getPrincipal();
                        adminEntity.setPassword("");
                        RespBean ok = RespBean.ok("登陆成功", adminEntity);
                        String str = new ObjectMapper().writeValueAsString(ok);
                        printWriter.write(str);
                        printWriter.flush();
                        printWriter.close();
                    }
                })
                /**
                 * 登陆失败回调函数
                 */
                .failureHandler(new AuthenticationFailureHandler() {
                    @Override
                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter printWriter = response.getWriter();
                        RespBean error = RespBean.error("登录失败");
                        if (exception instanceof LockedException) {
                            error.setMsg("账号被锁定");
                        } else if (exception instanceof CredentialsExpiredException) {
                            error.setMsg("密码已过期");
                        } else if (exception instanceof AccountExpiredException) {
                            error.setMsg("账号已过期");
                        } else if (exception instanceof DisabledException) {
                            error.setMsg("账号被禁用");
                        } else if (exception instanceof BadCredentialsException) {
                            error.setMsg("账号或密码错误");
                        } else if (exception instanceof AuthenticationServiceException) {
                            error.setMsg("验证码错误");
                        }
                        printWriter.write(new ObjectMapper().writeValueAsString(error));
                        printWriter.flush();
                        printWriter.close();
                    }
                })
                .permitAll()
                .and()
                .logout()
                /**
                 * 登出成功回调函数
                 */
                .logoutSuccessHandler(new LogoutSuccessHandler() {
                    @Override
                    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        PrintWriter printWriter = response.getWriter();
                        printWriter.write(new ObjectMapper().writeValueAsString(RespBean.ok("退出成功")));
                        printWriter.flush();
                        printWriter.close();
                    }
                })
                .permitAll()
                .and()
                /**
                 * 本地记住密码
                 */
                .rememberMe()
                .key("pwdstored")
                /**
                 * 表单中checkbox的name属性
                 */
                .rememberMeParameter("remeberMe")
                .and()
                .csrf().disable().exceptionHandling().authenticationEntryPoint(new AuthenticationEntryPoint() {
                    /**
                     * 未认证时处理
                     * @param request
                     * @param response
                     * @param authException
                     * @throws IOException
                     * @throws ServletException
                     */

                    @Override
                    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
                        response.setContentType("application/json;charset=utf-8");
                        response.setStatus(401);
                        PrintWriter printWriter = response.getWriter();
                        RespBean error = RespBean.error("访问失败");
                        if (authException instanceof InsufficientAuthenticationException) {
                            error.setMsg("请求失败");
                        }
                        printWriter.write(new ObjectMapper().writeValueAsString(error));
                        printWriter.flush();
                        printWriter.close();
                    }
                });
    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception {
        /**
         * 资源访问放行,请求url
         */
        webSecurity.ignoring().antMatchers("/system/config/animal/")
                .antMatchers("/login")
                .antMatchers("/verifyCode");
    }
}
