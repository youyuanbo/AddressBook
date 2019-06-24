package com.addressbook;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class testlist {

    @Test
    public void test01(){
        List<String> list = new ArrayList();
        list.add("xiaoyou");
        System.out.println(list.get(0));
    }


    @Test
    public void test02(){
    	new Thread(() -> {

	    }).start();
    }
}
