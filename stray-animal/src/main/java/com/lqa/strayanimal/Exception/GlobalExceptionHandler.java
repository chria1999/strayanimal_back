package com.lqa.strayanimal.Exception;

import com.lqa.strayanimal.entity.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

/**
 * controller增强 全局处理异常
 * @author 10411
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(SQLException.class)
    public RespBean sqlException(SQLException sqlException) {
        return RespBean.error("数据库出错");
    }
}
