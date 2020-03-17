package com.gem.tradesystem.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Johnson
 * @date 2019/12/16/ 09:35:36
 */
@Component
@ConfigurationProperties(prefix = "upload")
public class UploadProperties {

    private Local local = new Local();

    public Local getLocal() {
        return local;
    }

    /**
     * @author: Johnson
     * @Date: 2019/12/16
     * 本地上传配置
     */
    public class Local {
    }

    private Qiniu qiniu = new Qiniu();

    public Qiniu getQiniu() {
        return qiniu;
    }

    /**
     * @author: Johnson
     * @Date: 2019/12/16
     * 七牛云上传配置
     */
    public class Qiniu {
        /**
         * 域名
         */
        private String domain;

        /**
         * 从下面这个地址中获取accessKey和secretKey
         * https://portal.qiniu.com/user/key
         */
        private String accessKey;

        private String secretKey;

        /**
         * 存储空间名
         */
        private String bucket;

        public String getDomain() {
            return domain;
        }

        public void setDomain(String domain) {
            this.domain = domain;
        }

        public String getAccessKey() {
            return accessKey;
        }

        public void setAccessKey(String accessKey) {
            this.accessKey = accessKey;
        }

        public String getSecretKey() {
            return secretKey;
        }

        public void setSecretKey(String secretKey) {
            this.secretKey = secretKey;
        }

        public String getBucket() {
            return bucket;
        }

        public void setBucket(String bucket) {
            this.bucket = bucket;
        }
    }
}