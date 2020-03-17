package com.gem.tradesystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gem.tradesystem.entity.UserOrder;
import com.gem.tradesystem.entity.UserOrderCustom;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: NoTomato
 * @DATE:2020/3/3 19:42
 * @Description:
 */
@Component
public interface UserOrderMapper extends BaseMapper<UserOrder> {

    //order_Status = #{status} 获取已付款
    @Select("SELECT d.id,d.orderid,d.sucaiid sucaiid, d.userid,d.createTime,d.order_Status,d.del_Flag,s.money sucaiMoney,s.name sucainame,s.picurl FROM user_order d left join sucai s on s.id = d.sucaiid where d.order_Status = #{status} and d.userid = #{userid} and d.del_Flag = '0' order by d.createtime desc limit #{curr},#{limit}")
    List<UserOrderCustom> selectAllcom(@Param("curr")Integer curr ,@Param("limit")Integer limit,@Param("status")Integer status,@Param("userid")Integer id);

    //order_Status <> #{status} 获取未付款，和所有
    @Select("SELECT d.id,d.orderid,d.sucaiid sucaiid, d.userid,d.createTime,d.order_Status,d.del_Flag,s.money sucaiMoney,s.name sucainame,s.picurl FROM user_order d left join sucai s on s.id = d.sucaiid where order_Status <> #{status} and d.userid = #{userid} and d.del_Flag = '0' order by d.createtime desc limit #{curr},#{limit}")
    List<UserOrderCustom> selectAll(@Param("curr")Integer curr ,@Param("limit")Integer limit,@Param("status")Integer status ,@Param("userid")Integer id);


    @Select("select a.orderid from (SELECT ord.id,ord.orderid,ord.del_Flag,tag.ptype FROM user_order ord left join sucai_tag tag on ord.sucaiid = tag.sucaiid ) a where del_Flag = '0' group by a.orderid having count(a.orderid) >1")
    List<Integer> getRep();

    @Select("select sucaiType from(SELECT d.id,d.orderid,d.userid,d.createTime,d.order_Status orderStatus,d.del_Flag,a.sucaiid,c.typename sucaiType FROM user_order d left join tagjb a on d.sucaiid = a.sucaiid left join tag b on a.tagid = b.id left join tag c on c.id = b.pid) rep where rep.orderid = #{value} and del_Flag = '0' ")
    List<String> getType(Integer id);

    @Select("select a.orderid from (SELECT ord.id,ord.orderid,ord.del_Flag,tag.ptype FROM user_order ord left join sucai_tag tag on ord.sucaiid = tag.sucaiid ) a where del_Flag = '0' group by a.orderid having count(a.orderid) =1")
    List<Integer> singleId();

    @Select("SELECT name FROM sys_dict where value= #{value} and typecode = 'orderStatus'")
    String getStatus(Integer id);

    @Select("SELECT count(id) FROM user_order where order_Status = 3 and userid = #{userid} and del_Flag = '0' ")
    Integer completeOrder(@Param("userid")Integer id);

    @Select("SELECT count(id) FROM user_order where order_Status <> 3 and userid = #{userid} and del_Flag = '0' ")
    Integer incompleteOrder(@Param("userid")Integer id);
}
