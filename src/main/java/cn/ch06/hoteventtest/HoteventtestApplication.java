package cn.ch06.hoteventtest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan({"cn.ch06.hoteventtest.mapper"})
@SpringBootApplication
public class HoteventtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(HoteventtestApplication.class, args);
    }

}
