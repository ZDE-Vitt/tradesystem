package com.gem.tradesystem.back.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gem.tradesystem.back.entity.BackSysDict;
import com.gem.tradesystem.back.entity.SysUser;
import com.gem.tradesystem.back.mapper.BackDictMapper;
import com.gem.tradesystem.back.mapper.UserMapper;
import com.gem.tradesystem.back.service.BackDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: NoTomato
 * @DATE:2020/2/28 16:25
 * @Description:
 */
@Service
public class BackDictServiceImpl extends ServiceImpl<BackDictMapper, BackSysDict> implements BackDictService {
    @Autowired
    private BackDictMapper dictMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer changestatus(Integer id, Integer status) {
        SysUser sysUser = userMapper.selectById(id);
        sysUser.setStatus(status);
        Integer row = userMapper.updateById(sysUser);
        return row;
    }
}
