package com.sen.springbboot.controller;

import com.sen.springbboot.entity.User;
import com.sen.springbboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController     //控制层
public class UserController {

    @Autowired //注入成员变量
    private UserMapper userMapper;

    @GetMapping("/")
    public List<User> index(){

        return userMapper.showAll();
    }

}
