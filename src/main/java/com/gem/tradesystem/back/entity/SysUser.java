package com.gem.tradesystem.back.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: NoTomato
 * @DATE:2020/2/20 17:09
 * @Description:
 */
@Data
public class SysUser implements Serializable {
    private Integer id;
    private String username;    //登录名
    private String password;
    private String name; //用户名
    private String email;
    private String mobile;
    private Integer status; //用户状态
//    private String userType;//用户类型

    private Integer createBy;
    private Date createDate;//创建时间
    private Integer updateBy;
    private Date updateDate;//更新时间
    // @TableLogic 用于设置该字段为逻辑字段
    @TableLogic
    private String delFlag;

    //角色
    //mybatis plus忽略该属性和数据库的映射
//    @TableField(exist = false)
//    private List<SysRole> roles;
    
}
