package net.self.spring.boot;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


//本注解将自动配置所有引入的包。若不希望，可给注解添加 exclude属性为哪些类。
@SpringBootApplication//springboot 应用 入口，默认扫描 当前注解标注类所在的包及子包下
@Controller
@Configuration
public class HelloBoot {

    @ResponseBody//让信息转化器输出返回结果.
    @RequestMapping("/helloBoot")
    public String helloBoot() {
        return "hello";
    }
    //入口方法
    public static void main(String[] args) {
        //SpringApplication.run(HelloBoot.class, args);
        //取消banners.
        SpringApplication application = new SpringApplication(HelloBoot.class);
        application.setBannerMode(Mode.OFF);
        application.run(args);
    }
}
