package com.lqa.strayanimal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lqa.strayanimal.entity.MenuEntity;
import com.lqa.strayanimal.mapper.MenuMapper;
import com.lqa.strayanimal.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 10411
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, MenuEntity> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;


    /**
     * 获得所有url所需的角色
     * @return
     */
    @Override
    public List<MenuEntity> getAllMenusWithRole() {
        return null;
    }
}
