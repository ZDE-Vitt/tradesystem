package com.gem.tradesystem.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.Format;
import java.util.Date;
@Data
@TableName("sucai")
public class Sucai {
    private Integer id;
    private String num;
    private String name;
    private Integer money;
    private Integer downnum;
    private Integer favnum;
    private Integer tagid;
    private String suffix;
    private String size;

    @TableField(exist = false)
    private String pix;

    @TableField("picurl")
    private String picUrl;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;

    private String author;
    private Integer userid;
    private String save;
    private String description;
    private Integer status;

    @TableField(exist = false)
    private String statusname;

    @TableField(exist = false)
    private String formatTime;

    @TableField(exist = false)
    private String tagName;

    @TableLogic
    private Integer delFlag;

}
