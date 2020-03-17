package com.gem.tradesystem.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gem.tradesystem.back.entity.SysUser;
import com.gem.tradesystem.entity.SysDict;
import com.gem.tradesystem.mapper.DictMapper;
import com.gem.tradesystem.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: NoTomato
 * @DATE:2020/3/6 10:08
 * @Description:
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, SysDict> implements DictService {
    @Autowired
    private DictMapper dictMapper;


    @Override
    public Integer changestatus(Integer id, Integer status) {
        return null;
    }
}
