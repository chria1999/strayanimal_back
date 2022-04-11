package com.lqa.strayanimal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lqa.strayanimal.entity.AdminEntity;
import com.lqa.strayanimal.entity.MenuEntity;
import com.lqa.strayanimal.entity.MenuRoleEntity;
import com.lqa.strayanimal.mapper.MenuMapper;
import com.lqa.strayanimal.mapper.MenuRoleMapper;
import com.lqa.strayanimal.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 10411
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuEntity> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private MenuRoleMapper menuRoleMapper;

    /**
     * todo
     * 获得所有url所需的角色
     * @return
     */
    @Override
    public List<MenuEntity> getAllMenusWithRole() {
        return null;
    }

    @Override
    public List<MenuEntity> getMenuById() {
        Integer id = ((AdminEntity)(SecurityContextHolder.getContext().getAuthentication().getPrincipal())).getId();
        /**
         * todo
         */
        return null;
    }

    @Override
    public List<MenuEntity> getAllMenus() {
        /**
         * todo
         */
        return null;
    }

    @Override
    @Transactional
    public boolean updateMenuRole(Integer roleId, Integer[] menuIds) {
        menuRoleMapper.deleteById(roleId);
        Integer count = menuRoleMapper.addMenuRole(roleId, menuIds);
        return count == menuIds.length;
    }

    @Override
    public List<Integer> getMenuIdByRoleId(Integer roleId) {
        /**
         * todo 需优化
         */
        LambdaQueryWrapper<MenuRoleEntity> lambdaQueryWrapper = new LambdaQueryWrapper<MenuRoleEntity>();
        lambdaQueryWrapper.eq(MenuRoleEntity::getRoleId, roleId);
        lambdaQueryWrapper.select(MenuRoleEntity::getMenuId);
        List<MenuRoleEntity> menuRoleEntityList = menuRoleMapper.selectList(lambdaQueryWrapper);
        List<Integer> arrayList = new ArrayList<>();
        menuRoleEntityList.forEach(menuRoleEntity -> {
            arrayList.add(menuRoleEntity.getMenuId());
        });
        return arrayList;
    }
}
