package com.gem.tradesystem.mapper;

import com.gem.tradesystem.entity.Sucai;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CollectMapper {
    //收藏
    @Select("select count(1) from sucai where id in (select sucaiid from fav where userid = #{uid})")
    Integer selectFavCountByUid(Integer uid);
    @Select("select * from sucai where id in (select sucaiid from fav where userid = #{uid})")
    List<Sucai> selectFavByUid(Integer uid);
}
