package com.lqa.strayanimal.controller;

import com.lqa.strayanimal.entity.RespPageBean;
import com.lqa.strayanimal.service.MoneyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 10411
 */
@RestController
@RequestMapping("/money/info")
@Api(tags = "资金记录")
public class MoneyController {

    @Autowired
    private MoneyService moneyService;

    @GetMapping("/")
    @ApiOperation(value = "分页查询资金记录")
    public RespPageBean getMoneyByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {
        /**
         * todo
         */
        return null;
    }
}
