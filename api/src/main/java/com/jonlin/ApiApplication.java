package com.jonlin;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.jonlin.mapper")
public class ApiApplication {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(ApiApplication.class);
        logger.info("程序开始启动");
        SpringApplication.run(ApiApplication.class, args);
        logger.info("程序启动完成");
    }

}
