package com.lqa.strayanimal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 10411
 */
@Data
@TableName("admin_role")
@ApiModel
public class AdminRoleEntity {

    @ApiModelProperty(notes = "id")
    private Integer id;

    @ApiModelProperty(notes = "管理员id")
    private Integer adminId;

    @ApiModelProperty(notes = "角色id")
    private Integer roleId;
}
