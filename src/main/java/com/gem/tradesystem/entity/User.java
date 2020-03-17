package com.gem.tradesystem.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("user")
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String telephone;
    private Integer account;
    @TableField("regTime")
    private Date regTime;
    private String sex;
    private String avatar;
}
