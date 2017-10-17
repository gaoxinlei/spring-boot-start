package net.self.spring.boot.config;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.self.spring.boot.bean.User;
import net.self.spring.boot.service.UserService;

public class StartApp {

    public static void main(String[] args) {
        //1.建立java配置类对象的容器ApplicationContext
        AnnotationConfigApplicationContext context = 
                new AnnotationConfigApplicationContext(Configer.class);
        //开启容器
        //context.start();
        //2.从容器中获得已经交给容器管理的service bean
        UserService userService = context.getBean(UserService.class);
        List<User> users = userService.getAllUsers();
        System.out.println(users);
        //关闭容器
        context.stop();
    }
}
