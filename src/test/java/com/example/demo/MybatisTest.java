package com.example.demo;

import com.example.demo.dao.UserMapper;
import com.example.demo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @description： TODO
 * @author： Mr.He
 * @date： 2019-06-16 21:02
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = APP.class)
public class MybatisTest {

    @Resource
    private UserMapper UserMapper;

    @Test
    public void testSelect(){
        User User = UserMapper.selectByPrimaryKey(1);
        System.out.println("user=="+User.toString());
    }


}
