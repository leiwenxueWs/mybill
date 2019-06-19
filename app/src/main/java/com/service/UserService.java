package com.service;

import com.dto.CreateUserDto;
import com.dto.LoginDto;
import com.dto.common.AddUserAccountRelationDto;

import java.util.List;

/**
 * @author leiwenxue
 * @version 1.0
 * @ClassName UserService
 * @desc UserService
 * @date 2019/2/21 上午10:56
 */
public interface UserService {
    /**
     * 判断用户名(userNumber)是否存在
     * @param userNumbers
     * @return
     */
    boolean isHadUserNumber(List<Long> userNumbers);

    /**
     * 验证登陆用户名密码是否正确
     * @param loginDto
     * @return
     */
    boolean verifyPassword(LoginDto loginDto);

    /**
     * 创建用户
     * @param createUserDto
     * @return
     */
    int createUser(CreateUserDto createUserDto);

    /**
     * 添加用户帐单关系
     * @param addUserAccountRelationDto
     * @return
     */
    int addUserAccountRelation(AddUserAccountRelationDto addUserAccountRelationDto);

    /**
     * 根据帐单删除用户帐单关系
     * @param accountNumber
     * @return
     */
    int deleteUserAccountRelation(long accountNumber);
}
