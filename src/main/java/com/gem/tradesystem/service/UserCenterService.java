package com.gem.tradesystem.service;


import com.gem.tradesystem.entity.Sucai;

import java.util.List;

public interface UserCenterService {

    List<Sucai> selectCollectById(Integer userId);

    Integer selectCartCountById(Integer userId);
}
