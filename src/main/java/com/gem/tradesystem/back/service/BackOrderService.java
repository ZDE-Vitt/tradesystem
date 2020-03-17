package com.gem.tradesystem.back.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.tradesystem.back.entity.Order;

import java.util.List;

/**
 * @Auther: NoTomato
 * @DATE:2020/2/25 15:15
 * @Description:
 */
public interface BackOrderService {
    Page<Order> selectList(Integer curr, Integer limit);
    Integer deleteone(Integer id);
    List<Order> selectDeleteList(String dateStart,String dateEnd,String sucaiId,String userId);
    Integer deleteList(List<Order> list);
}
