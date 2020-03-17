package com.gem.tradesystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.tradesystem.entity.Sucai;
import com.gem.tradesystem.mapper.DownHistoryMapper;
import com.gem.tradesystem.service.DownHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DownHistoryServiceImpl implements DownHistoryService {
    @Autowired
    private DownHistoryMapper downHistoryMapper;
    @Override
    public List<Sucai> selectDownLoadByUid(Integer uid) {
        List<Sucai> list = downHistoryMapper.selectDownByUserId(uid);
        return list;
    }

    @Override
    public Integer selectDownLoadCountByUid(Integer uid) {
        return downHistoryMapper.selectDownCountByUid(uid);
    }
}
