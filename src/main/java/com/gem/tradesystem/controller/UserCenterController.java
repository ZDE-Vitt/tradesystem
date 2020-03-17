package com.gem.tradesystem.controller;

import com.gem.tradesystem.entity.Sucai;
import com.gem.tradesystem.entity.User;
import com.gem.tradesystem.service.UserCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*用户中心*/
@Controller
@RequestMapping("/center")
public class UserCenterController {
    @Autowired
    private UserCenterService userCenterService;

    @RequestMapping("/toCenter")
    public String toCenter(){
        return "user_center";
    }

    @RequestMapping("/showCollect")
    @ResponseBody
    public Map<String,Object> showCollect(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        Integer userId = user.getId();
        List<Sucai> sucaiList = userCenterService.selectCollectById(userId);
        Integer result = userCenterService.selectCartCountById(userId);
        Map<String,Object> map = new HashMap<>();
        map.put("data",sucaiList);
        map.put("count",map.size());
        map.put("cartCount",result);
        return map;
    }


}
