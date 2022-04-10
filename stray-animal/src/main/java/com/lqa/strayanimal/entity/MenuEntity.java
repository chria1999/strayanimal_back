package com.lqa.strayanimal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 菜单
 * @author 10411
 */
@Data
@TableName("menu")
@ApiModel
public class MenuEntity {

    @ApiModelProperty(notes = "id")
    private Integer id;

    @ApiModelProperty(notes = "路径匹配")
    private String url;

    @ApiModelProperty(notes = "访问路由")
    private String path;

    @ApiModelProperty(notes = "组件名")
    private String component;

    @ApiModelProperty(notes = "菜单名")
    private String name;

    @ApiModelProperty(notes = "图标")
    private String iconCls;

    @ApiModelProperty(notes = "上级菜单")
    private Integer parentId;

    @ApiModelProperty(notes = "是否启用")
    private boolean enabled;

    @ApiModelProperty(notes = "子菜单")
    private List<MenuEntity> children;

    @ApiModelProperty(notes = "角色组")
    private List<RoleEntity> roles;

    @ApiModelProperty(notes = "meta属性")
    private Meta meta;
}
