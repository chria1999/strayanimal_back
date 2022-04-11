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
@TableName("article")
@ApiModel
public class ArticleEntity {

    @ApiModelProperty(notes = "id")
    private Integer id;

    @ApiModelProperty(notes = "标题")
    private String title;

    @ApiModelProperty(notes = "html内容")
    private String contentHtml;

    @ApiModelProperty(notes = "md内容")
    private String contentMd;

    @ApiModelProperty(notes = "摘要")
    private String contentAbstract;

    @ApiModelProperty(notes = "发布时间")
    private Date date;

    @ApiModelProperty(notes = "封面")
    private String cover;
}
