package com.gem.tradesystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gem.tradesystem.entity.Sucai;
import com.gem.tradesystem.mapper.UserCenterMapper;
import com.gem.tradesystem.service.UserCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCenterServiceImpl implements UserCenterService {
    @Autowired
    private UserCenterMapper userCenterMapper;


    @Override
    public List<Sucai> selectCollectById(Integer userId) {

        return userCenterMapper.selectCollectById(userId);
    }

    @Override
    public Integer selectCartCountById(Integer userId) {
        return userCenterMapper.selectCartCountById(userId);
    }
}
