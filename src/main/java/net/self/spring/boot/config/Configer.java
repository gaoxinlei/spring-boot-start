package net.self.spring.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import net.self.spring.boot.dao.UserDao;

@Configuration
@ComponentScan(basePackages= {"net.self.spring.boot.**"})
public class Configer {

    //获得UserDao的配置.相当于用容器管理了UserDao,可以被注入到其他bean的属性.
    @Bean
    public UserDao getUserDao() {
        return new UserDao();
    }
}
