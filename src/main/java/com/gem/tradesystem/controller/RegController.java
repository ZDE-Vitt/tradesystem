package com.gem.tradesystem.controller;

import com.gem.tradesystem.service.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/*用户注册页面
* */
@Controller
@RequestMapping("/reg")
public class RegController {
    @Autowired
    private RegService regService;

    //注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Boolean  register(String password, String telephone, String username) {
        boolean flag = regService.insertUser(password, telephone, username);
        System.out.println(flag);
        return flag;
    }
    //跳转到中间页面
    @RequestMapping(value = "/loginJump")
    public String   toLoginJump() {
        return "loginJump";
    }
    //验证手机号码
    @RequestMapping("/verifyTel")
    @ResponseBody
    public Boolean verifyTel(@RequestParam String telephone){
        Boolean flag = regService.verifyTel(telephone);
        return flag;
    }
    //验证用户名
    @RequestMapping("/verifyUsername")
    @ResponseBody
    public Boolean verifyUsername(@RequestParam String username){
        Boolean flag = regService.verifyUsername(username);
        return flag;
    }

}