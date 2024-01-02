package com.example.Pojo;


import lombok.Data;

//lombok简化开发
@Data
public class User {

    private int id;
    private String username;
    private String password;
    private String description;

}