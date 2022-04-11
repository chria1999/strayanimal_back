package com.lqa.strayanimal.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lqa.strayanimal.entity.AdminEntity;
import com.lqa.strayanimal.entity.RoleEntity;
import com.lqa.strayanimal.mapper.AdminMapper;
import com.lqa.strayanimal.mapper.AdminRoleMapper;
import com.lqa.strayanimal.service.AdminService;
import com.lqa.strayanimal.utils.AdminUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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

    @Autowired
    private AdminRoleMapper adminRoleMapper;

    @Override
    public Integer updateAdmin(AdminEntity adminEntity) {
        return adminMapper.update(adminEntity, new LambdaQueryWrapper<>());
    }

    @Override
    public List<AdminEntity> getAllAdmins(String keywords) {
        LambdaQueryWrapper<AdminEntity> lambdaQueryWrapper = new LambdaQueryWrapper<AdminEntity>();
        lambdaQueryWrapper.ne(AdminEntity::getId, AdminUtils.getCurrentAdmin().getId());
        if (keywords != "") {
            lambdaQueryWrapper.like(AdminEntity::getUsername, keywords);
        }
        List<AdminEntity> allAdmins = adminMapper.selectList(lambdaQueryWrapper);
        return allAdmins;
    }

    @Override
    @Transactional
    public boolean updateAdminRole(Integer adminId, Integer[] rolesId) {
        adminRoleMapper.deleteById(adminId);
        return adminRoleMapper.addRole(adminId, rolesId) == rolesId.length;

    }

    @Override
    public Integer deleteAdminById(Integer id) {
        return adminMapper.deleteById(id);
    }

    @Override
    public Integer addAdmin(AdminEntity adminEntity) {
        /**
         * todo 添加成功发送邮件
         */
        return 0;
    }



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
