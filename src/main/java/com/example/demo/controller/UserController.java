package com.example.demo.controller;

import com.example.demo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description： userController
 * @author： Mr.He
 * @date： 2019-06-13 21:41
 **/
@RestController
public class UserController {

    @Resource
    private UserService userService;

    private Logger log = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/hello")
    public Object hello(){
        return "hello";
    }

    @RequestMapping("/login")
    public Object login(String userName,String password) {
        log.debug("进入login方法");
        boolean flag = userService.login(userName,password);
        log.debug("flag={}",flag);
        if(flag){
            return "登陆成功";
        }else{
            return "登陆失败";
        }
    }

    @RequestMapping("/ttlCache")
    public Object ttlCache(int id){
        return userService.selectUserByID(id);
    }


}
