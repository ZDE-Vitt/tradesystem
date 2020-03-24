package com.gem.tradesystem.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.tradesystem.entity.User;
import com.gem.tradesystem.entity.UserOrder;
import com.gem.tradesystem.entity.UserOrderCustom;
import com.gem.tradesystem.service.UserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: NoTomato
 * @DATE:2020/3/3 15:37
 * @Description:
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private UserOrderService userOrderService;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");

    @RequestMapping("/list")
    public String toorder() {
        return "user_dingdan";
    }


    @RequestMapping(value = "/toorder", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map<String, Object> getAll(HttpServletRequest request, Integer curr, Integer limit, Integer status) {
        Map<String, Object> map = new HashMap<>();
        Page<UserOrderCustom> userOrder = null;
        User user = null;
        if (null == curr) curr = 1;
        if (null == limit) limit = 5;
        if (null == status) status = 0;

        if (null != request.getSession().getAttribute("user")) {
            user = (User) request.getSession().getAttribute("user");
            userOrder = userOrderService.SelectAll(curr, limit, status, user.getId());
        } else {
//            user = new User();
//            user.setId(25);
//            userOrder = userOrderService.SelectAll(curr, limit, status, user.getId());
            return null;
        }

        if (null == userOrder.getRecords()) {
            return null;
        } else {
            map.put("order", userOrder.getRecords());
            map.put("limit", userOrder.getSize());
            map.put("total", userOrder.getTotal());
            map.put("curr", userOrder.getCurrent());
            map.put("completeNum", userOrderService.completeOrder(user.getId()));
            map.put("incompleteNum", userOrderService.incompleteOrder(user.getId()));
        }

        return map;
    }

    @RequestMapping(value = "/delete", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Map<String, Object> delete(HttpServletRequest request, Integer curr, Integer limit, Integer status , Integer id) {
        Map<String, Object> map = new HashMap<>();
        Page<UserOrderCustom> userOrder = null;
        User user = null;

        //执行删除
        userOrderService.deleteone(id);
//        System.out.println("id=============>"+id);

        //重新加载数据
        if (null == curr) curr = 1;
        if (null == limit) limit = 5;
        if (null == status) status = 0;

        if (null != request.getSession().getAttribute("user")) {
            user = (User) request.getSession().getAttribute("user");
            userOrder = userOrderService.SelectAll(curr, limit, status, user.getId());
        } else {
            return null;
        }

        if (null == userOrder.getRecords()) {
            return null;
        } else {
            map.put("order", userOrder.getRecords());
            map.put("limit", userOrder.getSize());
            map.put("total", userOrder.getTotal());
            map.put("curr", userOrder.getCurrent());
            map.put("msg", "success");
            map.put("completeNum", userOrderService.completeOrder(user.getId()));
            map.put("incompleteNum", userOrderService.incompleteOrder(user.getId()));
        }

        return map;
    }

    @ResponseBody
    @RequestMapping("/payone")
    public String payone(HttpServletRequest request , Integer sucaiMoney , Integer userOrderid){
        User user = (User) request.getSession().getAttribute("user");
        if (sucaiMoney > user.getAccount()){
            return "error";
        }else {
            userOrderService.payone(userOrderid,user,sucaiMoney);
            return "success";
        }
    }
}
