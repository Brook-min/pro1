package com.dexian.pro1.pro1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@MapperScan("com.dexian.pro1.dao")
@ComponentScan(basePackages = "com.dexian.pro1.*")
public class Pro1Application {

    public static void main(String[] args) {
        SpringApplication.run(Pro1Application.class, args);
    }

}
