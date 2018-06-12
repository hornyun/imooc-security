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
public class ImageCodeProperties extends SmsCodeProperties {
    private Integer width = 67;
    private Integer height = 23;

    public ImageCodeProperties() {
        setLength(4);
    }
}
