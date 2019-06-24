package com.addressbook.service;

import com.addressbook.bean.AddressBook;


public interface AddressBookService {


    String[][] findAllAddressBook();

    String[][] queryAddressBookByName(String name);

    boolean insertAddressBook(AddressBook addressBook);

    boolean deleteAddressBookByName(String username, String phone);

    boolean updateAddressBook(AddressBook addressBook);

    boolean isExistUsername(String username);

    boolean isExistPhone(String phone);

    boolean isExistEmail(String email);

    AddressBook findOne(String username);
}
