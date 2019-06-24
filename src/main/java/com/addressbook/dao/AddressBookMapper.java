package com.addressbook.dao;

import com.addressbook.bean.AddressBook;
import com.addressbook.bean.AddressBookExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressBookMapper {
    long countByExample(AddressBookExample example);

    int deleteByExample(AddressBookExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AddressBook record);

    int insertSelective(AddressBook record);

    List<AddressBook> selectByExample(AddressBookExample example);

    AddressBook selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AddressBook record, @Param("example") AddressBookExample example);

    int updateByExample(@Param("record") AddressBook record, @Param("example") AddressBookExample example);

    int updateByPrimaryKeySelective(AddressBook record);

    int updateByPrimaryKey(AddressBook record);
}