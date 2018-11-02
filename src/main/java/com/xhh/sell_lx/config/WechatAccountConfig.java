package com.xhh.sell_lx.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信账号配置
 * luokai
 * 2018/11/2 0002 下午 4:12
 */

@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatAccountConfig {
    /**
     * 公众平台id
     */
     private String mpAppId;
     
     /**
      * 公众平台秘钥
      */
      private String mpAppSecret;

}
