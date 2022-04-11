package com.lqa.strayanimal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lqa.strayanimal.entity.MenuRoleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 10411
 */
@Mapper
public interface MenuRoleMapper extends BaseMapper<MenuRoleEntity> {

    /**
     * 添加角色菜单
     * @param roleId
     * @param menuIds
     * @return
     */
    Integer addMenuRole(Integer roleId, Integer[] menuIds);
}
