package com.example.test3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class Test3Application {

    public static void main(String[] args) {
        SpringApplication.run(Test3Application.class, args);
    }

}
