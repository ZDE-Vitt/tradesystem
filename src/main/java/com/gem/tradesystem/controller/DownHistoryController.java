package com.gem.tradesystem.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.gem.tradesystem.entity.Sucai;
import com.gem.tradesystem.entity.User;
import com.gem.tradesystem.service.DownHistoryService;
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
@RequestMapping("/downHistory")
public class DownHistoryController {
    @Autowired
    private DownHistoryService downHistoryService;
    @RequestMapping("/toDownHistory")
    public String toDownHistory(){
        return "downHistory";
    }
    @RequestMapping(value = "/getDownHistoryData",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> getShoppingCar(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        Integer uid = user.getId();
        Map<String,Object> map = new HashMap<>();
        List<Sucai> sucaiIPage = downHistoryService.selectDownLoadByUid(uid);
        Integer count = downHistoryService.selectDownLoadCountByUid(uid);
        map.put("data",sucaiIPage);//每页记录
        map.put("count",count);//总记录数
        return map;
    }
}
