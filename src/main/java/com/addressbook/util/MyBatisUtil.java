package com.addressbook.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        String resource = "mybatis.xml";
        InputStream stream = null;
        try {
            stream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(stream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (stream != null){
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static SqlSession getSession(){
        return sqlSessionFactory.openSession(true);
    }

}
