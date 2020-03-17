package com.gem.tradesystem.back.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gem.tradesystem.back.entity.BackSysDict;

/**
 * @Auther: NoTomato
 * @DATE:2020/2/28 16:24
 * @Description:
 */
public interface BackDictService extends IService<BackSysDict> {
    Integer changestatus(Integer id, Integer status);
}
