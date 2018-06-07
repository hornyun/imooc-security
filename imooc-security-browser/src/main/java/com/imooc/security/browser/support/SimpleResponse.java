package com.imooc.security.browser.support;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhy
 * @version 1.0
 * @classDesc:
 * @date 2018/6/7
 * @copyright: 上海英和
 * @QQ: 583760722
 */
@Data
public class SimpleResponse implements Serializable {
    private static final long serialVersionUID = 3756862692161388809L;

    public Object content;

    public SimpleResponse() {
    }

    public SimpleResponse(Object content) {
        this.content = content;
    }
}
