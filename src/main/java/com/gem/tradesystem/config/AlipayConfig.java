package com.gem.tradesystem.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author: Fei Peng
 * @CreateDate: 2020/3/4 16:24
 * @Description:
 */
@Configuration
@PropertySource("classpath:alipay.properties")
public class AlipayConfig {
    @Value("${gatewayUrl}")
    private String alipay_url;
    @Value("${merchant_private_key}")
    private String app_private_key;
    @Value("${app_id}")
    private String app_id;
    public final static String format = "json";
    public final static String charset = "utf-8";
    public final static String sign_type = "RSA2";
    public static String return_url;
    public static String notify_url;
    public static String alipay_public_key;

    @Value("${alipay_public_key}")
    public void setAlipay_public_key(String alipay_public_key) {
        AlipayConfig.alipay_public_key = alipay_public_key;
    }
    @Value("${return_url}")
    public void setReturn_url(String return_url) {
        AlipayConfig.return_url = return_url;
    }


    @Value("${notify_url}")
    public void setNotify_url(String notify_url) {
        AlipayConfig.notify_url = notify_url;
    }


    @Bean
    public AlipayClient alipayClient() {
        AlipayClient alipayClient = new DefaultAlipayClient(alipay_url, app_id, app_private_key, format, charset, alipay_public_key, sign_type);
        return alipayClient;
    }
}
