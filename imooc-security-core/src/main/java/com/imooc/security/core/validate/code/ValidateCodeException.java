package com.imooc.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * @author zhy
 * @version 1.0
 * @classDesc:
 * @date 2018/6/8
 * @copyright: 上海英和
 * @QQ: 583760722
 */
public class ValidateCodeException extends AuthenticationException {


    private static final long serialVersionUID = 8848687408293611636L;

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
