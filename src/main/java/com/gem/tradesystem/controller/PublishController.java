package com.gem.tradesystem.controller;

import com.gem.tradesystem.service.SucaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/publish")
public class PublishController {

    @Autowired
    private SucaiService sucaiService;

    @RequestMapping("/Uploadform")
    public String Uploadform(Model model){
        List<String> subtag= sucaiService.getAllSubMenu();
        model.addAttribute("tags",subtag);
        return "user_upload";
    }

    @ResponseBody
    @RequestMapping("/Upload")
    public String Upload(){
        return "user_sucai";
    }

}
