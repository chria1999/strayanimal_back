package com.lqa.strayanimal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lqa.strayanimal.entity.MenuEntity;

import java.util.List;

/**
 * @author 10411
 */
public interface MenuService extends IService<MenuEntity> {

    /**
     * todo
     * 取得该角色的所有权限菜单
     * @return
     */
    public List<MenuEntity> getAllMenusWithRole();


}
