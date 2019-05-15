package com.yuanyuan.smp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages= {"com.yuanyuan.smp.mapper"})
public class SmpApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmpApplication.class, args);
        System.out.println("aaa");
        System.out.println("aaa");
        System.out.println("aaa");
        System.out.println("aaa");
        System.out.println("aaa");
        System.out.println("ccc");
    }

}
