package com.gem.tradesystem.entity;

import lombok.Data;

/**
 * @Auther: NoTomato
 * @DATE:2020/3/4 22:05
 * @Description: 拓展类，由于前端页面数据加载的顺序问题，所以添加一个拓展类
 */
@Data
public class UserOrderCustom extends UserOrder {

    //定义的字符串时间用于在前台页面显示格式化后的时间
    private String time;

    //订单显示的类型状态和定价素材名称
    private String sucaiType;
    private String sucainame;
    private Integer sucaiMoney;
    private Integer sucaiId;
    private String orderStatusName;
    private String picUrl;

    @Override
    public String toString() {
        return  super.toString() +
                "time='" + time + '\'' +
                ", sucaiType='" + sucaiType + '\'' +
                ", sucaiMoney=" + sucaiMoney +
                '}';
    }
}
