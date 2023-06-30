package com.sen.springboot.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sen.springboot.entity.User;
import com.sen.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service()
public class UserService extends ServiceImpl<UserMapper,User> {

//    @Autowired
//    private UserMapper userMapper;

    public boolean saveUser(User user){

//        if(user.getId() != null){
//
//            return save(user);
//        }else{
//            return updateById(user);
//        }

        return saveOrUpdate(user);  //mybatis-plus 提供的方法，插入数据

    }

}
