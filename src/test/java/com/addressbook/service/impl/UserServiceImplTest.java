package com.addressbook.service.impl;

import com.addressbook.bean.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    UserServiceImpl userService = new UserServiceImpl();

    @Test
    public void isExistUsername() {
        String username = "xiaoyou";
        boolean existUsername = userService.isExistUsername(username);
        System.out.println(existUsername);
    }

    @Test
    public void login() {

        String username = "xiaoyou";
        String password = "xiaoyo";
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        boolean login = userService.login(user);
        System.out.println(login);
    }

    @Test
    public void register() {
        String username = "xiaoyang";
        String password = "xiaoyang";
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        boolean register = userService.register(user);
        System.out.println(register);
    }
}