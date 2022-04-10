package com.lqa.strayanimal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lqa.strayanimal.entity.RoleEntity;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * @author 10411
 */
public interface RoleService extends IService<RoleEntity> {

    /**
     * 取得所有角色列表
     * @return
     */
    public List<RoleEntity> getAllRoles();

    /**
     * 添加角色
     * @param roleEntity
     * @return
     */
    public Integer addRole(RoleEntity roleEntity);

    /**
     * 更新角色
     * @param roleEntity
     * @return
     */
    public Integer updateRole(RoleEntity roleEntity);

    /**
     * 通过id删除角色
     * @param id
     * @return
     */
    public Integer deleteRoleById(Integer id);

    /**
     * 删除选中角色
     * @param ids
     * @return
     */
    public Integer deleteRolesByIds(Integer[] ids);
}
