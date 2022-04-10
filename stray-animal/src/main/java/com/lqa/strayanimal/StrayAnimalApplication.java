package com.lqa.strayanimal;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 启动类
 * @author 10411
 */
@SpringBootApplication
@MapperScan("com.lqa.strayanimal.mapper")
@EnableCaching
@EnableScheduling
public class StrayAnimalApplication {

    public static void main(String[] args) {
        SpringApplication.run(StrayAnimalApplication.class, args);
    }

}
