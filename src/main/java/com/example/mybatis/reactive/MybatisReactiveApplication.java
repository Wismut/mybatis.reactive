package com.example.mybatis.reactive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pro.chenggang.project.reactive.mybatis.support.r2dbc.spring.annotation.R2dbcMapperScan;

@SpringBootApplication
@R2dbcMapperScan("com.example.mybatis.reactive.mapper")
public class MybatisReactiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisReactiveApplication.class, args);
    }

}
