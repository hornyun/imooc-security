package com.imooc.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author zhy
 * @version 1.0
 * @classDesc:
 * @date 2018/6/12
 * @copyright: 上海英和
 * @QQ: 583760722
 */
public interface ValidateCodeProcessor {
    String SESSION_KEY_PREFIX = "SESSION_KEY_FOR_CODE_";

    /**
     * 穿件校验码
     *
     * @param request
     * @throws Exception
     */
    void create(ServletWebRequest request) throws Exception;


    /**
     * 校验码验证
     *
     * @param request
     */
    void validate(ServletWebRequest request);
}
