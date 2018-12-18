package com.controller.login;

import com.dto.User;
import com.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/user")
    public User get(Long number){
        User user = null;
        if(number!=null){
            user = userMapper.selectUserByNumber(number);
        }

        return user;
    }
}
