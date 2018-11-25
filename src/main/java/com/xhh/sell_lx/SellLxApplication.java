package com.xhh.sell_lx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan(basePackages = "com.xhh.sell_lx.dataobject.mapper")
@EnableCaching
public class SellLxApplication {

    public static void main(String[] args) {
        SpringApplication.run(SellLxApplication.class, args);
    }
}
