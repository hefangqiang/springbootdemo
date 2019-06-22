package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description： 异常controller
 * @author： Mr.He
 * @date： 2019-06-18 21:09
 **/
@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping("/nullPointer")
    @ResponseBody
    public Object nullPointerException(){
        User user = null;
        Integer id = user.getId();
        return ""+id;
    }

    @RequestMapping("/404.do")
    public Object page_404(){
        return "404page";
    }

}
