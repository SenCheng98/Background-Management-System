package com.sen.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data

public class User {

    private Integer id;
    private String name;

    @JsonIgnore
    private String password;
    private String phone;
    private String address;


}
