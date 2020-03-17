package com.gem.tradesystem.controller;

import com.gem.tradesystem.entity.Sucai;
import com.gem.tradesystem.entity.User;
import com.gem.tradesystem.service.SucaiService;
import com.gem.tradesystem.utils.SrcUrl;
import org.apache.ibatis.type.Alias;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class IndexShowController {
    @Autowired
    private SucaiService sucaiService;
    @Autowired
    private SrcUrl srcUrl;

    @RequestMapping("/")
    public String indexPage(Model model, HttpSession session) throws UnsupportedEncodingException {
        List<String> menulist= sucaiService.getMenu();

        User user= (User) session.getAttribute("user");
        if(user!=null){
            //已登录用户的收藏已否
            Integer uid=user.getId();
            List<Integer> user_favlist =sucaiService.getUserFavList(uid);
            model.addAttribute("favlist",user_favlist);
            //已登录的用户的购物车
            List<Integer> user_shopcar=sucaiService.getUserShoppingCar(uid);
            model.addAttribute("shopcar",user_shopcar);
        }

        List<Sucai> topsale=sucaiService.getTopSale();
        List<Sucai> topfav=sucaiService.getTopFav();
        for(Sucai s:topsale){
            String srcurl=srcUrl.getSrcUrl(s);//动态拼接数据库中存储的路径后
            s.setSave(srcurl);
        }
        for(Sucai s:topfav){
            String srcurl=srcUrl.getSrcUrl(s);//动态拼接数据库中存储的路径后
            s.setSave(srcurl);
        }

        model.addAttribute("menulist",menulist);
        model.addAttribute("topsale",topsale);
        model.addAttribute("topfav",topfav);
        return "index";
    }

    @RequestMapping("/beian")
    public String beian(){
        return "beian";
    }
}
