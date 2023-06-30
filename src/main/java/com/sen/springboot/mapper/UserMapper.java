package com.sen.springboot.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sen.springboot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper
public interface UserMapper extends BaseMapper<User> {

//    @Select("SELECT * FROM user")
//    List<User> showAll();
//
//    @Select("SELECT * FROM user WHERE name LIKE #{name} LIMIT #{pageNum}, #{pageSize}")  //#{}中的参数 = java中的参数
//    List<User> choosePage(@Param("pageNum")Integer pageNum,
//                          @Param("pageSize")Integer pageSize,
//                          @Param("name") String name);
//
//    @Select("select count(*) from user where name like #{name}")
//    Integer totalNum(String name);
//
//
////    @Insert("INSERT INTO user(name, password, phone, address) VALUES(#{name}, #{password}, #{phone}, #{address})")
////    int insert(User user);
//
//    boolean change(User user);
//
//    @Delete("Delete from user where name = #{name}")
//    boolean delete(String name);

}
