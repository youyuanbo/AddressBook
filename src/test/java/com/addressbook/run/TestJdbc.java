package com.addressbook.run;


import com.addressbook.service.impl.AddressBookServiceImpl;
import com.addressbook.util.CheckUtil;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
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

    @Test
    public void test03(){
        String username = "xiaoyou";
        AddressBookServiceImpl addressBookService = new AddressBookServiceImpl();
        String[][] strings = addressBookService.queryAddressBookByName(username);
        for (String[] string : strings) {
            for (String s : string) {
                System.out.println(s);
            }
        }
    }

    @Test
    public void test04() throws Exception{
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        File configFile = new File("E:\\workspace\\idea\\project\\AddressBook\\src\\main\\resources\\generator.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }


}
