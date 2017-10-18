package net.self.spring.boot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.mchange.v2.c3p0.ComboPooledDataSource;
@Configuration//网上用springboot获取c3p0连接池的方法.自用application.xml
public class DataSourceConfig {

  //方法名即bean的id,因为最好用类名小写.
    @Bean(name="dataSource2")//它标注的bean可以用application.getBean 亦可用autowire注入.
    @ConfigurationProperties(prefix="c3p0",
        ignoreInvalidFields=true,ignoreUnknownFields=true)
    //@Qualifier(value="dataSource")
    @Primary
    public DataSource dataSource() {
        DataSource source = DataSourceBuilder.create()
                .type(ComboPooledDataSource.class)
                .build();
        return source;
    }
}
