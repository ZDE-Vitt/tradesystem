package com.gem.tradesystem.service.impl;

import com.gem.tradesystem.mapper.RegMapper;
import com.gem.tradesystem.service.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RegServiceImpl implements RegService {
    @Autowired
    private RegMapper regMapper;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    @Override
    public boolean insertUser(String password, String telephone, String username) {
        password = encoder.encode(password);
        Date regTime = new Date();
        boolean flag = regMapper.insertUser(username, password, telephone, regTime);
        return flag;
    }

    @Override
    public Boolean verifyTel(String telephone) {
        Integer count = regMapper.selectTelephone(telephone);
        if (count>0){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Boolean verifyUsername(String username) {
        Integer count = regMapper.selectUsername(username);
        if (count>0){
            return false;
        }else{
            return true;
        }
    }
}
