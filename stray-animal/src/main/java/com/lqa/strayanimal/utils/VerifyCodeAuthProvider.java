package com.lqa.strayanimal.utils;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 验证码校验
 * @author 10411
 */
public class VerifyCodeAuthProvider extends DaoAuthenticationProvider {

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String str = httpServletRequest.getParameter("verify_code");
        String verify_code = (String) httpServletRequest.getSession().getAttribute("verify_code");
        if (str == null || verify_code == null || !str.equals(verify_code)) {
            throw new AuthenticationServiceException("验证码错误");
        }
        super.additionalAuthenticationChecks(userDetails, usernamePasswordAuthenticationToken);
    }

}
