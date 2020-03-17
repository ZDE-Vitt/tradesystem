package com.gem.tradesystem.service;

import com.gem.tradesystem.entity.Jifeng;

import java.util.List;

/**
 * @author: Fei Peng
 * @CreateDate: 2020/3/10 16:40
 * @Description:
 */
public interface JifengService {

    List<Jifeng> getJifeng();

    int getJifengById(Integer id);

    boolean updateUserJifengById(Integer id,Integer jinfeng);

}
