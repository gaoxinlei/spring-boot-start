package net.self.spring.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import net.self.spring.boot.bean.User;
import net.self.spring.boot.dao.UserDao;

@Service
@Qualifier("UserService")
public class UserService {

    @Autowired
    private UserDao userDao;
    
    public List<User> getAllUsers(){
        return userDao.selectAllUsers();
    }
}
