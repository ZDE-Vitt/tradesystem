package com.gem.tradesystem.back.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gem.tradesystem.back.entity.SysUser;
import com.gem.tradesystem.back.entity.SysUserCustom;
import com.gem.tradesystem.back.mapper.UserMapper;
import com.gem.tradesystem.back.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: NoTomato
 * @DATE:2020/2/25 15:15
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<SysUserCustom> selectList(Integer curr , Integer limit , String likename) {
        curr *= limit;

        List<SysUserCustom> sysUsers = this.userMapper.selectAll(curr,limit,likename);
        return sysUsers;

    }

    @Override
    public Integer total(String likename){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("username",likename);
        return userMapper.selectCount(wrapper);
    }

    @Override
    public Integer delete(Integer id) {
        userMapper.deleteUser_Role(id);
        return userMapper.deleteById(id);
    }

    @Override
    public Integer insert(SysUserCustom sysUserCustom) {

        SysUser sysUser = sysUserCustom;
        System.out.println("sysUser=======>"+sysUser);
        userMapper.insert(sysUser);

        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username", sysUser.getUsername());
        wrapper.eq("name",sysUser.getName());

        sysUser = userMapper.selectOne(wrapper);

        Integer roleid = Integer.valueOf(sysUserCustom.getRoleName());


        Integer userid = Integer.valueOf(sysUser.getId());

        int col = userMapper.insertUser_Role(userid,roleid);

        return col;
    }

    @Override
    public SysUserCustom selectone(Integer id) {

        SysUser sysUser =userMapper.selectById(id);

        SysUserCustom sysUserCustom = new SysUserCustom();

        sysUserCustom.setId(sysUser.getId());
        sysUserCustom.setUsername(sysUser.getUsername());
        sysUserCustom.setName(sysUser.getName());
        sysUserCustom.setPassword(sysUser.getPassword());
        sysUserCustom.setEmail(sysUser.getEmail());
        sysUserCustom.setMobile(sysUser.getMobile());
        sysUserCustom.setRoleName(String.valueOf(userMapper.selectoneUser_Role(id)));

        return sysUserCustom;
    }

    @Override
    public Integer update(SysUserCustom sysUserCustom) {
        Integer userId = sysUserCustom.getId();
        Integer roleId = Integer.valueOf(sysUserCustom.getRoleName());

        SysUser sysUser = sysUserCustom;
        userMapper.updateById(sysUser);

        Integer row = userMapper.updateUser_Role(userId,roleId);

        return row;
    }

}
