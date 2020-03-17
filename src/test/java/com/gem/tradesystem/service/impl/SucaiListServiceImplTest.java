package com.gem.tradesystem.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.tradesystem.entity.Sucai;
import com.gem.tradesystem.service.SucaiListService;
import com.gem.tradesystem.service.SucaiService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Auther: NoTomato
 * @DATE:2020/3/11 22:52
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class SucaiListServiceImplTest {

    @Autowired
    private SucaiListService sucaiListService;

    @Test
    void selectList() {
        Page<Sucai> page = sucaiListService.selectList(0,5,3,25);
        System.out.println("page.getRecords()================>" + page.getRecords());
        System.out.println("page.getCurrent()================>" + page.getCurrent());
        System.out.println("page.getTotal()================>" + page.getTotal());
    }
}