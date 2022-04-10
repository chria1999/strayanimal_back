package com.lqa.strayanimal.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * @author 10411
 */
@Data
@TableName("money")
@ApiModel
public class MoneyEntity {

    @ApiModelProperty(notes = "id")
    private Integer id;

    @ApiModelProperty(notes = "金额")
    private double amount;

    @ApiModelProperty(notes = "支出/收入")
    private String pipe;


    @ApiModelProperty(notes = "类型")
    private String type;


    @ApiModelProperty(notes = "备注")
    private String info;

}
