package com.addressbook.dao;

import com.addressbook.bean.AddressBook;
import com.addressbook.bean.Person;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressBookDao {

    List<Person> isExistUsername(@Param("username") String username);

    List<Person> login(@Param("person") Person person);

    Integer register(@Param("person") Person Person);

    List<AddressBook> queryAllAddressBook();

    List<Person> queryAllPerson();

    AddressBook queryAddressBookByName(@Param("name") String name);

    int insertAddressBook(@Param("addressBook") AddressBook addressBook);

    int deleteAddressBookByName(@Param("username") String username, @Param("phone") String phone);

    int updateAddressBook(@Param("addressBook") AddressBook addressBook);

}
