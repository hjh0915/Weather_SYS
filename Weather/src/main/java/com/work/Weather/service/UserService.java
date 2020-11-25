package com.work.Weather.service;

import com.work.Weather.entities.User;

public interface UserService {
    // 注册
    public Integer reg(User user);

    //登录
    public User login(User user);
    
    //通过用户姓名取到对应的城市代码
    public User getCode(String uname);

}