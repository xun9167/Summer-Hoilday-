package com.zut.gds;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.zut.gds.mapper")
public class GdsApplication {

    public static void main(String[] args) {
        SpringApplication.run(GdsApplication.class, args);
    }

}
