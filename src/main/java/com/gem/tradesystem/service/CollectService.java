package com.gem.tradesystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.tradesystem.entity.Sucai;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface CollectService {
    List<Sucai> selectFavByUid(Integer uid) throws UnsupportedEncodingException;

    Integer selectFavCountByUid(Integer uid);
}
