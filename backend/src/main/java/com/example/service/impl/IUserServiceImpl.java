package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.Pojo.User;
import com.example.dao.UserMapper;
import com.example.service.IUserService;
import org.springframework.stereotype.Service;


/**
 * IUserService实现类
 * 1.继承ServiceImpl类（需要两个泛型 1.需要Mapper接口 2.对象实体类）
 * 2.实现IUserService
 */
@Service
public class IUserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
