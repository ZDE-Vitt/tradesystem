package com.gem.tradesystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.tradesystem.entity.Sucai;

import java.util.List;

public interface DownHistoryService {
    List<Sucai> selectDownLoadByUid(Integer uid);

    Integer selectDownLoadCountByUid(Integer uid);
}
