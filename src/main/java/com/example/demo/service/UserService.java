package com.example.demo.service;

import com.example.demo.model.User;

/**
 * @description： TODO
 * @author： Mr.He
 * @date： 2019-06-17 19:59
 **/
public interface UserService {

     boolean login(String userName,String password);

     User selectUserByID(int id);
}
