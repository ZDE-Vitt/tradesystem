package com.gem.tradesystem.back.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gem.tradesystem.back.entity.BackSysDict;
import org.springframework.stereotype.Component;

/**
 * @Auther: NoTomato
 * @DATE:2020/2/28 16:26
 * @Description:
 */
@Component
public interface BackDictMapper extends BaseMapper<BackSysDict> {
}
