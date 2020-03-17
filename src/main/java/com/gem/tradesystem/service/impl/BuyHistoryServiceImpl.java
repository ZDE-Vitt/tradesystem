package com.gem.tradesystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.tradesystem.entity.Sucai;
import com.gem.tradesystem.mapper.BuyHistoryMapper;
import com.gem.tradesystem.service.BuyHistorySerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyHistoryServiceImpl implements BuyHistorySerive {
    @Autowired
    private BuyHistoryMapper buyHistoryMapper;
    @Override
    public List<Sucai> selectDownLoadByUid(Integer uid) {
        List list = buyHistoryMapper.selectBuyHistoryByUserId(uid);
        return list;
    }

    @Override
    public Integer selectDownLoadCountByUid(Integer uid) {
        return buyHistoryMapper.selectBuyHistoryCountByUid(uid);
    }
}
