package com.weather.service;

import java.util.List;

import com.weather.entities.User;

public interface AdminService {
    public User login(User user);
    public List<User> list();
    public Integer deleteUser(String uname);
    public Integer updateUser(User user);
}