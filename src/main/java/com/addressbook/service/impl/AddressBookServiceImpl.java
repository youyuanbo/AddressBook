
package com.addressbook.service.impl;

import com.addressbook.bean.AddressBook;
import com.addressbook.bean.AddressBookExample;
import com.addressbook.dao.AddressBookMapper;
import com.addressbook.service.AddressBookService;
import com.addressbook.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

@SuppressWarnings("all")
public class AddressBookServiceImpl implements AddressBookService {

    SqlSession session = MyBatisUtil.getSession();
    AddressBookMapper addressBookMapper = session.getMapper(AddressBookMapper.class);


    @Override
    public String[][] findAllAddressBook() {

        List<AddressBook> addressBooks = addressBookMapper.selectByExample(null);

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
                    addressBooks.get(i).getUsergroup(),
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
    public String[][] queryAddressBookByName(String name) {
        
        AddressBookExample addressBookExample = new AddressBookExample();
        AddressBookExample.Criteria criteria = addressBookExample.createCriteria();
        criteria.andUsernameEqualTo(name);
        addressBookExample.or(addressBookExample.createCriteria().andPhoneEqualTo(name));

        List<AddressBook> addressBooks = addressBookMapper.selectByExample(addressBookExample);
        if (addressBooks.size() == 0){
            return null;
        }
        String data[][] = {
                new String[]{
                        String.valueOf(addressBooks.get(0).getId()),
                        addressBooks.get(0).getUsername(),
                        addressBooks.get(0).getSex(),
                        addressBooks.get(0).getPhone(),
                        addressBooks.get(0).getHome(),
                        addressBooks.get(0).getAddress(),
                        addressBooks.get(0).getBirthday(),
                        addressBooks.get(0).getUsergroup(),
                        addressBooks.get(0).getEmail(),
                        addressBooks.get(0).getCompany(),
                        addressBooks.get(0).getNickname(),
                        addressBooks.get(0).getNotes()
                }
        };

        return data;
    }

    @Override
    public boolean insertAddressBook(AddressBook addressBook) {

        int i = addressBookMapper.insertSelective(addressBook);
        if (i == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteAddressBookByName(String name, String phone) {

        AddressBookExample example = new AddressBookExample();
        AddressBookExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(name);
        criteria.andPhoneEqualTo(phone);
        List<AddressBook> addressBooks = addressBookMapper.selectByExample(example);
        if (addressBooks.size() != 1){
            return false;
        }

        addressBookMapper.deleteByExample(example);
        return true;
    }

    @Override
    public boolean updateAddressBook(AddressBook addressBook) {
        AddressBookExample example = new AddressBookExample();
        AddressBookExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(addressBook.getUsername());
        int i = addressBookMapper.updateByExampleSelective(addressBook, example);
        if (i == 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean isExistUsername(String username) {
        AddressBookExample example = new AddressBookExample();
        AddressBookExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<AddressBook> addressBooks = addressBookMapper.selectByExample(example);
        if (addressBooks.size() == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean isExistPhone(String phone) {
        AddressBookExample example = new AddressBookExample();
        AddressBookExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(phone);
        List<AddressBook> addressBooks = addressBookMapper.selectByExample(example);
        if (addressBooks.size() == 1){
            return true;
        }
        return false;
    }

    @Override
    public boolean isExistEmail(String email) {
        AddressBookExample example = new AddressBookExample();
        AddressBookExample.Criteria criteria = example.createCriteria();
        criteria.andEmailEqualTo(email);
        List<AddressBook> addressBooks = addressBookMapper.selectByExample(example);
        if (addressBooks.size() == 1){
            return true;
        }
        return false;
    }

    @Override
    public AddressBook findOne(String username) {
        AddressBookExample addressBookExample = new AddressBookExample();
        AddressBookExample.Criteria criteria = addressBookExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<AddressBook> addressBooks = addressBookMapper.selectByExample(addressBookExample);
        return addressBooks.get(0);
    }
}
