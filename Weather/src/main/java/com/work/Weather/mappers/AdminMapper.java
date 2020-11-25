package com.work.Weather.mappers;

import java.util.List;

import com.work.Weather.entities.User;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdminMapper {

    // 管理员登录
    @Select("select * from message where uname=#{uname} and upwd=#{upwd}")
    public User getAdmin(User user);

    // 分页展示User
    @Select("select * from message")
    public List<User> listUser();

    // 删除User
    @Delete("delete from message where uname=#{uname}")
    public Integer deleteUser(@Param(value = "uname") String uname);

    // 修改User
    @Update("update message set upwd=#{upwd}, ucity=#{ucity} where uname=#{uname}")
    public Integer updateUser(User user);

}