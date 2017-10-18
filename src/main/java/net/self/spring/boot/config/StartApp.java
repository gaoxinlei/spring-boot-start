package net.self.spring.boot.config;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

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
        
        //3.测试能否获得数据源.
        //第一种方式的数据源.
        DataSource source = (DataSource) context.getBean("dataSource");
        //第二种方式的数据源.
        DataSource s = (DataSource) context.getBean("dataSource2");
        try {
            System.out.println("方式一获得连接成功:"+source.getConnection());
            System.out.println("方式二获得连接成功:"+s.getConnection());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //关闭容器
        context.stop();
    }
}
