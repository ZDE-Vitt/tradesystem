package com.gem.tradesystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 积分订单表
 * </p>
 *
 * @author feip
 * @since 2020-03-07
 */
@Data
public class ChongzhiOrder implements Serializable {

    private static final long serialVersionUID = 1L;


    private String id;

    /**
     * 订单号
     */
    private String orderNum;

    /**
     * 订单状态
            10：待付款
            20：已付款
     */
    private String orderStatus;

    /**
     * 订单金额
     */
    private String orderAmount;

    /**
     * 实际支付金额
     */
    private String paidAmount;

    /**
     * 积分表ID
     */
    private String jifengId;

    /**
     * 订单创建时间
     */

    private Date createTime;

    /**
     * 支付时间
     */

    private Date paidTime;

}
