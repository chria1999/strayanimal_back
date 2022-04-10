package com.lqa.strayanimal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lqa.strayanimal.entity.AdminEntity;
import com.lqa.strayanimal.entity.RoleEntity;
import com.lqa.strayanimal.mapper.AdminMapper;
import com.lqa.strayanimal.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * @author 10411
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, AdminEntity> implements AdminService, UserDetailsService {

    /**
     * 日志打印
     */
    private final static Logger logger = LoggerFactory.getLogger(AdminServiceImpl.class);

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<AdminEntity> lambdaQueryWrapper = new LambdaQueryWrapper<AdminEntity>();
        lambdaQueryWrapper.eq(AdminEntity::getUsername, username);
        AdminEntity adminEntity = adminMapper.selectOne(lambdaQueryWrapper);
        if (adminEntity == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        adminEntity.setRoleEntityList(adminMapper.getAdminRoleById(adminEntity.getId()));
        return adminEntity;
    }


}
