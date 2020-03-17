package com.gem.tradesystem.controller;


import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;

import com.alipay.api.request.AlipayTradePagePayRequest;

import com.gem.tradesystem.config.AlipayConfig;
import com.gem.tradesystem.entity.User;
import com.gem.tradesystem.service.JifengService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.*;

/**
 * @author: Fei Peng
 * @CreateDate: 2020/3/4 21:08
 * @Description:
 */
@Controller
@RequestMapping("/alipay")
public class AlipayController {
    @Autowired
    private JifengService jifengService;

    @Autowired
    private AlipayClient alipayClient;

    @RequestMapping("/toPay")
    @ResponseBody
    public String  toalipay(String moneyandjifeng,HttpServletRequest request, HttpSession session) throws AlipayApiException, IOException {
//      System.out.println(moneyandjifeng);
        String total_amount = "";
        String jifeng = "";
        String[] str = moneyandjifeng.split("-");
        total_amount = str[0];
        jifeng = str[1];
        System.out.println(total_amount);
        System.out.println(jifeng);
        Integer i = null;
        if (jifeng != null) {
            i = Integer.valueOf(jifeng);
        }
//      System.out.println(total_amount);
//      System.out.println(jifeng);
        //创建API对应的request
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        //设置回调参数
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        Map<String, String> map = new HashMap<>();
        map.put("out_trade_no", UUID.randomUUID().toString());
        map.put("product_code", "FAST_INSTANT_TRADE_PAY");
        map.put("total_amount", total_amount);
        map.put("subject", "积分充值");
        map.put("body", jifeng);
        //map.put("timeout_express","10");
        String param = JSON.toJSONString(map);
        alipayRequest.setBizContent(param);

        String form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
        System.out.println(form);

        User user = (User) session.getAttribute("user");
        jifengService.updateUserJifengById(user.getId(), i);
        return form;
    }

}
