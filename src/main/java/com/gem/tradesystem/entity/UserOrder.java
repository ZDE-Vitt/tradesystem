package com.gem.tradesystem.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: NoTomato
 * @DATE:2020/3/2 11:03
 * @Description:
 */
@Data
public class UserOrder {
    private Integer id ;
    private Integer userid;
    private Integer orderid;
    private Integer sucaiid;
    private Date createtime;
    private Integer orderStatus;

    @TableLogic
    private Integer delFlag;
}
