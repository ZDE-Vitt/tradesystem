package com.gem.tradesystem.back.service.impl;

import com.gem.tradesystem.back.service.BackOrderService;
import com.gem.tradesystem.mapper.UserOrderMapper;
import com.gem.tradesystem.service.UserOrderService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Auther: NoTomato
 * @DATE:2020/3/9 09:33
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class BackOrderServiceImplTest {

    @Autowired
    private BackOrderService backOrderService;


    @Test
    void selectList() {
        System.out.println("list=============>");
        backOrderService.selectList(1,6).getRecords().forEach(System.out::println);

    }

    @Test
    void deleteList() {
        System.out.println("list=============>");
        backOrderService.selectDeleteList("19970701","19970701","","").forEach(System.out::println);
    }
    @Test
    void deletedList() {
        System.out.println("list=============>");
        backOrderService.deleteList(backOrderService.selectDeleteList("19970701","20201010","",""));
    }

    @Test
    void date() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyMMddHHmm");
        System.out.println("date=============>" + new SimpleDateFormat("yyMMddHHmm").format(new Date()));
    }

}