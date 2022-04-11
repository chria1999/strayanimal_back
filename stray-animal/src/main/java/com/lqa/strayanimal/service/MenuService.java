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

    /**
     * 返回菜单
     * @return
     */
    public List<MenuEntity> getMenuById();

    /**
     * 返回所有菜单
     * @return
     */
    public List<MenuEntity> getAllMenus();

    /**
     * 取得该角色菜单
     * @param roleId
     * @return
     */
    public List<Integer> getMenuIdByRoleId(Integer roleId);


    /**
     * 更新角色菜单
     * @param roleId
     * @param menuIds
     * @return
     */
    public boolean updateMenuRole(Integer roleId, Integer[] menuIds);

}
