package com.lqa.strayanimal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lqa.strayanimal.entity.Meta;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 10411
 */
@Mapper
public interface MetaMapper extends BaseMapper<Meta> {

    /**
     * 通过id取得meta属性
     * @param adminId
     * @param menuId
     * @return
     */
    public Meta getMetaById(Integer adminId, Integer menuId);

    /**
     * 通过id取得meta属性
     * @param adminId
     * @param menuId
     * @return
     */
    public Meta getMetasById(Integer adminId, Integer menuId);
}
