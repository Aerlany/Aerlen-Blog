package com.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.Pojo.User;


//Service业务层接口通过实现IService接口来简化开发
public interface IUserService extends IService<User> {

    //也可以通过@Override重写方法

}
