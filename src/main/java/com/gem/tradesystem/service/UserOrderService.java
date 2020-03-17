package com.gem.tradesystem.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.tradesystem.entity.User;
import com.gem.tradesystem.entity.UserOrder;
import com.gem.tradesystem.entity.UserOrderCustom;

import java.util.List;

/**
 * @Auther: NoTomato
 * @DATE:2020/3/3 19:43
 * @Description:
 */
public interface UserOrderService {
    Page<UserOrderCustom> SelectAll(Integer curr , Integer limit,Integer status,Integer id);
    Integer completeOrder(Integer id);
    Integer incompleteOrder(Integer id);
    Integer deleteone(Integer id);
    Integer payone(Integer userOrder, User user, Integer money);

}
