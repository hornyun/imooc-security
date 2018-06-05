package com.imooc.web.form;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhy
 * @version 1.0
 * @classDesc:
 * @date 2018/6/5
 * @copyright: 上海英和
 * @QQ: 583760722
 */
@Data
public class UserQueryCondition implements Serializable {
    private static final long serialVersionUID = 1878970541039745883L;

    private String username;

    private Integer age;

    private Integer ageTo;

    private String xxx;
}
