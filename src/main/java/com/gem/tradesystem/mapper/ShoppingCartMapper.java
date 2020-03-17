package com.gem.tradesystem.mapper;

import com.gem.tradesystem.entity.Sucai;
import com.gem.tradesystem.entity.UserOrder;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
@Mapper
public interface ShoppingCartMapper {
    //查询购物车
    @Select("select * from sucai where id in (select suCaiId from shopcar where userId = #{uid}) ")
    List<Sucai> selectShoppingCarByUserId(@Param("uid") Integer uid);
    @Select("select count(1) from sucai where id in (select suCaiId from shopcar where userId = #{uid})")
    Integer selectCarCountByUid(Integer uid);
    @Delete("delete from shopcar where suCaiId = #{suCaiId}")
    Boolean deleteBySid(Integer suCaiId);

    Integer deleteByIds(List<Integer> ids);
    @Select("select count(1) from shopcar where sucaiid = #{id} and userid=#{uid}")
    Integer selectCollectById(Integer id, Integer uid);
    @Insert("insert into fav (sucaiid,userid) values(#{id},#{uid})")
    Integer insertIntoCollect(Integer id, Integer uid);

    Integer moveToBuyHistory(List<UserOrder> list);
    @Update("update user set account=#{account} where id = #{uid}")
    void minusAccount(Integer account, Integer uid);
}
