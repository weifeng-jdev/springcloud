package com.amano.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@MapperScan("com.amano.security.dao")
@RefreshScope
public class SpringcloudAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudAuthApplication.class, args);
    }

}
