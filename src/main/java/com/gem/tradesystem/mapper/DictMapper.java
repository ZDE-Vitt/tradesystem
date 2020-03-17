package com.gem.tradesystem.mapper;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gem.tradesystem.entity.SysDict;
import org.springframework.stereotype.Component;

/**
 * @Auther: NoTomato
 * @DATE:2020/3/6 10:09
 * @Description:
 */
@Component
@TableName(value = "sys_dict")
public interface DictMapper extends BaseMapper<SysDict> {
}
