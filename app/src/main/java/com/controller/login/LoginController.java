package com.controller.login;

import com.dto.CreateUserDto;
import com.dto.LoginDto;
import com.google.common.collect.Lists;
import com.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/isHadUserNumber", method = {RequestMethod.GET})
    public boolean isHadUserNumber(@Param("userNumber") long userNumber){
//        System.out.println(userNumber);
//        double p = Double.parseDouble(userNumber);
//        System.out.println(p);
//        System.out.println(p-1);
//        return true;
          return userService.isHadUserNumber(Lists.newArrayList(userNumber));
    }

    @RequestMapping(value = "/verifyPassword", method = {RequestMethod.POST})
    public boolean verifyPassword(@RequestBody LoginDto loginDto){
        return userService.verifyPassword(loginDto);
    }

    @RequestMapping(value = "/createUser", method = {RequestMethod.POST})
    public boolean createUser(@RequestBody CreateUserDto createUserDto){
        return userService.createUser(createUserDto) > 0;
    }
}
