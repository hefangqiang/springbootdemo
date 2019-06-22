package com.example.demo.service.impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.RedisConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description： TODO
 * @author： Mr.He
 * @date： 2019-06-17 20:00
 **/
@Service
public class UserServiceImpl implements UserService {



    @Resource
    private UserMapper userMapper;

    @Override
    public boolean login(String userName,String password) {
        User user = userMapper.findByUserNameAndPassword(userName,password);
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    @Cacheable( value ="user",key = "'id:' +#id",cacheManager = RedisConfig.CacheManagerName.REDIS_MANAGER)
    public User selectUserByID(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}
