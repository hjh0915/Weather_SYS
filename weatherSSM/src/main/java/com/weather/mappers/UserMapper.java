package com.weather.mappers;

import com.weather.entities.User;

public interface UserMapper {
    public User getUser(User user);
    public Integer addUser(User user);
    public User getCode(String uname);
}
