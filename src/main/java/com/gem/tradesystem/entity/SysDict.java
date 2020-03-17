package com.gem.tradesystem.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author jzhang
 * @since 2020-02-27
 */
@Data
@TableName("sys_dict")
public class SysDict implements Serializable {

    private Integer id;

    /**
     * 类型
     */
    private String typecode;

    /**
     * 字典名
     */
    private String value;

    /**
     * 字典值
     */
    private String name;

    private String description;

    private LocalDateTime createDate;

    private Integer createBy;

    private LocalDateTime updateDate;

    private Integer updateBy;

    @TableLogic
    private String delFlag;


}
