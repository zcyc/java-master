package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper extends Mapper<User> {


    @Select("SELECT * FROM user WHERE username = #{username} AND password = #{passwordEncrypted}")
    User findByUsernameAndPassword(@Param("username") String username, @Param("passwordEncrypted") String passwordEncrypted);
}