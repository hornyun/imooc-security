package com.imooc.security.core.properties;

import com.imooc.security.core.LoginType;
import lombok.Data;

/**
 * @author zhy
 * @version 1.0
 * @classDesc:
 * @date 2018/6/7
 * @copyright: 上海英和
 * @QQ: 583760722
 */
@Data
public class BrowserProperties {

    private String loginPage = "/imooc-sigIn.html";

    private LoginType loginType = LoginType.JSON;

}
