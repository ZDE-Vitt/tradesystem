package com.gem.tradesystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.tradesystem.entity.Sucai;
import com.gem.tradesystem.entity.User;
import com.gem.tradesystem.service.CollectService;
import com.gem.tradesystem.service.ShoppingCartService;
import com.gem.tradesystem.service.UserCenterService;
import com.gem.tradesystem.utils.SrcUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/collect")
public class CollectController {
    @Autowired
    private CollectService collectService;

    @RequestMapping("/toCollect")
    public String toCenter(){
        return "collect";
    }
    @RequestMapping(value = "/favData",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> showFavData(HttpServletRequest request) throws UnsupportedEncodingException {
        User user = (User) request.getSession().getAttribute("user");

        Integer uid = user.getId();
        Map<String,Object> map = new HashMap<>();
        List<Sucai> sucaiList = collectService.selectFavByUid(uid);
        System.out.println(sucaiList);
        Integer count = collectService.selectFavCountByUid(uid);
        map.put("favData",sucaiList);//每页记录
        map.put("favCount",count);//总记录数
        return map;
    }
}
