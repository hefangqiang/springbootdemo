package com.example.demo.controller;

import com.example.demo.dao.UserMapper;
import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description： restful
 * @author： Mr.He
 * @date： 2019-06-29 12:49
 **/
@RestController
@RequestMapping("/rest")
public class RestFulController {

    @Resource
    private UserMapper userMapper;

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public Object findAllUser(){
        List<User> users = userMapper.selectAllUser();
        return users;
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public Object findOneUser(@PathVariable int id){
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public void createUser(@RequestBody User user){
        userMapper.insert(user);
    }

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public void modifyUser(@RequestBody User user){
        userMapper.updateByPrimaryKey(user);
    }

    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public void modifyUser(@PathVariable int id){
        userMapper.deleteByPrimaryKey(id);
    }


}
