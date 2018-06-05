package com.imooc.web.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author zhy
 * @version 1.0
 * @classDesc:
 * @date 2018/6/5
 * @copyright: 上海英和
 * @QQ: 583760722
 */
@Slf4j
public class TimeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("{} init.....", this.getClass());
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("{} before filter", this.getClass());
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        long cost = System.currentTimeMillis() - start;
        log.info("{} after filter,and cost time = {}", this.getClass(), cost);
    }

    @Override
    public void destroy() {
        log.info("{} destroy...", this.getClass());
    }
}
