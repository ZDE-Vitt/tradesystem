package com.gem.tradesystem.back.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gem.tradesystem.back.entity.Order;
import com.gem.tradesystem.back.entity.SysUser;
import com.gem.tradesystem.back.entity.SysUserCustom;
import com.gem.tradesystem.entity.Sucai;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Auther: NoTomato
 * @DATE:2020/2/25 13:53
 * @Description:
 */
@Component
public interface BackSucaiMapper extends BaseMapper<Sucai> {
}
