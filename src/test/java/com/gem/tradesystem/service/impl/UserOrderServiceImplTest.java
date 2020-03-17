package com.gem.tradesystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.tradesystem.entity.UserOrder;
import com.gem.tradesystem.entity.UserOrderCustom;
import com.gem.tradesystem.service.UserOrderService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Auther: NoTomato
 * @DATE:2020/3/3 20:02
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class UserOrderServiceImplTest {

    @Autowired
    private UserOrderService userOrderService;

    @Test
    void selectAll() {
        Page<UserOrderCustom> userOrderPage = userOrderService.SelectAll(1,5,0,25);
        System.out.println("getRecords : ");
        userOrderPage.getRecords().forEach(System.out::println);
        System.out.println("getSize : "+userOrderPage.getSize());
        System.out.println("getCurrent : "+userOrderPage.getCurrent());
        System.out.println("getOrders : "+userOrderPage.getOrders());
        System.out.println("getTotal : "+userOrderPage.getTotal());
    }


    @Test
    void completeOrder() {
    }

    @Test
    void incompleteOrder() {
    }

    @Test
    void deleteone() {
    }
}