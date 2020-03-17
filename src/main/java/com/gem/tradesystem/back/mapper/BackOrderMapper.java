package com.gem.tradesystem.back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gem.tradesystem.back.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: NoTomato
 * @DATE:2020/3/2 12:24
 * @Description:
 */
@Component
public interface BackOrderMapper extends BaseMapper<Order> {

    @Select("SELECT u.id,u.userid,u.orderid,s.num sucaiid,u.createTime,u.order_Status,u.del_Flag FROM user_order u left join sucai s on u.sucaiid = s.id where u.del_Flag = 0 limit #{curr},#{limit}")
    List<Order> selectordercuslist(@Param("curr")Integer curr , @Param("limit")Integer limit);
}
