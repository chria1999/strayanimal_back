package com.lqa.strayanimal.controller;

import com.lqa.strayanimal.entity.RespBean;
import com.lqa.strayanimal.entity.RoleEntity;
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
@RequestMapping("/sys/role")
@Api(tags = "角色")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/get")
    @ApiOperation(value = "取得所有角色")
    public List<RoleEntity> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加角色")
    public RespBean addRole(@RequestBody RoleEntity roleEntity) {
        if (roleService.addRole(roleEntity) == 1) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

    @PutMapping("/update")
    @ApiOperation(value = "更新角色")
    public RespBean updateRole(@RequestBody RoleEntity roleEntity) {
        if (roleService.updateRole(roleEntity) == 1) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "删除某一个角色")
    public RespBean deleteRoleById(@PathVariable("id") Integer id) {
        if (roleService.deleteRoleById(id) == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @DeleteMapping("/delete/selected")
    @ApiOperation(value = "删除选定角色")
    public RespBean deleteRolesByIds(Integer[] ids) {
        if (roleService.deleteRolesByIds(ids) == ids.length) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }
}
