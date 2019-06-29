package com.example.demo.dao;

import com.example.demo.model.User;

import java.util.List;

public interface UserMapper {

    List<User> selectAllUser();

    int deleteByPrimaryKey(Integer id);

    int insert(User user);

    int insertSelective(User user);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User user);

    int updateByPrimaryKey(User user);

    User findByUserNameAndPassword(String userName,String password);
}