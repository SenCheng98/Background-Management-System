package com.sen.springboot.controller;

import com.sen.springboot.entity.User;
import com.sen.springboot.mapper.UserMapper;
import com.sen.springboot.service.UserService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController     //控制层
@RequestMapping("/user")    //给接口加前缀

public class UserController {

    @Autowired
    private UserService userService;

    @Autowired //注入成员变量
    private UserMapper userMapper;


    @PostMapping //增/改
    public Integer save(@RequestBody User user){ //@RequestBody,将前台的json数据解析到对象中
        return userService.update(user);
    }


    //查
    //分页查询接口,接口路径 /user/page?pageNum=1&pageSize=10
    //@RequestPara 接收前台pageNum和pageSize参数
    // sql 语句，select * from user limit N M ---> N表示第N-1行的数据，M表示查询的行数
    @GetMapping("/page")
    public Map<String, Object> pageInfo(@RequestParam Integer pageNum,
                                        @RequestParam Integer pageSize,
                                        @RequestParam String name){
        pageNum = (pageNum - 1) * pageSize;

        name = "%" + name + "%";
        List<User> data = userMapper.selectPage(pageNum,pageSize,name);
        Integer total = userMapper.totalNum(name);

        Map<String, Object> res = new HashMap<>();
        res.put("total", total);
        res.put("data", data);

        return res;
    }

//    //查询所有
//    @GetMapping
//    public List<User> info(){
//        return userMapper.showAll();
//    }

    @DeleteMapping("/{name}")
    public Integer delete(@PathVariable String name){
        return userMapper.delete(name);
    }

}
