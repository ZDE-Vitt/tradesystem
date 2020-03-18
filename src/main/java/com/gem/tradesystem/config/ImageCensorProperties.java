package com.gem.tradesystem.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Auther: NoTomato
 * @DATE:2020/3/18 19:34
 * @Description:
 */
@Component
@Data
@ConfigurationProperties(prefix = "baiduimagecensor")
public class ImageCensorProperties {
    private String appid;
    private String apikey;
    private String secretkey;

}
