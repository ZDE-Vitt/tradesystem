package com.gem.tradesystem.controller;

import com.gem.tradesystem.config.UploadProperties;
import com.gem.tradesystem.entity.User;
import com.gem.tradesystem.mapper.UserSettingMapper;
import com.gem.tradesystem.service.UploadFile;
import com.gem.tradesystem.service.UserSettingService;
import com.gem.tradesystem.service.impl.UploadFileQiniu;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/*用户设置*/
@Controller
@RequestMapping("/userSetting")
public class UserSettingController {
    @Autowired
    private UserSettingService userSettingService;
    @Autowired
    UploadProperties uploadProperties;
    @RequestMapping("/toUserSetting")
    public String toUserSetting(){
        return "userSetting";
    }


    //修改用户名
    @ResponseBody
    @RequestMapping("/modifyUsername")
    public Integer modifyUsername(Integer id, String username, HttpServletRequest request){
        Integer result = userSettingService.modifyUsername(id,username);
        User user = userSettingService.selectUserById(id);
        request.getSession().setAttribute("user",user);
        return result;
    }
    //验证用户名是否重复
    @RequestMapping("/confirmUsername")
    @ResponseBody
    public Integer confirmUsername(String username){
        Integer result = userSettingService.confirmUsername(username);
        return result;
    }
    //上传头像
    @RequestMapping("/uploadAvatar")
    @ResponseBody
    public Integer uploadAvatar( MultipartFile file,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        Integer id = user.getId();
        Integer result = userSettingService.uploadAvatar(id,file);
        UploadFile uploadFile = new UploadFileQiniu(uploadProperties.getQiniu());
        String avatar = uploadFile.uploadFile(file);
        user.setAvatar(avatar);
        request.getSession().setAttribute("user",user);
        return result;
    }
    //验证密码
    @ResponseBody
    @RequestMapping("/confirmPass")
    public Boolean confirmPassword(String password,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        Integer id = user.getId();
        Boolean flag = userSettingService.confirmPassword(id,password);
        return flag;
    }
    @RequestMapping(value = "/modifyPassword",method = RequestMethod.POST)
    @ResponseBody
    public Boolean modifyPassword(String password,HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        Integer id = user.getId();
        Boolean flag = userSettingService.modifyPassword(id,password);
        return flag;
    }

}
