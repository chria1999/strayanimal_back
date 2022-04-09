package com.lqa.strayanimal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 10411
 */
@Data
@TableName("role")
@ApiModel
public class RoleEntity {

    @ApiModelProperty(notes = "id")
    private Integer id;

    @ApiModelProperty(notes = "角色名")
    private String name;

    @ApiModelProperty(notes = "角色名Zh")
    private String nameZh;

}
