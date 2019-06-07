
package com.addressbook.service.impl;

import com.addressbook.bean.AddressBook;
import com.addressbook.bean.Person;
import com.addressbook.dao.AddressBookDao;
import com.addressbook.service.AddressBookService;
import com.addressbook.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class AddressBookServiceImpl implements AddressBookService {

    SqlSession session = MyBatisUtil.getSession();
    AddressBookDao addressBookDao  = session.getMapper(AddressBookDao.class);

    @Override
    public boolean isExistUsername(String username) {
        List<Person> users = addressBookDao.isExistUsername(username);
        if (users.size() == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean login(Person person) {
        List<Person> users = addressBookDao.login(person);
        if (users.size() == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean register(Person person) {
        int row = addressBookDao.register(person);
        if (row == 1){
            return true;
        }
        return false;
    }

    @Override
    public String[][] findAllAddressBook() {

        List<AddressBook> addressBooks = addressBookDao.queryAllAddressBook();

        int addressBooksSize = addressBooks.size();

        if (addressBooksSize == 0){
            return null;
        }

        String data[][] = new String[addressBooksSize][];

        for (int i = 0; i < addressBooksSize; i++) {

            String addressBook[] = {
                    String.valueOf(addressBooks.get(i).getId()),
                    addressBooks.get(i).getUsername(),
                    addressBooks.get(i).getSex(),
                    addressBooks.get(i).getPhone(),
                    addressBooks.get(i).getHome(),
                    addressBooks.get(i).getAddress(),
                    addressBooks.get(i).getBirthday(),
                    addressBooks.get(i).getUserGroup(),
                    addressBooks.get(i).getEmail(),
                    addressBooks.get(i).getCompany(),
                    addressBooks.get(i).getNickname(),
                    addressBooks.get(i).getNotes()
            };
            data[i] = addressBook;
        }

        return data;
    }

    @Override
    public List<Person> queryAllPerson() {

        return addressBookDao.queryAllPerson();
    }

    @Override
    public String[][] queryAddressBookByName(String name) {
        AddressBook people = addressBookDao.queryAddressBookByName(name);
        if (people == null){
            return null;
        }
        String data[][] = {
                new String[]{
                        String.valueOf(people.getId()),
                        people.getUsername(),
                        people.getSex(),
                        people.getPhone(),
                        people.getHome(),
                        people.getAddress(),
                        people.getBirthday(),
                        people.getUserGroup(),
                        people.getEmail(),
                        people.getCompany(),
                        people.getNickname(),
                        people.getNotes()
                }
        };

        return data;
    }

    @Override
    public boolean insertAddressBook(AddressBook addressBook) {

        int i = addressBookDao.insertAddressBook(addressBook);
        if (i == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAddressBookByName(String username, String phone) {

        AddressBook addressBook = addressBookDao.queryAddressBookByName(username);
        if (addressBook == null){
            return false;
        }
        int i = addressBookDao.deleteAddressBookByName(username, phone);
        if (i == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateAddressBook(AddressBook addressBook) {
        int i = addressBookDao.updateAddressBook(addressBook);
        if (i == 1) {
            return true;
        }
        return false;
    }
}
