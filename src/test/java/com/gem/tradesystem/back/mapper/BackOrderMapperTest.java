package com.gem.tradesystem.back.mapper;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Auther: NoTomato
 * @DATE:2020/3/11 17:56
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class BackOrderMapperTest {

    @Autowired
    private BackOrderMapper backOrderMapper;

    @Test
    void selectordercuslist() {
        System.out.println(backOrderMapper.selectordercuslist(0,5));
    }
}