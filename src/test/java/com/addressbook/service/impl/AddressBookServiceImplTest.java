package com.addressbook.service.impl;

import com.addressbook.bean.AddressBook;
import org.junit.Test;

import java.text.DateFormat;
import java.util.Date;

import static org.junit.Assert.*;

public class AddressBookServiceImplTest {

    AddressBookServiceImpl addressBookService = new AddressBookServiceImpl();

    @Test
    public void findAllAddressBook() {
        String[][] allAddressBook = addressBookService.findAllAddressBook();
        for (String[] AddressBooks : allAddressBook) {
            for (String addressBook : AddressBooks) {
                System.out.println(addressBook);
            }
        }
    }

    @Test
    public void queryAddressBookByName() {
        String name = "13540632481";
        String[][] queryAddressBookByName = addressBookService.queryAddressBookByName(name);
        for (String[] strings : queryAddressBookByName) {
            for (String string : strings) {
                System.out.println(string);
            }
        }
    }

    @Test
    public void insertAddressBook() {
        AddressBook addressBook = new AddressBook();
        addressBook.setUsername("xiaoliang");
        addressBook.setPhone("13540632481");
        addressBook.setAddress("tianjing");
        addressBook.setHome("020-2813564");
        addressBook.setBirthday("2019-6-19");
        addressBook.setUsergroup("family");
        addressBook.setEmail("312202@qq.com");
        addressBook.setCompany("ali");
        addressBook.setNickname("daliang");
        addressBook.setNotes("loveyou");

        boolean b = addressBookService.insertAddressBook(addressBook);
        System.out.println(b);
    }

    @Test
    public void deleteAddressBookByName() {
        String name = "xiaolliang";
        String phone = "13540632481";
        boolean b = addressBookService.deleteAddressBookByName(name, phone);
        System.out.println(b);
    }

    @Test
    public void updateAddressBook() {
        AddressBook addressBook = new AddressBook();
        addressBook.setId(3);
        addressBook.setUsername("xiaoliang");
        boolean b = addressBookService.updateAddressBook(addressBook);
        System.out.println(b);
    }

    @Test
    public void isExistUsername() {
        String username = "xiaoyou";
        boolean existUsername = addressBookService.isExistUsername(username);
        System.out.println(existUsername);
    }

    @Test
    public void isExistPhone() {
        String phone = "15284924281";
        boolean existUsername = addressBookService.isExistPhone(phone);
        System.out.println(existUsername);
    }

    @Test
    public void isExistEmail() {
        String email = "95132@qq.com";
        boolean existUsername = addressBookService.isExistEmail(email);
        System.out.println(existUsername);
    }
}