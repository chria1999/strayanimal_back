package com.lqa.strayanimal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 * @author 10411
 */
@SpringBootApplication
@MapperScan("com.lqa.strayanimal.mapper")
public class StrayAnimalApplication {

    public static void main(String[] args) {
        SpringApplication.run(StrayAnimalApplication.class, args);
    }

}
