package com.lqa.strayanimal.config;

import com.lqa.strayanimal.entity.MenuEntity;
import com.lqa.strayanimal.entity.RoleEntity;
import com.lqa.strayanimal.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * 权限访问：根据请求地址分析出角色
 * @author 10411
 */
@Component
public class AdminFilterInvocationSecurityMetaDataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private MenuService menuService;

    /**
     * ant风格路径匹配器
     */
    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    @Override
    public Collection<ConfigAttribute> getAttributes(Object obj) throws IllegalArgumentException {
        String url = ((FilterInvocation) obj).getRequestUrl();
        List<MenuEntity> menuEntityList = menuService.getAllMenusWithRole();
        for (MenuEntity menuEntity : menuEntityList) {
            if (antPathMatcher.match(menuEntity.getUrl(), url)) {
                List<RoleEntity> roleEntityList = menuEntity.getRoles();
                String[] str = new String[roleEntityList.size()];
                for (int i = 0; i < roleEntityList.size(); i++) {
                    str[i] = roleEntityList.get(i).getName();
                }
                return SecurityConfig.createList(str);
            }
        }
        /**
         * 未匹配上，登陆即可访问
         */
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
