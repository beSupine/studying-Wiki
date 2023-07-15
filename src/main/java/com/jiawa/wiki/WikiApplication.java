package com.jiawa.wiki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class WikiApplication {

    public static void main(String[] args) {

        try (ConfigurableApplicationContext context = SpringApplication.run(WikiApplication.class, args)) {
            // 在这里编写需要执行的代码
            System.out.println("begin");
        }
    }

}
