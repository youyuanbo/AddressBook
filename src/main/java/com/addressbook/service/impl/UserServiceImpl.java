package com.addressbook.service.impl;

import com.addressbook.bean.User;
import com.addressbook.bean.UserExample;
import com.addressbook.dao.UserMapper;
import com.addressbook.service.IUserService;
import com.addressbook.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserServiceImpl implements IUserService {

    SqlSession sqlSession = MyBatisUtil.getSession();
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

    @Override
    public boolean isExistUsername(String username) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList.size() != 1){
            return false;
        }
        return true;

    }

    @Override
    public boolean login(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
//        criteria.andIdEqualTo(user.getId());
        criteria.andUsernameEqualTo(user.getUsername());
        criteria.andPasswordEqualTo(user.getPassword());
        List<User> userList = userMapper.selectByExample(example);
        if (userList.size() != 1){
            return false;
        }
        return true;
    }

    @Override
    public boolean register(User user) {


        int insert = userMapper.insert(user);
        if (insert != 1){
            return false;
        }
        return true;
    }
}
