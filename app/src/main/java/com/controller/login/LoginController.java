package com.controller.login;

import com.google.common.collect.Lists;
import com.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/isHadUserNumber")
    public boolean isHadUserNumber(@Param("userNumber") long userNumber){
        return userService.isHadUserNumber(Lists.newArrayList(userNumber));
    }

}
