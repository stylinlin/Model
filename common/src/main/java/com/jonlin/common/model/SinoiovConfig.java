package com.jonlin.common.model;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <br/>
 * 智运 api 配置
 * @author zl
 * @version [V1.0 2018-09-04 13:48]
 */
@Data
@Component
@ConfigurationProperties(prefix = "sinoiov")
public class SinoiovConfig {
    private String apiUrl; // 接口地址
    private String apiUser; // 账号
    private String password; // 密码
    private String client_id; // 客户端 ID
}
