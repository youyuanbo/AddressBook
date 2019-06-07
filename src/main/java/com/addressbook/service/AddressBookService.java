package com.addressbook.service;

import com.addressbook.bean.AddressBook;
import com.addressbook.bean.Person;

import java.util.List;

public interface AddressBookService {

    boolean isExistUsername(String username);

    boolean login(Person person);

    boolean register(Person person);

    String[][] findAllAddressBook();

    List<Person> queryAllPerson();

    String[][] queryAddressBookByName(String name);

    boolean insertAddressBook(AddressBook addressBook);

    boolean deleteAddressBookByName(String username, String phone);

    boolean updateAddressBook(AddressBook addressBook);
}
