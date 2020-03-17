package com.gem.tradesystem.mapper;

import com.gem.tradesystem.entity.Sucai;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface UserCenterMapper {
    @Select("select * from sucai where id in (select sucaiid from fav where userid=#{userId}) order by id desc limit 3")
    List<Sucai> selectCollectById(Integer userId);
    @Select("select count(1) from shopcar where userid = #{userId}")
    Integer selectCartCountById(Integer userId);
}
