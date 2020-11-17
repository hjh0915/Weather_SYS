package com.weather.service.Impl;

import java.util.List;

import com.weather.entities.User;
import com.weather.mappers.AdminMapper;
import com.weather.service.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminMapper adminMapper;

    public User login(User user) {
        return adminMapper.getAdmin(user);
    }

    public List<User> list() {
        return adminMapper.listUser();
    }

    public Integer deleteUser(String uname) {
        return adminMapper.deleteUser(uname);
    }

    public Integer updateUser(User user) {
        return adminMapper.updateUser(user);
    }
}