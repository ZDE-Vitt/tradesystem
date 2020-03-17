package com.gem.tradesystem.mapper;

import com.gem.tradesystem.back.mapper.UserMapper;
import com.gem.tradesystem.entity.UserOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Auther: NoTomato
 * @DATE:2020/3/5 14:45
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class UserOrderMapperTest {

    @Autowired
    private UserOrderMapper userOrderMapper;

    @Test
    void selectAll() {
        System.out.println(userOrderMapper.selectAll(1,5,1,25));
    }

}