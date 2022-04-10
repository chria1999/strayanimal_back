package com.lqa.strayanimal.controller;

import com.lqa.strayanimal.entity.AnimalEntity;
import com.lqa.strayanimal.entity.RespPageBean;
import com.lqa.strayanimal.service.AnimalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 10411
 */
@RestController
@Api(tags = "动物")
@RequestMapping("/animal/info")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    /**
     * todo 分页查询
     * @param page
     * @param size
     * @param animalEntity
     * @return
     */
    @GetMapping("/")
    @ApiOperation(value = "分页查询")
    public RespPageBean getAnimalByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, AnimalEntity animalEntity) {
        return null;
    }

}
