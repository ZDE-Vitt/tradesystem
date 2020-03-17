package com.gem.tradesystem.back.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: NoTomato
 * @DATE:2020/3/2 11:03
 * @Description:
 */
@TableName("user_order")
@Data
public class Order implements Serializable {
    private Integer id ;
    private Integer userid;
    private Integer orderid;
    private Integer sucaiid;
    private Date createtime;
    private Integer orderStatus;

    @TableLogic
    private Integer delFlag;

    @TableField(exist = false)
    private String time;

    @TableField(exist = false)
    private String status;

}
