package com.gem.tradesystem.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

/*安全配置类*/
@Configuration   // 代表这个类是配置文件
@EnableWebSecurity
public class SecurityConfiger extends WebSecurityConfigurerAdapter {
    //关于用户认证信息信息类,security自带的类
    @Autowired
    private UserDetailsService customUserService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //解决 SpringSecurityiFrame'X-Frame-Options'to'deny'
        http.headers().frameOptions().disable();
        //禁用跨站请求伪造
        http.csrf().disable();
        //自己用户权限的设置   permitAll() 允许    static静态资源任何人都允许访问
        http.authorizeRequests()
                .antMatchers("/js/**","/css/**","/img/**","/plugins/**","/assets/**").permitAll()
                .antMatchers("/**").permitAll()//前台路径全部放行  //html视图的请求,任何人都可以访问
                .anyRequest().authenticated() //任何请求,登录后可以访问  任何关于control的请求必须登录后放行
                .and()
                //注册页面,首页等等要放行
                .formLogin()
                .loginPage("/") // 设置登录页面引导的control  自定义登录页面(否则用的是security自带的登录页面)
//                .successForwardUrl("/index") //登录成功的默认跳转路径
//                .failureUrl("/user/login?error") //登录失败的跳转路径
                .permitAll() //登录成功之后所有页面放行
                .and()
                .logout().permitAll(); //注销行为任意访问
    }

    //加密算法编写  BCryptPasswordEncoder  盐加 密的算法  123->加密后的字符串  (盐每次都一样  123  时间戳  不支持解密)
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService).passwordEncoder(new BCryptPasswordEncoder()); //user Details Service验证
    }

    /**
     * 配置地址栏不能识别 // 的情况
     * @return
     */
    @Bean
    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        //此处可添加别的规则,目前只设置 允许双 //
        firewall.setAllowUrlEncodedDoubleSlash(true);
        return firewall;
    }
}
