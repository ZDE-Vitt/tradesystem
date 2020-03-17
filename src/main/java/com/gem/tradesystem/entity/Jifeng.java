package com.gem.tradesystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 积分表
 * </p>
 *
 * @author feip
 * @since 2020-03-07
 */
@Data
public class Jifeng implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 价格
     */
    private String price;

    /**
     * 积分值
     */
    private String value;


}
