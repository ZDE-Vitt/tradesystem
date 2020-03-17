package com.gem.tradesystem.mapper;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Auther: NoTomato
 * @DATE:2020/3/12 08:55
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class JifengMapperTest {

    @Autowired
    JifengMapper jifengMapper;

    @Test
    void getJifeng() {
        jifengMapper.getJifeng();
    }

    @Test
    void getJifengById() {
    }
}