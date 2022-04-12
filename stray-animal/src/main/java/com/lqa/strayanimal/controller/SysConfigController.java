package com.lqa.strayanimal.controller;

import com.lqa.strayanimal.entity.MenuEntity;
import com.lqa.strayanimal.entity.RespBean;
import com.lqa.strayanimal.entity.RoleEntity;
import com.lqa.strayanimal.service.MenuService;
import com.lqa.strayanimal.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 10411
 */
@RestController
@RequestMapping("/sys/config")
@Api(tags = "系统配置")
public class SysConfigController {

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/")
    @ApiOperation(value = "取得所有角色")
    public List<RoleEntity> getAllRoles() {
        return roleService.getAllRoles();
    }

    @GetMapping("/menu")
    @ApiOperation(value = "获得菜单")
    public List<MenuEntity> getMenuById() {
        return menuService.getMenuById();
    }

    @GetMapping("/mids/{roleId}")
    @ApiOperation(value = "通过角色获取菜单")
    public List<Integer> getMenuIdByRoleId(@PathVariable("roleId") Integer roleId) {
        return menuService.getMenuIdByRoleId(roleId);
    }

    @PutMapping("/")
    @ApiOperation(value = "更新角色菜单")
    public RespBean updateMenuRole(Integer roleId, Integer[] menuIds) {
        if (menuService.updateMenuRole(roleId, menuIds)) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @PostMapping("/role")
    @ApiOperation(value = "添加角色")
    public RespBean addRole(@RequestBody RoleEntity roleEntity) {
        if (roleService.addRole(roleEntity) == 1) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @DeleteMapping("/role/{roleId}")
    @ApiOperation(value = "删除角色")
    public RespBean deleteRoleById(@PathVariable("roleId") Integer roleId) {
        if (roleService.deleteRoleById(roleId) == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
