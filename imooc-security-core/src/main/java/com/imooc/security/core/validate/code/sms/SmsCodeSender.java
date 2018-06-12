package com.imooc.security.core.validate.code.sms;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zhy
 * @version 1.0
 * @classDesc:
 * @date 2018/6/11
 * @copyright: 上海英和
 * @QQ: 583760722
 */

public interface SmsCodeSender {
    default void send(String mobile, String code) {
        System.out.println("【"+mobile+"】 send a message which is" +code);
    }
}
