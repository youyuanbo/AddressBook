package com.addressbook.service;

import com.addressbook.bean.User;

public interface IUserService {
    boolean isExistUsername(String name);

    boolean login(User user);

    boolean register(User user);

}
