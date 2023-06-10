package com.sen.springbboot;

import com.sen.springbboot.entity.User;
import com.sen.springbboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@SpringBootApplication
public class SpringbbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbbootApplication.class, args);
    }

}
