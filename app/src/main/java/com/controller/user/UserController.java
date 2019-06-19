package com.controller.user;

import com.dto.CreateUserDto;
import com.dto.LoginDto;
import com.dto.common.AddUserAccountRelationDto;
import com.dto.request.AddMemberRequest;
import com.google.common.collect.Lists;
import com.service.UserService;
import com.util.RestResponse;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/isHadUserNumber", method = {RequestMethod.GET})
    public boolean isHadUserNumber(@Param("userNumber") long userNumber){
          return userService.isHadUserNumber(Lists.newArrayList(userNumber));
    }

    @RequestMapping(value = "/verifyPassword", method = {RequestMethod.POST})
    public boolean verifyPassword(@RequestBody LoginDto loginDto){
        return userService.verifyPassword(loginDto);
    }

    @RequestMapping(value = "/createUser", method = {RequestMethod.POST})
    public boolean createUser(@RequestBody CreateUserDto createUserDto){
        //判断账号是否存在
        if(!isHadUserNumber(createUserDto.getUserNumber())){
            return userService.createUser(createUserDto) > 0;
        }
        return false;

    }

    @PostMapping("/login")
    public boolean login(@RequestBody LoginDto loginDto){
        //判断账号是否存在
        if(isHadUserNumber(loginDto.getUserNumber())){
            return verifyPassword(loginDto);
        }
        return false;
    }

    @PostMapping("/addMember")
    public RestResponse<Integer> addMember(@RequestBody AddMemberRequest addMemberRequest){
        AddUserAccountRelationDto addUserAccountRelationDto = new AddUserAccountRelationDto();
        BeanUtils.copyProperties(addMemberRequest,addUserAccountRelationDto);
        return RestResponse.success(userService.addUserAccountRelation(addUserAccountRelationDto));
    }

}
