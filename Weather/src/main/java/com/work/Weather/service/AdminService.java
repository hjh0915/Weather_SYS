package com.work.Weather.service;

import java.util.List;

import com.work.Weather.entities.User;

public interface AdminService {
    //登录
    public User login(User user);

    //用户信息
    public List<User> list();

    //删除用户
    public Integer deleteUser(String uname);

    //修改用户
    public Integer updateUser(User user);

}