package com.imooc.security.browser.authentication;

import com.imooc.security.core.LoginType;
import com.imooc.security.core.properties.SecurityProperties;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author zhy
 * @version 1.0
 * @classDesc: 登录成功的处理
 * @date 2018/6/7
 * @copyright: 上海英和
 * @QQ: 583760722
 */
@Slf4j
@Component("imoocAuthenticationSuccessHandler")
public class ImoocAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("【登录成功】");
        if (LoginType.JSON == securityProperties.getBrowser().getLoginType()) {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(Objects.toString(authentication));
        } else {
            super.onAuthenticationSuccess(request, response, authentication);
        }


    }
}
