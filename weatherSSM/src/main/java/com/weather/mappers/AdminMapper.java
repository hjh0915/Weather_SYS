package com.weather.mappers;

import java.util.List;

import com.weather.entities.User;

import org.apache.ibatis.annotations.Param;

public interface AdminMapper {
    public User getAdmin(User user);
    public List<User> listUser();
    public Integer deleteUser(@Param(value="uname") String uname);
    public Integer updateUser(User user);
}