package com.dao;

import com.dto.CreateUserDto;
import com.google.common.collect.Lists;
import com.mapper.auto.UserMapper;
import com.model.auto.User;
import com.model.auto.UserExample;
import com.model.auto.UserExample.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author leiwenxue
 * @version 1.0
 * @ClassName UserDao
 * @desc TODO
 * @date 2019/2/21 上午10:42
 */
@Component
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据userNumber查询User信息
     * @param userNumbers
     * @return
     */
    public List<User> selectUserByUserNumber(List<Long> userNumbers){
        if(userNumbers.isEmpty()){
            return Lists.newArrayList();
        }
        UserExample example = new UserExample();
        Criteria criteria = example.createCriteria();
        criteria.andUserNumberIn(userNumbers);
        return userMapper.selectByExample(example);
    }

    public int insertUser(User user){
        return userMapper.insertSelective(user);
    }

}
