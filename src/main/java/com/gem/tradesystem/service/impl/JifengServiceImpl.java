package com.gem.tradesystem.service.impl;

import com.gem.tradesystem.entity.Jifeng;
import com.gem.tradesystem.mapper.JifengMapper;
import com.gem.tradesystem.service.JifengService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Fei Peng
 * @CreateDate: 2020/3/10 16:41
 * @Description:
 */
@Service
public class JifengServiceImpl implements JifengService {


    @Autowired
    private JifengMapper jifengMapper;

    @Override
    public List<Jifeng> getJifeng() {
        return jifengMapper.getJifeng();
    }

    @Override
    public int getJifengById(Integer id) {
        return jifengMapper.getJifengById(id);
    }

    @Override
    public boolean updateUserJifengById(Integer id,Integer jifeng) {
        return jifengMapper.updateJifeng(id,jifeng);
    }
}
