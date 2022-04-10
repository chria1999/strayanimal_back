package com.lqa.strayanimal.controller;

import com.lqa.strayanimal.entity.RoleEntity;
import com.lqa.strayanimal.service.MenuService;
import com.lqa.strayanimal.service.RoleService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 权限组
 * @author 10411
 */
@RestController
@RequestMapping("/sys/permission")
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
}
