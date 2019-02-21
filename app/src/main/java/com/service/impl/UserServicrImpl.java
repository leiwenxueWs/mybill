package com.service.impl;

import com.dao.UserDao;
import com.model.auto.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author leiwenxue
 * @version 1.0
 * @ClassName UserServicrImpl
 * @desc TODO
 * @date 2019/2/21 上午10:57
 */
@Service
public class UserServicrImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public boolean isHadUserNumber(List<Long> userNumber) {
        List<User> userList = userDao.selectUserByUserNumber(userNumber);
        return userList.size() > 0;
    }
}
