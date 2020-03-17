package com.gem.tradesystem.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.tradesystem.back.entity.BackSysDict;
import com.gem.tradesystem.back.entity.Order;
import com.gem.tradesystem.back.mapper.BackDictMapper;
import com.gem.tradesystem.back.mapper.BackOrderMapper;
import com.gem.tradesystem.back.mapper.BackSucaiMapper;
import com.gem.tradesystem.back.service.BackOrderService;
import com.gem.tradesystem.entity.Sucai;
import com.gem.tradesystem.entity.UserOrder;
import com.gem.tradesystem.mapper.UserOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: NoTomato
 * @DATE:2020/3/2 13:19
 * @Description:
 */
@Service
public class BackOrderServiceImpl implements BackOrderService {

    @Autowired
    private BackOrderMapper backOrderMapper;

    @Autowired
    private BackDictMapper backDictMapper;

    @Autowired
    private BackSucaiMapper sucaiMapper;

    @Override
    public Page<Order> selectList(Integer curr, Integer limit) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        Page<Order> page = new Page<>(curr, limit);
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        page = backOrderMapper.selectPage(page, wrapper);

        QueryWrapper<BackSysDict> dict = new QueryWrapper<>();
        dict.eq("typecode", "orderStatus");
        List<BackSysDict> typenames = backDictMapper.selectList(dict);

        List<Order> cuslist = backOrderMapper.selectordercuslist((curr-1)*limit, limit);

        for (Order order : cuslist) {
            order.setTime(simpleDateFormat.format(order.getCreatetime()));
            for (BackSysDict typename : typenames) {
                if (typename.getValue().equals(order.getOrderStatus().toString())) {
                    order.setStatus(typename.getName());
                }
            }
        }

        page.setRecords(cuslist);

        return page;
    }

    @Override
    public Integer deleteone(Integer id) {
        return backOrderMapper.deleteById(id);
    }

    @Override
    public List<Order> selectDeleteList(String dateStart,String dateEnd,String sucaiId,String userId) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        QueryWrapper<Order> wrapper = new QueryWrapper<>();
        wrapper.between("createTime",dateStart,dateEnd);
        if (sucaiId != null && sucaiId != ""){
            QueryWrapper<Sucai> sucaiQueryWrapper = new QueryWrapper<>();
            sucaiQueryWrapper.eq("num",sucaiId);
            wrapper.eq("sucaiid",sucaiMapper.selectOne(sucaiQueryWrapper).getId());
        }
        if (userId != null && userId != "")wrapper.eq("userid",userId);

        List<Order> orders = backOrderMapper.selectList(wrapper);


        QueryWrapper<BackSysDict> dict = new QueryWrapper<>();
        dict.eq("typecode", "orderStatus");
        List<BackSysDict> typenames = backDictMapper.selectList(dict);

        for (Order order : orders) {
            order.setTime(simpleDateFormat.format(order.getCreatetime()));
            for (BackSysDict typename : typenames) {
                if (typename.getValue().equals(order.getOrderStatus().toString())) {
                    order.setStatus(typename.getName());
                }
            }
        }

        return orders;
    }

    @Override
    public Integer deleteList(List<Order> list) {
        List<Integer> idList = new ArrayList<>();

        for (Order order:list) {
            idList.add(order.getId());
        }

        Integer result = backOrderMapper.deleteBatchIds(idList);

        return result;
    }
}
