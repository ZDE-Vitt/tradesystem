package com.gem.tradesystem.back.service;

import com.gem.tradesystem.back.entity.SysUserCustom;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: NoTomato
 * @DATE:2020/2/25 15:15
 * @Description:
 */

public interface UserService {
    List<SysUserCustom> selectList(Integer curr, Integer limit, String likename);
    Integer total(String likename);
    Integer delete(Integer id);
    Integer insert(SysUserCustom sysUserCustom);
    SysUserCustom selectone(Integer id);
    Integer update(SysUserCustom sysUserCustom);
}
