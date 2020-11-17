package com.weather.service.Impl;

import com.weather.entities.User;
import com.weather.mappers.UserMapper;
import com.weather.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User login(User user) {
        return userMapper.getUser(user);
    }

    public Integer reg(User user) {
        return userMapper.addUser(user);
    }

    public User getCode(String uname) {
        return userMapper.getCode(uname);
    }
}
