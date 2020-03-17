package com.gem.tradesystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.tradesystem.entity.Sucai;
import com.gem.tradesystem.mapper.CollectMapper;
import com.gem.tradesystem.service.CollectService;
import com.gem.tradesystem.utils.SrcUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CollectServiceImpl implements CollectService{
    @Autowired
    private CollectMapper collectMapper;
    @Autowired
    private SrcUrl srcUrl;
    @Override
    public List<Sucai> selectFavByUid(Integer uid) {
        List<Sucai> list = collectMapper.selectFavByUid(uid);
        return list;
    }

    @Override
    public Integer selectFavCountByUid(Integer uid) {
        return collectMapper.selectFavCountByUid(uid);
    }
}
