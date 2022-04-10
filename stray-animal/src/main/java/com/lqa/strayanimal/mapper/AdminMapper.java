package com.lqa.strayanimal.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lqa.strayanimal.entity.AdminEntity;
import com.lqa.strayanimal.entity.RoleEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 10411
 */
@Mapper
public interface AdminMapper extends BaseMapper<AdminEntity> {

    /**
     * 返回该管理员所有角色
     * @param adminId
     * @return
     */
    List<RoleEntity> getAdminRoleById(int adminId);
}
