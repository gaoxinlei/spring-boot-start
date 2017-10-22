package net.self.spring.boot.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

//springmvc专用的配置,覆盖默认的自动配置,尝式加一个拦截器
@Configuration
public class MySpringMVCConfig extends WebMvcConfigurerAdapter{

    //1.继承WebMvcConfigureAdapter  实现方法.
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor interceptor = new HandlerInterceptor() {
            //2建立一个拦截器,实现拦截器生命周期内的方法.
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
                    throws Exception {
                System.out.println("prehandle...");
                return true;
            }
            
            @Override
            public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                    ModelAndView modelAndView) throws Exception {
                System.out.println("post handler...");
                
            }
            
            @Override
            public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
                    throws Exception {
                System.out.println("after completion...");
                
            }
        };
        //3将拦截器加入链.
        registry.addInterceptor(interceptor);
    }
}
