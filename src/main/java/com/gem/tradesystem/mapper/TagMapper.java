package com.gem.tradesystem.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * @Auther: NoTomato
 * @DATE:2020/3/12 16:39
 * @Description:
 */
@Component
public interface TagMapper {

    @Insert("insert into tagjb (sucaiid,tagid) values (#{suciaid},#{tagid})")
    Integer addInJb(@Param("suciaid")Integer sucaiid ,@Param("tagid")Integer tagid);

    @Insert("insert into tag (typename,pid) values (#{typename},#{pid})")
    Integer addInTag(@Param("typename")String typename ,@Param("pid")Integer pid);

    @Select("select id from tag where typename = #{typename}")
    Integer getid(@Param("typename")String typename);

    @Select("select typename from tag where id = #{id}")
    String getname(@Param("id")Integer id);

}
