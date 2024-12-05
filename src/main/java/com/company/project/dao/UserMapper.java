package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;

public interface UserMapper extends Mapper<User> {

    @Insert("INSERT INTO users (username, password, nick_name, sex, register_date) VALUES (#{username}, #{password}, #{nickName}, #{sex}, #{registerDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertUser(User user);
}