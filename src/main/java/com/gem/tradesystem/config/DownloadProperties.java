package com.gem.tradesystem.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//  domain: http://q6rklxhce.bkt.clouddn.com
//          accesskey: iuurc9l3zpW5qEIn_yU4BC-3nqx8xiTZ7XOF7uQI
//          secretkey: 14Wik517ZD7FpIBrdXLR-vtlCvNmP1rTLg0zdtP5
//          bucket: picuploading

@Component
@Data
@ConfigurationProperties(prefix = "qi")
public class DownloadProperties {
    private String domain;
    private String accessKey;
    private String secretKey;
    private String bucket;
}
