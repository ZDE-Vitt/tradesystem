package com.gem.tradesystem.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.tradesystem.entity.Sucai;

import java.util.Date;
import java.util.List;

public interface ShoppingCartService {
    List<Sucai> selectCarByUid(Integer uid);

    Integer selectCarCountByUid(Integer uid);

    Boolean deleteBySid(Integer suCaiId);

    Integer deleteByIds(List<Integer> ids);

    Integer moveToCollect(List<Integer> ids, Integer uid);

    Integer moveToBuyHistory(List<Integer> ids, Integer uid, Date createTime);

    void minusAccount(Integer account, Integer uid);
}
