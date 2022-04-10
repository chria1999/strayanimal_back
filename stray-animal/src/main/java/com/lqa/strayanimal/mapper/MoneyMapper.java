package com.lqa.strayanimal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lqa.strayanimal.entity.MoneyEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * @author 10411
 */
@Mapper
public interface MoneyMapper extends BaseMapper<MoneyEntity> {

    /**
     * 分页查询资金记录
     * @param page
     * @param size
     * @param moneyEntity
     * @return
     */
    List<MoneyEntity> getMoneyByPage(@Param("page") Integer page, @Param("size") Integer size, MoneyEntity moneyEntity);
}
