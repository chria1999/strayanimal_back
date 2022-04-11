package com.lqa.strayanimal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 10411
 */
@Data
@TableName("menu_role")
@ApiModel
public class MenuRoleEntity {

    @ApiModelProperty(notes = "id")
    private Integer id;

    @ApiModelProperty(notes = "菜单id")
    private Integer menuId;

    @ApiModelProperty(notes = "角色id")
    private Integer roleId;
}
