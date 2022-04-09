package com.lqa.strayanimal.entity;

import lombok.Data;
import java.util.List;

/**
 * 自定义分页类
 * @author 10411
 */
@Data
public class RespPageBean {

    private Long total;

    private List<?> data;
}
