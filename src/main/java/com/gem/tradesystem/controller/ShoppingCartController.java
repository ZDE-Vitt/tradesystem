package com.gem.tradesystem.controller;

import com.gem.tradesystem.entity.Sucai;
import com.gem.tradesystem.entity.User;
import com.gem.tradesystem.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {
    @Autowired
    private ShoppingCartService shoppingCartService;
    @RequestMapping("/toCart")
    public String toCenter(){
        return "shoppingCart";
    }
    @RequestMapping(value = "/getShoppingCarData",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getShoppingCar(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        Integer uid = user.getId();
        Map<String,Object> map = new HashMap<>();
        List<Sucai> sucaiList = shoppingCartService.selectCarByUid(uid);
        Integer count = shoppingCartService.selectCarCountByUid(uid);
        map.put("data",sucaiList);//每页记录
        map.put("count",count);//总记录数
        return map;
    }
    @DeleteMapping("/deleteBySid")
    @ResponseBody
    public Boolean deleteBySid(Integer suCaiId){
            Boolean flag = shoppingCartService.deleteBySid(suCaiId);
            return flag;
    }
    @RequestMapping("/moveByIds")
    @ResponseBody
    public Boolean moveByIds(@RequestParam(value="ids") List<Integer> ids){
        Integer count = shoppingCartService.deleteByIds(ids);
        if (count>0){
            return true;
        }
        return false;
    }
    @RequestMapping("/moveToCollect")
    @ResponseBody
    public Boolean moveToCollect(@RequestParam(value="ids") List<Integer> ids,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        Integer uid = user.getId();
        Integer count = shoppingCartService.deleteByIds(ids);
        if (count>0){
            Integer result = shoppingCartService.moveToCollect(ids,uid);
            if (result>0){
                return true;
            }
        }
        return false;
    }

    @RequestMapping(value = "/pay",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> pay(@RequestParam(value = "ids") List<Integer> ids,@RequestParam("account") Integer account,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        Map<String,Object> map = new HashMap<>();
        Integer uid = user.getId();
        Integer userAccount = user.getAccount();
        System.out.println(userAccount);
        if (null==userAccount){
            userAccount=0;
        }
        if (userAccount<account){
            map.put("status",false);
        }else{
            Integer deleteCount = shoppingCartService.deleteByIds(ids);
            if (deleteCount>0){
                Date createTime = new Date();
                Integer result = shoppingCartService.moveToBuyHistory(ids,uid,createTime);
                account=userAccount-account;
                shoppingCartService.minusAccount(account,uid);
                if (result>0){
                    user.setAccount(account);
                    request.getSession().setAttribute("user",user);
                    map.put("status",true);
                }
            }
        }
        return map;
    }
}
