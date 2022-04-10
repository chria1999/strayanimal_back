package com.lqa.strayanimal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lqa.strayanimal.entity.MoneyEntity;
import com.lqa.strayanimal.entity.RespPageBean;

/**
 * @author 10411
 */
public interface MoneyService extends IService<MoneyEntity> {

    /**
     * 分页展示金额数据
     * @param page
     * @param size
     * @param moneyEntity
     * @return
     */
    RespPageBean getMoneyByPage(Integer page, Integer size, MoneyEntity moneyEntity);

}
