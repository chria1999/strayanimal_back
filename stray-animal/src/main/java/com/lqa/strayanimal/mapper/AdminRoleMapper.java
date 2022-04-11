package com.lqa.strayanimal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lqa.strayanimal.entity.AdminRoleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 10411
 */
@Mapper
public interface AdminRoleMapper extends BaseMapper<AdminRoleEntity> {

    /**
     * 添加管理员角色
     * @param adminId
     * @param rolesId
     * @return
     */
    Integer addRole(Integer adminId, Integer[] rolesId);
}
