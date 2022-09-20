package com.amano.springcloudmqproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;

@SpringBootApplication
@RefreshScope
public class SpringcloudMqProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudMqProducerApplication.class, args);
    }

}
