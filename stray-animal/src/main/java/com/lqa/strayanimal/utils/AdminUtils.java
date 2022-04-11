package com.lqa.strayanimal.utils;

import com.lqa.strayanimal.entity.AdminEntity;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 返回当前登录管理员
 * @author 10411
 */
public class AdminUtils {

    public static AdminEntity getCurrentAdmin() {
        return (AdminEntity) (SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
