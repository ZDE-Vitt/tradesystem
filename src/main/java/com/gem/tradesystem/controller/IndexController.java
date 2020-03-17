package com.gem.tradesystem.controller;

import com.gem.tradesystem.entity.User;
import com.gem.tradesystem.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private IndexService indexService;


    @RequestMapping("/loginOut")
    @ResponseBody
    public String  toIndex(HttpServletRequest request){
        request.getSession().removeAttribute("user");
        return "success";
    }
    //登录
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public User login(HttpServletRequest request,User user){
        user = indexService.login(user.getTelephone(), user.getPassword());
        if (user!=null){
            request.getSession().setAttribute("user",user);
        }
        return user;
    }

    //跳转到用户中心
    @RequestMapping(value = "/center")
    public String userCenter(){
        return "user_center";
    }
    //跳转到注册页面
    @RequestMapping(value = "/register")
    public String openRegister(){
        return "reg";
    }
}
