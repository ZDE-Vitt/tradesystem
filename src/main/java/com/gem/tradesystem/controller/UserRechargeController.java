package com.gem.tradesystem.controller;

import com.gem.tradesystem.entity.Jifeng;
import com.gem.tradesystem.entity.User;
import com.gem.tradesystem.service.JifengService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * @author: Fei Peng
 * @CreateDate: 2020/3/6 14:36
 * @Description:我的钱包
 */
@Controller
@RequestMapping("/center")
public class UserRechargeController {

    @Autowired
    private JifengService jifengService;

    @RequestMapping("/wallet/jifeng")
    public String toJifeng(Model model){
        List<Jifeng> list = jifengService.getJifeng();
        model.addAttribute("jifenglist",list);
        return "user_zhifu_jifenchongzhi";
    }

    @RequestMapping("/user_center")
     public String payReturn(HttpSession session){
        User user = (User) session.getAttribute("user");
        Integer id = user.getId();
        user.setAccount(jifengService.getJifengById(id));
        return "user_center";
    }

}
