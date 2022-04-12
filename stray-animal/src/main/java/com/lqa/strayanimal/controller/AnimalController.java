package com.lqa.strayanimal.controller;

import com.lqa.strayanimal.entity.AnimalEntity;
import com.lqa.strayanimal.entity.RespBean;
import com.lqa.strayanimal.entity.RespPageBean;
import com.lqa.strayanimal.service.AnimalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/")
    @ApiOperation(value = "添加动物")
    public RespBean addAnimal(@RequestBody AnimalEntity animalEntity) {
        /**
         * todo
         */
        if (animalService.addAnimal(animalEntity) == 1) {

        }
        return null;
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除动物")
    public RespBean deleteAnimalById(@PathVariable("id") Integer id) {
        if (animalService.deleteAnimalById(id) == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.error("删除失败");
    }

    @PutMapping("/")
    @ApiOperation(value = "更新动物")
    public RespBean updateAnimal(@RequestBody AnimalEntity animalEntity) {
        if (animalService.updateAnimal(animalEntity) == 1) {
            return RespBean.ok("更新成功");
        }
        return RespBean.error("更新失败");
    }



}
