package com.lqa.strayanimal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lqa.strayanimal.entity.RoleEntity;
import com.lqa.strayanimal.mapper.RoleMapper;
import com.lqa.strayanimal.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author 10411
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<RoleEntity> getAllRoles() {
        return roleMapper.selectList(new LambdaQueryWrapper<>());
    }

    @Override
    public Integer addRole(RoleEntity roleEntity) {
        if (!roleEntity.getName().startsWith("ROLE_")) {
            roleEntity.setName("ROLE_" + roleEntity.getName().toUpperCase());
        }
        return roleMapper.insert(roleEntity);
    }

    @Override
    public Integer updateRole(RoleEntity roleEntity) {
        return roleMapper.updateById(roleEntity);
    }

    @Override
    public Integer deleteRoleById(Integer id) {
        return roleMapper.deleteById(id);
    }

    @Override
    public Integer deleteRolesByIds(Integer[] ids) {
        return roleMapper.deleteBatchIds(Arrays.asList(ids));
    }
}
