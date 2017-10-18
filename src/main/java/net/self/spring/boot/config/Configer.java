package net.self.spring.boot.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import net.self.spring.boot.dao.UserDao;

@Configuration//配置类标识注解
@PropertySource(value="classpath:database.properties")
@ComponentScan(basePackages= {"net.self.spring.boot.**"})//要扫描的容器管理的类所在的包
public class Configer {

    //获得UserDao的配置.相当于用容器管理了UserDao,可以被注入到其他bean的属性.
    @Bean
    public UserDao getUserDao() {
        System.out.println("driverClass:"+driverClass);
        return new UserDao();
    }
    
    //读取数据源配置。不能使用以下方式配置setDriverClass等方法.
    @Value("${c3p0.driverClass}")
    private String driverClass;
    @Value("${c3p0.jdbcUrl}")
    private String jdbcUrl;
    @Value("${c3p0.user}")
    private String username;
    @Value("${c3p0.password}")
    private String password;
    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource source = new ComboPooledDataSource();
        try {
            source.setDriverClass(driverClass);
        } catch (PropertyVetoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        source.setUser(username);
        source.setPassword(password);
        source.setJdbcUrl(jdbcUrl);
        return source;
    }
}
