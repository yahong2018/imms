package com.zhxh.imms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.zhxh.*")
public class ImmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ImmsApplication.class, args);
    }
}
