package com.lqa.strayanimal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lqa.strayanimal.entity.AdminEntity;

import java.util.List;

/**
 * @author 10411
 */
public interface AdminService extends IService<AdminEntity> {

    /**
     * 返回除登录外的所有管理员
     * @param keywords
     * @return
     */
    public List<AdminEntity> getAllAdmins(String keywords);

    /**
     * 更新管理员信息
     * @param adminEntity
     * @return
     */
    public Integer updateAdmin(AdminEntity adminEntity);

    /**
     * 更新管理员的角色信息
     * @param adminId
     * @param rolesId
     * @return
     */
    public boolean updateAdminRole(Integer adminId, Integer[] rolesId);

    /**
     * 根据id删除管理员
     * @param id
     * @return
     */
    public Integer deleteAdminById(Integer id);

    /**
     * 添加管理员
     * @param adminEntity
     * @return
     */
    public Integer addAdmin(AdminEntity adminEntity);
}
