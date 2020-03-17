package com.gem.tradesystem;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: NoTomato
 * @DATE:2020/2/25 14:00
 * @Description:
 */
@Configuration
@MapperScan(basePackages = {"com.gem.tradesystem.back.mapper","com.gem.tradesystem.mapper"})
public class MybatisPlusConfig {
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
