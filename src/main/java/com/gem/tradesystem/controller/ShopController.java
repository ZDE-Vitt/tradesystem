package com.gem.tradesystem.controller;

import com.gem.tradesystem.entity.User;
import com.gem.tradesystem.service.SucaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.nio.channels.SeekableByteChannel;

@Controller
@RequestMapping("/shopCar")
public class ShopController {
    @Autowired
    private SucaiService sucaiService;

    @RequestMapping("/add")
    @ResponseBody
    public String addToShopCar(HttpServletRequest request, HttpSession session){
        User user= (User) session.getAttribute("user");
        Integer id=Integer.parseInt(request.getParameter("sid"));
        if(user!=null){
            if(sucaiService.getDownload(id,user.getId())!=null){//如果用户已经有关于该素材的订单
                return "failed";
            }else{
                sucaiService.addToCar(id,user.getId());
                return "success";
            }
         }else{
            return null;
        }
    }
}
