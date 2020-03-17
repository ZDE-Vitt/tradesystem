package com.gem.tradesystem.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

@Mapper
public interface RegMapper {
    @Insert("insert into user (username,password,telephone,regTime) values (#{username},#{password},#{telephone},#{regTime})")
    boolean insertUser(String username, String password, String telephone, Date regTime);
    @Select("select count(1) from user where telephone=#{telephone}")
    Integer selectTelephone(String telephone);
    @Select("select count(1) from user where username=#{username}")
    Integer selectUsername(String username);
}
