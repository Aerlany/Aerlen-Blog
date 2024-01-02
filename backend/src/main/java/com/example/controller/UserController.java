package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.Pojo.User;
import com.example.controller.util.DataResponses;
import com.example.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 使用统一的数据模型进行前后端数据交互
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    //get查询
    @GetMapping
    public DataResponses getAll(){
        return new DataResponses(true,userService.list());
    }

    //post添加
    @PostMapping
    public DataResponses save(@RequestBody User user) {
        //简化写法
        return new DataResponses(userService.save(user));
    }

    //put修改
    @PutMapping
    public DataResponses update(@RequestBody User user){
        return new DataResponses(userService.updateById(user));
    }

    //delete删除
    @DeleteMapping("{id}")
    public DataResponses delete(@PathVariable int id){
        return new DataResponses(userService.removeById(id));
    }

    //按值查找
    @GetMapping("{id}")
    public DataResponses selectById(@PathVariable int id){
        return new DataResponses(true,userService.getById(id));
    }

    //登录接口
    @PostMapping("/addUser")
    public DataResponses getOne(@RequestBody User user){

        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getUsername,user.getUsername()).eq(User::getPassword,user.getPassword());

        return new DataResponses(true,userService.getMap(userLambdaQueryWrapper));
    }


}
