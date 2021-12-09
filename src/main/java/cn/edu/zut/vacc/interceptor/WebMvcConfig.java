package cn.edu.zut.vacc.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：王志恒（1024044696@qq.com）
 * @date ：Created in 2021/12/9 15:27
 * @description：
 * @modified By：
 * @version:
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new Baseinterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login");
    }

}
