package com.sen.springbboot.mapper;


import com.sen.springbboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM sys_users")
    List<User> showAll();
}
