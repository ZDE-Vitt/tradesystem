package com.gem.tradesystem.mapper;

import com.gem.tradesystem.entity.Sucai;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BuyHistoryMapper {
    @Select("select * from sucai where id in (select sucaiid from  user_order where userid = #{uid} and order_Status=3 or order_Status=4)")
    List<Sucai> selectBuyHistoryByUserId(@Param("uid") Integer uid);
    @Select("select count(1) from sucai where id in (select sucaiid from user_order where userid = #{uid} and order_Status=3 or order_Status=4)")
    Integer selectBuyHistoryCountByUid(Integer uid);
}
