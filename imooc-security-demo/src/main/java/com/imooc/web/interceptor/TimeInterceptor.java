package com.imooc.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhy
 * @version 1.0
 * @classDesc:
 * @date 2018/6/5
 * @copyright: 上海英和
 * @QQ: 583760722
 */
@Slf4j
@Component
public class TimeInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        log.info("preHandle");
        request.setAttribute("start", System.currentTimeMillis());
        log.info("【handler class:{}】", o.getClass());
        log.info("【handler:{}】", o);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        long cost = System.currentTimeMillis() - (long) request.getAttribute("start");
        log.info("postHandle,and cost time:{}", cost);


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

        long cost = System.currentTimeMillis() - (long) request.getAttribute("start");
        log.info("afterCompletion cost time is {},and exception is {}", cost, e);

    }
}
