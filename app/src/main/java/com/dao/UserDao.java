package com.dao;

import com.google.common.collect.Lists;
import com.mapper.auto.UserAccountRelationMapper;
import com.mapper.auto.UserMapper;
import com.model.auto.User;
import com.model.auto.UserAccountRelation;
import com.model.auto.UserAccountRelationExample;
import com.model.auto.UserExample;
import com.model.auto.UserExample.Criteria;
import com.util.SnowFlakeIDGenerator;
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

    @Autowired
    private UserAccountRelationMapper userAccountRelationMapper;

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

    /**
     * 添加用户
     * @param user
     * @return
     */
    public int insertUser(User user){
        return userMapper.insertSelective(user);
    }

    /**
     * 添加用户账户关系
     * @param userAccountRelation
     * @return
     */
    public int insertUserAccountRelation(UserAccountRelation userAccountRelation){
        if(userAccountRelation==null){
            return 0;
        }
        return userAccountRelationMapper.insertSelective(userAccountRelation);
    }

    public int deleteUserAccountRelationByAccountNumber(long accountNumber){
        if(accountNumber == 0){
            return 0;
        }
        UserAccountRelation userAccountRelation = new UserAccountRelation();
        userAccountRelation.setIsdel(true);
        UserAccountRelationExample example = new UserAccountRelationExample();
        UserAccountRelationExample.Criteria criteria = example.createCriteria();
        criteria.andAccountNumberEqualTo(accountNumber);
        return userAccountRelationMapper.updateByExampleSelective(userAccountRelation,example);
    }

//    public int insertUser(User user){
//        if(user == null){
//            return 0;
//        }
//        return userMapper.insertSelective(user);
//    }

}
