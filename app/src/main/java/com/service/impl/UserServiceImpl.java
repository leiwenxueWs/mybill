package com.service.impl;

import com.dao.UserDao;
import com.dto.CreateUserDto;
import com.dto.LoginDto;
import com.google.common.collect.Lists;
import com.model.auto.User;
import com.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

/**
 * @author leiwenxue
 * @version 1.0
 * @ClassName UserServiceImpl
 * @desc UserServiceImpl
 * @date 2019/2/21 上午10:57
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public boolean isHadUserNumber(List<Long> userNumbers) {
        List<User> userList = userDao.selectUserByUserNumber(userNumbers );
        return userList.size() > 0;
    }

    @Override
    public boolean verifyPassword(LoginDto loginDto) {
        List<Long> userNumbers = Lists.newArrayList(loginDto.getUserNumber());
        List<User> userList = userDao.selectUserByUserNumber(userNumbers);
        Map<Long,String> userNumberAndPasswordMap = userList.stream().collect(toMap(User::getUserNumber,User::getPassword));
        return userNumberAndPasswordMap.get(loginDto.getUserNumber()).equals(loginDto.getPassword());
    }

    @Override
    public int createUser(CreateUserDto createUserDto) {
        User user = new User();
        BeanUtils.copyProperties(createUserDto,user);
        if(isHadUserNumber(Lists.newArrayList(createUserDto.getUserNumber()))){
            return 0;
        }
        return userDao.insertUser(user);
    }
}
