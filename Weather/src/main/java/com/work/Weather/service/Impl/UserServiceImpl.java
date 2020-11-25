package com.work.Weather.service.Impl;

import com.work.Weather.entities.User;
import com.work.Weather.mappers.UserMapper;
import com.work.Weather.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public Integer reg(User user) {
        return userMapper.addUser(user);
    }

    public User login(User user) {
        return userMapper.getUser(user);
    }

    public User getCode(String uname) {
        return userMapper.getCode(uname);
    }
}