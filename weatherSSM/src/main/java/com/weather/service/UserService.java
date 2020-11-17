package com.weather.service;

import com.weather.entities.User;

public interface UserService {
    public User login(User user);
    public Integer reg(User user);
    public User getCode(String uname);
}
