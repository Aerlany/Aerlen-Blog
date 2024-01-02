package com.example.controller.util;


import lombok.Data;


//前后端交互的数据模型
@Data
public class DataResponses {
    private Boolean flag = false;
    private Object data;

    public DataResponses(){};

    public DataResponses(Boolean flag){
        this.flag = flag;
    }
    public DataResponses(Boolean flag,Object data){
        this.flag = flag;
        this.data = data;
    }
}
