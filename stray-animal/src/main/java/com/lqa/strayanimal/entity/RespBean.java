package com.lqa.strayanimal.entity;

import lombok.Data;

/**
 * 自定义响应类
 * @author 10411
 */
@Data
public class RespBean {

    private Integer status;

    private String msg;

    private Object obj;

    private RespBean() {}

    public RespBean(Integer status, String msg, Object obj) {
        this.status = status;
        this.msg = msg;
        this.obj = obj;
    }

    public static RespBean build() {
        return new RespBean();
    }
    public static RespBean ok(String msg) {
        return new RespBean(200, msg, null);
    }
    public static RespBean ok(String msg, Object obj) {
        return new RespBean(200, msg, obj);
    }
    public static RespBean error(String msg) {
        return new RespBean(500, msg, null);
    }
    public static RespBean error(String msg, Object obj) {
        return new RespBean(500, msg, obj);
    }

}
