package com.addressbook.run;


import com.addressbook.bean.Person;
import com.addressbook.service.impl.AddressBookServiceImpl;
import com.addressbook.util.CheckUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.junit.Test;

import java.util.List;

public class TestJdbc {

    @Test
    public void test01(){

        AddressBookServiceImpl addressBookService = new AddressBookServiceImpl();

        String[][] addressBook = addressBookService.findAllAddressBook();
        int size = addressBook.length;
        int size1 = addressBook[0].length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size1; j++) {
                System.out.print(addressBook[i][j] + "\t");
            }
            System.out.println();
        }
    }

    @Test
    public void test02(){
//        SqlSession session = MyBatisUtil.getSession();
//        AddressBookDao addressBookDao = session.getMapper(AddressBookDao.class);

//        SqlSession session = MyBatisUtil.getSession();
//        AddressBookDao mapper = session.getMapper(AddressBookDao.class);
//        PageHelper.startPage(1,5);
//        List<Person> people = mapper.queryAllPerson();
//        for (Person person : people) {
//            System.out.println(person);
//        }

        System.out.println(CheckUtil.checkUsername("xiaoyou"));

    }
}
