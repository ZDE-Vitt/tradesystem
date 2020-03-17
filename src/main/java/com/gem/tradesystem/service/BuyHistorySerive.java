package com.gem.tradesystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.tradesystem.entity.Sucai;

import java.util.List;

public interface BuyHistorySerive {
    List<Sucai> selectDownLoadByUid(Integer uid);

    Integer selectDownLoadCountByUid(Integer uid);
}
