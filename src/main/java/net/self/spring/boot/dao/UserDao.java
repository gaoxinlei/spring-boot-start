package net.self.spring.boot.dao;

import java.util.ArrayList;
import java.util.List;

import net.self.spring.boot.bean.User;

public class UserDao {

    public List<User> selectAllUsers(){
        List<User> users = new ArrayList<>();
        for(int i=0;i<10;i++) {
            User user = new User();
            users.add(user);
            user.setAge(20+i);
            user.setUsername("u_id_"+i);
            user.setPassword("pass_"+i);
            user.setHome("Lu_"+i);
        }
        
        return users;
    }
}
