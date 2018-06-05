package com.imooc.exception;

import lombok.Data;

/**
 * @author zhy
 * @version 1.0
 * @classDesc:
 * @date 2018/6/5
 * @copyright: 上海英和
 * @QQ: 583760722
 */
@Data
public class UserNotExistException extends RuntimeException {
    private Integer code;

    public UserNotExistException() {
    }

    public UserNotExistException(Integer code) {
        super("user not exist");
        this.code = code;
    }
}
