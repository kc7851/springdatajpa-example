package com.skc.springdatajpaexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//원래는 @configuration에 @EnableJpaRepositories를 넣어야 하지만 boot에서는 자동 설정해주어서 안해주어도 됨.
//@EnableJpaRepositories
@Import(KiChangRegistrar.class)
public class SpringdatajpaExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringdatajpaExampleApplication.class, args);
    }

}
