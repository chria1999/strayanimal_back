package com.lqa.strayanimal.controller;

import com.lqa.strayanimal.entity.AdminEntity;
import com.lqa.strayanimal.entity.RespBean;
import com.lqa.strayanimal.entity.RoleEntity;
import com.lqa.strayanimal.service.AdminService;
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
@RequestMapping("/admin/info")
@Api(tags = "管理员")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private RoleService roleService;


    @GetMapping("/")
    @ApiOperation(value = "返回所有管理员")
    public List<AdminEntity> getAllAdmins(String keywords) {
        /**
         * todo
         */
        return null;
    }

    @PutMapping("/")
    @ApiOperation(value = "更新管理员信息")
    public RespBean updateAdmin(@RequestBody AdminEntity adminEntity) {
        if (adminService.updateAdmin(adminEntity) == 1) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @GetMapping("/roles")
    @ApiOperation(value = "返回所有角色")
    public List<RoleEntity> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping("/roles")
    @ApiOperation(value = "更新管理员的角色信息")
    public RespBean updateAdminRole(Integer adminId, Integer[] rolesId) {
        if (adminService.updateAdminRole(adminId, rolesId)) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "根据id删除管理员")
    public RespBean deleteAdminById(@PathVariable("id") Integer id) {
        if (adminService.deleteAdminById(id) == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @PostMapping("/")
    @ApiOperation(value = "添加管理员")
    public RespBean addAdmin(@RequestBody AdminEntity adminEntity) {
        if (adminService.addAdmin(adminEntity) == 1) {
            return RespBean.ok("添加成功");
        }
        return RespBean.error("添加失败");
    }

}
