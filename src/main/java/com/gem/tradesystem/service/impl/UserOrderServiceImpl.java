package com.gem.tradesystem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.tradesystem.entity.User;
import com.gem.tradesystem.entity.UserOrder;
import com.gem.tradesystem.entity.UserOrderCustom;
import com.gem.tradesystem.mapper.UserOrderMapper;
import com.gem.tradesystem.mapper.UserSettingMapper;
import com.gem.tradesystem.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @Auther: NoTomato
 * @DATE:2020/3/3 19:43
 * @Description:
 */
@Service
public class UserOrderServiceImpl implements UserOrderService {

    @Autowired
    private UserOrderMapper userOrderMapper;

    @Autowired
    private UserSettingMapper userSettingMapper;


    @Override
    public Page<UserOrderCustom> SelectAll(Integer curr, Integer limit,Integer status ,Integer userid) {

        //格式化时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        List<UserOrderCustom> userOrder = null;


        //新建一个UserOrderCustom的list对象
        if (0 == status){
            userOrder = userOrderMapper.selectAll((curr-1)*limit,limit,status,userid);
        }else if(1 == status){
            userOrder = userOrderMapper.selectAll((curr-1)*limit,limit,3,userid);
        }else {
            userOrder = userOrderMapper.selectAllcom((curr - 1) * limit, limit, 3,userid);
        }

        QueryWrapper<UserOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("userid",userid);
        wrapper.eq("del_Flag",0);


        //获取多种类
        List<Integer> repid = userOrderMapper.getRep();

        //获取单种类
        List<Integer> singleId = userOrderMapper.singleId();

        //给新建custon对象并给UserOrderCustom(list)赋值
        for (UserOrderCustom order: userOrder) {

            //格式化时间字符创形式
            order.setTime(simpleDateFormat.format(order.getCreatetime()));

            //设置类型
            //单类
            for (Integer id:singleId) {
                if (id!=null){
                    if(order.getOrderid().toString().equals(id.toString())){
                        order.setSucaiType(userOrderMapper.getType(id).get(0)+"|");
                    }
                }
            }

            //多种类
            for (Integer id:repid) {
                if (id!=null){
                    if(order.getOrderid().toString().equals(id.toString())){
                        String type = "";
                        for (String s:userOrderMapper.getType(id)) {
                            type+=s+"|";
                        }
                        order.setSucaiType(type);
                    }
                }
            }

            order.setOrderStatusName(userOrderMapper.getStatus(order.getOrderStatus()));

        }


        //新建UserOrderCustom的page对象，赋值各元素
        Page<UserOrderCustom> userOrderCustomPage = new Page<>();

        userOrderCustomPage.setRecords(userOrder);
        userOrderCustomPage.setSize(limit);
        userOrderCustomPage.setCurrent(curr);
        userOrderCustomPage.setTotal(userOrderMapper.selectCount(wrapper));

        return userOrderCustomPage;
    }

    @Override
    public Integer completeOrder(Integer id) {
        return userOrderMapper.completeOrder(id);
    }

    @Override
    public Integer incompleteOrder(Integer id) {
        return userOrderMapper.incompleteOrder(id);
    }

    @Override
    public Integer deleteone(Integer id) {
        Integer row =userOrderMapper.deleteById(id);
        return row;
    }

    @Override
    public Integer payone(Integer userOrderid,User user, Integer money) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        user.setAccount(user.getAccount() - money);
        queryWrapper.eq("id",user.getId());

        UserOrder userOrder = userOrderMapper.selectById(userOrderid);
        userOrder.setOrderStatus(3);
        QueryWrapper<UserOrder> orderQueryWrapper = new QueryWrapper<>();
        orderQueryWrapper.eq("id",userOrder.getId());
        userOrderMapper.update(userOrder,orderQueryWrapper);

        return userSettingMapper.update(user,queryWrapper);
    }

}
