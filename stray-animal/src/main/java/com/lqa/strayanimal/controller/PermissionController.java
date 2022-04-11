package com.lqa.strayanimal.controller;

import com.lqa.strayanimal.entity.MenuEntity;
import com.lqa.strayanimal.entity.RespBean;
import com.lqa.strayanimal.entity.RoleEntity;
import com.lqa.strayanimal.service.MenuService;
import com.lqa.strayanimal.service.RoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 权限组
 * @author 10411
 */
@RestController
@RequestMapping("/system/basic/permiss")
public class PermissionController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @GetMapping("/")
    @ApiOperation(value = "取得所有角色")
    public List<RoleEntity> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/menus")
    @ApiOperation(value = "取得所有菜单")
    public List<MenuEntity> getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/mids/{roleId}")
    @ApiOperation(value = "取得该角色菜单")
    public List<Integer> getMenuIdByRoleId(@PathVariable("roleId") Integer roleId) {
        return menuService.getMenuIdByRoleId(roleId);
    }

    @PutMapping("/")
    public RespBean updateMenuRole(Integer roleId, Integer[] menuIds) {
        if (menuService.updateMenuRole(roleId, menuIds)) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @PostMapping("/role")
    public RespBean addRole(@RequestBody RoleEntity roleEntity) {
        if (roleService.addRole(roleEntity) == 1) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @DeleteMapping("/role/{roleId}")
    public RespBean deleteRoleById(@PathVariable("roleId") Integer roleId) {
        if (roleService.deleteRoleById(roleId) == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

}
