package com.augo.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.aguo.demo.filter")
public class DemoCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoCrudApplication.class, args);
    }

}
