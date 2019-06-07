
/*
package com.addressbook.dao.impl;

import com.addressbook.bean.AddressBook;
import com.addressbook.bean.User;
import com.addressbook.dao.AddressBookDao;
import com.addressbook.util.ViewUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import java.sql.SQLException;
import java.util.List;

public class AddressBookDaoImpl implements AddressBookDao {

    QueryRunner queryRunner = ViewUtil.getRunner();

    @Override
    public List<User> isExistUsername(String username) {

        try {
            List<User> users = queryRunner.query("select * from user where username = ?", new BeanListHandler<>(User.class), username);
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> login(User user) {
        try {
            List<User> users = queryRunner.query("select username from user where " +
                    "username = ? and password = ?", new BeanListHandler<>(User.class),
                    user.getUsername(), user.getPassword());
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Integer register(User user) {
        try {
            int row = queryRunner.update("insert into user(username, password) values (?, ?)", user.getUsername(), user.getPassword());
            return row;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<AddressBook> queryAllAddressBook() {
        List<AddressBook> addressBooks ;
        try {
            addressBooks = queryRunner.query("select id,username, phone, home, address, birthday, userGroup, email, " +
                    "company, nickName, notes from addressbook", new BeanListHandler<>(AddressBook.class));
            return addressBooks;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
*/

