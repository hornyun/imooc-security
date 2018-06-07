package com.imooc.security.core;

import com.imooc.security.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhy
 * @version 1.0
 * @classDesc:
 * @date 2018/6/7
 * @copyright: 上海英和
 * @QQ: 583760722
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {

}
