package com.sen.springboot.service;

import com.sen.springboot.entity.User;
import com.sen.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int update(User user){

        if(user.getId() != null){
            return userMapper.change(user);
        }else{
            return userMapper.insert(user);
        }
    }

}
