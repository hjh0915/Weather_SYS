package com.work.Weather.mappers;

import com.work.Weather.entities.User;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    // 获取
    @Select("select * from message where uname=#{uname} and upwd=#{upwd}")
    public User getUser(User user);

    // 注册
    @Insert("insert into message(uname, upwd, ucity) values(#{uname}, #{upwd}, #{ucity})")
    public Integer addUser(User user);

    //通过用户姓名取到对应的城市代码
    public User getCode(String uname);

}