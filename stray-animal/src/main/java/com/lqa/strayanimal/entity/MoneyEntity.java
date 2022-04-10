package com.lqa.strayanimal.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

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

    @ApiModelProperty(notes = "操作员")
    private String operator;

    @ApiModelProperty(notes = "审核员")
    private String auditor;

    @ApiModelProperty(notes = "状态")
    private String status;

    @ApiModelProperty(notes = "操作时间")
    private Date addDate;

    @ApiModelProperty(notes = "审核时间")
    private Date auditDate;

    @ApiModelProperty(notes = "备注")
    private String info;

}
