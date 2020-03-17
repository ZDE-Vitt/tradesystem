package com.gem.tradesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gem.tradesystem.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserSettingMapper extends BaseMapper<User> {
    //设置用户信息,包括头像
    @Update("update user set username=#{username},sex=#{sex},avatar=#{avatar} where id = #{id}")
    Boolean updateUserByid(Integer id, String username, String sex, String avatar);
    @Update("update user set username=#{username} where id=#{id}")
    Integer modifyUsername(Integer id, String username);
    @Select("select count(1) from user where username=#{username}")
    Integer confirmUsername(String username);
    @Select("select * from user where id=#{id}")
    User selectUserById(Integer id);
    @Update("update user set avatar = #{avatar} where id = #{id}")
    Integer uploadAvatar(Integer id, String avatar);
    @Update("update user set password=#{password} where id = #{id}")
    Boolean updateUPasswordById(Integer id, String password);
}
