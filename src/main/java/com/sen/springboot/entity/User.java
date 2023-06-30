package com.sen.springboot.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@TableName(value = "user")
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;

    @JsonIgnore
    private String password;
    private String phone;
    private String address;


}
