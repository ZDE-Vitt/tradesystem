package com.gem.tradesystem.back.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gem.tradesystem.back.entity.Order;
import com.gem.tradesystem.back.service.BackOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: NoTomato
 * @DATE:2020/3/2 10:26
 * @Description:
 */
@Controller
@RequestMapping("/backorder")
public class BackOrderController {

    @Autowired
    private BackOrderService backOrderService;

    @RequestMapping("/list")
    public String list(){
        return "back/order_list";
    }

    @ResponseBody
    @RequestMapping("/getlist")
    public Page<Order> getlist(Integer curr, Integer limit){
        if(null == curr)curr= 1 ;
        if(null == limit)limit= 5 ;
        Page<Order> orderPage= backOrderService.selectList(curr,limit);
        return orderPage;
    }

    @ResponseBody
    @RequestMapping("/deleteone")
    public Page<Order> deleteone(Integer curr, Integer limit , Integer id){
        if(null == curr)curr= 1 ;

        backOrderService.deleteone(id);

        Page<Order> orderPage = backOrderService.selectList(curr,limit);
        orderPage.setCurrent(curr);
        return orderPage;
    }

    @RequestMapping("/selectDeleteListForm")
    public String selectDeleteListForm(){
        return "back/delete_list_Form";
    }

    @ResponseBody
    @RequestMapping("/seleteDeleteList")
    public List<Order> seleteDeleteList(String dateStart, String dateEnd, String sucaiId, String userId){
        return backOrderService.selectDeleteList(dateStart,dateEnd,sucaiId,userId);
    }

    @ResponseBody
    @RequestMapping("/deleteList")
    public String deleteList(String dateStart, String dateEnd, String sucaiId, String userId){
        Integer result = backOrderService.deleteList(backOrderService.selectDeleteList(dateStart,dateEnd,sucaiId,userId));
        if (result != 0){
            return "success";
        }else return "error";
    }

}
