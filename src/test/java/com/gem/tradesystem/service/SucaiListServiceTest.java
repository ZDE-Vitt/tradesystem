package com.gem.tradesystem.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Auther: NoTomato
 * @DATE:2020/3/12 20:11
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class SucaiListServiceTest {

    @Autowired
    private SucaiListService sucaiListService;

    @Test
    void selectList() {
        System.out.println("shenhenum===============>" + sucaiListService.getNum(25).get("shenhenum"));
        System.out.println("inpassnum===============>" + sucaiListService.getNum(25).get("inpassnum"));
        System.out.println("passnum===============>" + sucaiListService.getNum(25).get("passnum"));
    }

    @Test
    void sucaiupload() {
    }

    @Test
    void shenHeNum() {
    }

    @Test
    void passNum() {
    }

    @Test
    void inpassNum() {
    }

    @Test
    void getNum() {
    }
}