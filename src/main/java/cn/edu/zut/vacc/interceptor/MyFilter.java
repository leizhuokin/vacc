package cn.edu.zut.vacc.interceptor;


import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.util.logging.LogRecord;

/**
 * @author ：王志恒（1024044696@qq.com）
 * @date ：Created in 2021/12/9 16:03
 * @description：
 * @modified By：
 * @version:
 */
@Order(1)
@WebFilter(filterName = "myFilter1",urlPatterns = "/*",initParams = {
        @WebInitParam(name = "URL",value = "http://localhost:8080")
})
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化过滤器");
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进入目标资源之前先干点啥");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("处理一下服务端返回的response");
    }
    @Override
    public void destroy() {
        System.out.println("过滤器被销毁了");
    }
}