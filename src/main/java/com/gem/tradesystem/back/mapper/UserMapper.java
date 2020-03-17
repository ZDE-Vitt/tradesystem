package com.gem.tradesystem.back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gem.tradesystem.back.entity.SysUser;
import com.gem.tradesystem.back.entity.SysUserCustom;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: NoTomato
 * @DATE:2020/2/25 13:53
 * @Description:
 */
@Component
public interface UserMapper extends BaseMapper<SysUser> {

    @Select("SELECT * FROM user_role r right join sys_user u on r.user_id = u.id where del_flag = 0 and username like concat('%',#{likename},'%') limit #{curr},#{limit}")
    List<SysUserCustom> selectAll (@Param("curr") Integer curr, @Param("limit") Integer limit, @Param("likename") String likename);

    @Delete("delete from sys_user_role where sys_user_id = #{value}")
    Integer deleteUser_Role(Integer id);

    @Insert("insert into sys_user_role (sys_user_id,sys_role_id) values (#{user},#{role})")
    Integer insertUser_Role(@Param("user") Integer user_id, @Param("role") Integer role_id);

    @Select("select sys_role_id from sys_user_role where sys_user_id = #{value}")
    Integer selectoneUser_Role(Integer id);

    @Update("update sys_user_role set sys_role_id = #{role} where sys_user_id = #{user}")
    Integer updateUser_Role(@Param("user") Integer user_id, @Param("role") Integer role_id);

}
