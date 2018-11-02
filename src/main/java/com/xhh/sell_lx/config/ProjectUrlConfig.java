package com.xhh.sell_lx.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * TODO
 * luokai
 * 2018/11/2 0002 下午 5:02
 */
@Data
@Component
@ConfigurationProperties(prefix = "project-url")
public class ProjectUrlConfig {
    /**
     *  微信公众平台授权url
     */
     private String wechatMpAuthorize;


}
