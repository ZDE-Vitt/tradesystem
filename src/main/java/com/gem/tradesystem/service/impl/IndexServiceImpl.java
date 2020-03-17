package com.gem.tradesystem.service.impl;

import com.gem.tradesystem.entity.User;
import com.gem.tradesystem.mapper.IndexMapper;
import com.gem.tradesystem.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class IndexServiceImpl implements IndexService {
    @Autowired
    private IndexMapper indexMapper;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Override
    public User login(String telephone, String password) {
        User user  = indexMapper.selectUserByTel(telephone);
        if (user!=null){
            String mysqlPassword = user.getPassword();
            if (encoder.matches(password,mysqlPassword)){
                return user;
            }
        }
        return null;
    }
}
