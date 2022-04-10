package com.lqa.strayanimal.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 10411
 */
@Data
@TableName("animal")
@ApiModel
public class AnimalEntity {

    @ApiModelProperty(notes = "id")
    private Integer id;

    @ApiModelProperty(notes = "动物名")
    private String name;

    @ApiModelProperty(notes = "年龄")
    private Integer age;

    @ApiModelProperty(notes = "种类")
    private String breed;

    @ApiModelProperty(notes = "发现地")
    private String address;

    @ApiModelProperty(notes = "照片")
    private String picture;

    @ApiModelProperty(notes = "简介")
    private String info;

    @ApiModelProperty(notes = "疫苗接种")
    private boolean vaccine;

    @ApiModelProperty(notes = "健康状况")
    private Integer healthRate;

    @ApiModelProperty(notes = "是否领养")
    private boolean adopted;
}
