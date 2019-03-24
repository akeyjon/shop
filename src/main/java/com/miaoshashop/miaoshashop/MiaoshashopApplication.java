package com.miaoshashop.miaoshashop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.miaoshashop.miaoshashop"})
@MapperScan("com.miaoshashop.miaoshashop.dao")
@EnableSwagger2
public class MiaoshashopApplication {


    public static void main(String[] args) {
        SpringApplication.run(MiaoshashopApplication.class, args);
    }

}
