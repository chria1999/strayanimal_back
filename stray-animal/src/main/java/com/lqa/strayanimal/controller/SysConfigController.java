package com.lqa.strayanimal.controller;

import com.lqa.strayanimal.entity.MenuEntity;
import com.lqa.strayanimal.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/menu")
    @ApiOperation(value = "获得菜单")
    public List<MenuEntity> getMenuById() {
        return menuService.getMenuById();
    }
}
