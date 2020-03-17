package com.gem.tradesystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 流水表
 * </p>
 *
 * @author feip
 * @since 2020-03-07
 */
@Data

public class Flow implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 流水号
     */
    private String flowNum;

    /**
     * 订单号
     */
    private String orderNum;

    /**
     * 积分ID
     */
    private String jifengId;

    /**
     * 支付金额
     */
    private String paidAmount;

    /**
     * 创建时间
     */
    private Date createTime;


}
