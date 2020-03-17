package com.gem.tradesystem.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.tradesystem.entity.Sucai;
import com.gem.tradesystem.entity.UserOrder;
import com.gem.tradesystem.mapper.ShoppingCartMapper;
import com.gem.tradesystem.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.midi.Soundbank;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;
    @Override
    public List<Sucai> selectCarByUid(Integer uid) {
        List list = shoppingCartMapper.selectShoppingCarByUserId(uid);
        return list;
    }

    @Override
    public Integer selectCarCountByUid(Integer uid) {
        return shoppingCartMapper.selectCarCountByUid(uid);
    }
    //根据素材id删除购物车中的一个素材
    @Override
    public Boolean deleteBySid(Integer suCaiId) {
        return shoppingCartMapper.deleteBySid(suCaiId);
    }

    @Override
    public Integer deleteByIds(List<Integer> ids) {
        return shoppingCartMapper.deleteByIds(ids);
    }

    @Override
    public Integer moveToCollect(List<Integer> ids, Integer uid) {
        for (Integer id :ids){
            Integer count = shoppingCartMapper.selectCollectById(id,uid);
            if (count>0){
                return 0;
            }else{
                Integer row = shoppingCartMapper.insertIntoCollect(id,uid);
                return row;
            }
        }
        return 0;
    }

    @Override
    public Integer moveToBuyHistory(List<Integer> ids, Integer uid, Date createTime) {
        List<UserOrder> list = new ArrayList<>();
        for (Integer suCaiId:ids){
            UserOrder userOrder = new UserOrder();
            userOrder.setSucaiid(suCaiId);;
            userOrder.setCreatetime(createTime);
            userOrder.setUserid(uid);
            userOrder.setOrderStatus(3);
            userOrder.setOrderid(Integer.valueOf(new SimpleDateFormat("yyMMddHH").format(new Date())+ (new Random().nextInt(100)+1) ));
            list.add(userOrder);
        }
        return shoppingCartMapper.moveToBuyHistory(list);
    }

    @Override
    public void minusAccount(Integer account,Integer uid) {
        shoppingCartMapper.minusAccount(account,uid);
    }
}
