package com.lqa.strayanimal.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lqa.strayanimal.entity.AnimalEntity;

/**
 * @author 10411
 */
public interface AnimalService extends IService<AnimalEntity> {

    /**
     * 通过id删除动物
     * @param id
     * @return
     */
    public Integer deleteAnimalById(Integer id);

    /**
     * 更新动物
     * @param animalEntity
     * @return
     */
    public Integer updateAnimal(AnimalEntity animalEntity);

    /**
     * 添加动物
     * @param animalEntity
     * @return
     */
    public Integer addAnimal(AnimalEntity animalEntity);
}
