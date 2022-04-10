package com.lqa.strayanimal.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 10411
 */
@Data
@ApiModel
public class Meta {

    @ApiModelProperty(notes = "keepAlive")
    private boolean keepAlive;

    @ApiModelProperty(notes = "requireAuth")
    private boolean requireAuth;
}
