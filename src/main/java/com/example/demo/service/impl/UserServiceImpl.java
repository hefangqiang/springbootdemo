package com.example.demo.service.impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import com.example.demo.config.RedisConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    public List<User> findAllUser() {
        return userMapper.selectAllUser();
    }

    @Override
    public void createUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public void modifyUser(User user) {
        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void deleteUser(int id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Cacheable( value ="user",key = "'id:' +#id",cacheManager = RedisConfig.CacheManagerName.REDIS_MANAGER)
    public User selectUserByID(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}
