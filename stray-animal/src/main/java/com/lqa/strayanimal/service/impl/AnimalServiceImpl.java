package com.lqa.strayanimal.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lqa.strayanimal.entity.AnimalEntity;
import com.lqa.strayanimal.mapper.AnimalMapper;
import com.lqa.strayanimal.service.AnimalService;
import org.springframework.stereotype.Service;

/**
 * @author 10411
 */
@Service
public class AnimalServiceImpl extends ServiceImpl<AnimalMapper, AnimalEntity> implements AnimalService {
}
