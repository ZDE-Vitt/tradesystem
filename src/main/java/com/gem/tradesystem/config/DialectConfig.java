package com.gem.tradesystem.config;

import com.gem.tradesystem.dialect.DictDialect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Auther: NoTomato
 * @DATE:2020/2/28 16:34
 * @Description:
 */
@Configuration
public class DialectConfig {
    @Bean
    @ConditionalOnMissingBean
    public DictDialect customDialect(){
        return new DictDialect("自定义方言");
    }
}
