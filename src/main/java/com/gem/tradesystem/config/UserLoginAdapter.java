package com.gem.tradesystem.config;

import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@SpringBootApplication
@EnableCaching
public class UserLoginAdapter implements WebMvcConfigurer {
    @Autowired
    private UserLoginInterceptor userLoginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //添加对用户是否登录的拦截器，并添加过滤项、排除项
        registry.addInterceptor(userLoginInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/css/**","/js/**","/img/**","/assets/**")//排除样式、脚本、图片等资源文件
                .excludePathPatterns("/")//排除登录页面
                .excludePathPatterns("/index/login")//排除用户点击登录按钮
                .excludePathPatterns("/reg/**")//排除注册页面
                .excludePathPatterns("/index/register")//跳转到注册页面
                .excludePathPatterns("/product/**");//排除素材展示页面
    }
}
