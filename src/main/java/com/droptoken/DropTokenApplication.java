package com.droptoken;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.droptoken")
public class DropTokenApplication  {
    public static void main(String[] args) {
        SpringApplication.run(DropTokenApplication.class, args);
    }

}
