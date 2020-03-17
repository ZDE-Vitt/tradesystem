package com.gem.tradesystem.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gem.tradesystem.back.entity.BackSysDict;
import com.gem.tradesystem.back.service.BackDictService;
import com.gem.tradesystem.entity.SysDict;
import com.gem.tradesystem.service.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @Auther: NoTomato
 * @DATE:2020/2/28 16:09
 * @Description:
 */
@Component
public class DictUtils {
    //后台自定义方言
    @Autowired
    private BackDictService backservice;
    private static BackDictService backDictService;

    //前台自定义方言
    @Autowired
    private DictService service;
    private static  DictService dictService;

    //构造
    @PostConstruct
    public void init(){
        backDictService = backservice;
        dictService = service;
    }

    public String getDictLable(String type, Integer value){
        QueryWrapper<BackSysDict> wrapper = new QueryWrapper<>();
        wrapper.eq("typecode",type);
        wrapper.eq("value",value);
        BackSysDict backSysDict = backDictService.getOne(wrapper);
        return backSysDict.getName();
    }

    public String getorderLable(String type, Integer value){
        QueryWrapper<SysDict> wrapper = new QueryWrapper<>();
        wrapper.eq("typecode",type);
        wrapper.eq("value",value);
        SysDict SysDict = dictService.getOne(wrapper);
        return SysDict.getName();
    }


}
