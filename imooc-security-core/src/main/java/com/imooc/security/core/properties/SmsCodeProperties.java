package com.imooc.security.core.properties;

import lombok.Data;

/**
 * @author zhy
 * @version 1.0
 * @classDesc:
 * @date 2018/6/11
 * @copyright: 上海英和
 * @QQ: 583760722
 */
@Data
public class SmsCodeProperties {
    private int length = 6;
    private int expireIn = 60;

    private String url;

}
