package com.gem.tradesystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.tradesystem.entity.Sucai;
import com.gem.tradesystem.entity.User;
import com.gem.tradesystem.service.BuyHistorySerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/buyHistory")
public class BuyHistoryController {
    @Autowired
    private BuyHistorySerive buyHistorySerive;
    @RequestMapping("/toBuyHistory")
    public String toBuyHistory(){
        return "buyHistory";
    }
    @RequestMapping(value = "/getBuyHistoryData",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getBuyHistoryData(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        Integer uid = user.getId();
        Map<String,Object> map = new HashMap<>();
        List<Sucai> sucaiIPage = buyHistorySerive.selectDownLoadByUid(uid);
        Integer count = buyHistorySerive.selectDownLoadCountByUid(uid);
        map.put("data",sucaiIPage);//每页记录
        map.put("count",count);//总记录数
        return map;
    }

}
