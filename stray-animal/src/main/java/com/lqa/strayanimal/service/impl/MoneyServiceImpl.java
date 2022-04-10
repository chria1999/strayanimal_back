package com.lqa.strayanimal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lqa.strayanimal.entity.MoneyEntity;
import com.lqa.strayanimal.entity.RespPageBean;
import com.lqa.strayanimal.mapper.MoneyMapper;
import com.lqa.strayanimal.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 10411
 */
@Service
public class MoneyServiceImpl extends ServiceImpl<MoneyMapper, MoneyEntity> implements MoneyService {

    @Autowired
    MoneyMapper moneyMapper;


    @Override
    public RespPageBean getMoneyByPage(Integer page, Integer size, MoneyEntity moneyEntity) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<MoneyEntity> moneyEntityList = moneyMapper.getMoneyByPage(page, size, moneyEntity);
        Long total = moneyMapper.selectCount(new LambdaQueryWrapper<>());
        RespPageBean respPageBean = new RespPageBean();
        respPageBean.setData(moneyEntityList);
        respPageBean.setTotal(total);
        return respPageBean;
    }

}
