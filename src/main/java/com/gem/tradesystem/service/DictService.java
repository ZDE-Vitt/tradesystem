package com.gem.tradesystem.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.gem.tradesystem.entity.SysDict;

/**
 * @Auther: NoTomato
 * @DATE:2020/3/6 10:07
 * @Description:
 */
public interface DictService extends IService<SysDict> {
    Integer changestatus(Integer id, Integer status);
}
