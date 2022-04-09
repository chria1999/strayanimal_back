package com.lqa.strayanimal.config;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * 判断用户使用具备访问接口所需要的角色
 * @author 10411
 */
@Component
public class AdminUrlDecisionManager implements AccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object obj, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        for (ConfigAttribute configAttribute : collection) {
            String roles = configAttribute.getAttribute();
            if ("ROLE_LOGIN".equals(roles)) {
                if (authentication instanceof AnonymousAuthenticationToken) {
                    throw new AccessDeniedException("尚未登录!");
                } else {
                    return;
                }
            }
            Collection<? extends GrantedAuthority> grantedAuthorities = authentication.getAuthorities();
            for (GrantedAuthority grantedAuthority : grantedAuthorities) {
                if (grantedAuthority.getAuthority().equals(roles)) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足!");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
