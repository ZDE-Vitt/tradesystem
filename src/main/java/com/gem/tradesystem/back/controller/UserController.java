package com.gem.tradesystem.back.controller;

import com.gem.tradesystem.back.entity.SysUserCustom;
import com.gem.tradesystem.back.service.BackDictService;
import com.gem.tradesystem.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Auther: NoTomato
 * @DATE:2020/2/21 14:59
 * @Description:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private BackDictService backDictService;


    Integer size = 5;

    @RequestMapping("/list")
    public String list(Integer curr, Integer limit, String likename, Model model) {
        limit = size;
        Integer current = 1;
        if (curr == null) curr = current;
        if (likename == null) likename = "";

        List<SysUserCustom> sysUserCustoms = userService.selectList(curr - 1, limit , likename);

        Integer total = userService.total(likename);

        model.addAttribute("userList", sysUserCustoms);
        model.addAttribute("total", total);
        model.addAttribute("current", curr);
        model.addAttribute("size", limit);
        model.addAttribute("likename", likename);
        return "back/user_list";
    }

    @RequestMapping("/delete")
    public String delete(Integer id, Integer curr, String likename, Model model) {

        Integer num = userService.delete(id);
        Integer total = userService.total(likename);
        List<SysUserCustom> sysUserCustoms = userService.selectList(curr - 1, size ,likename);
        model.addAttribute("userList", sysUserCustoms);
        model.addAttribute("total", total);
        model.addAttribute("current", curr);
        model.addAttribute("size", size);
        model.addAttribute("likename", likename);
        return "back/user_list";
    }

    @RequestMapping("/update_form")
    public String update_form(Integer id, Model model) {
        SysUserCustom sysUserCustom = userService.selectone(id);
        model.addAttribute("user",sysUserCustom);
        return "back/update_form";
    }

    @ResponseBody
    @RequestMapping("/update")
    public String update(SysUserCustom sysUserCustom) {
        userService.update(sysUserCustom);
        return "success";
    }

    @RequestMapping("/insert_form")
    public String insert_form(Integer curr, Model model) {
        model.addAttribute("curr",curr);
        return "back/user_form";
    }

    @ResponseBody
    @RequestMapping("/insert")
    public String insert(SysUserCustom sysUserCustom) {
        userService.insert(sysUserCustom);
        return "success";
    }

    @RequestMapping("/status")
    public String status(Integer id , Integer status, Integer curr, String likename, Model model){
        backDictService.changestatus(id, status);

        List<SysUserCustom> sysUserCustoms = userService.selectList(curr - 1, 5 ,likename);

        Integer total = userService.total(likename);
        model.addAttribute("userList", sysUserCustoms);
        model.addAttribute("total", total);
        model.addAttribute("current", curr);
        model.addAttribute("size", 5);
        model.addAttribute("likename", likename);

        return "back/user_list";
    }

}
