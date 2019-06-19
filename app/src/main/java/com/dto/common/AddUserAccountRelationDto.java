package com.dto.common;

import lombok.Data;

/**
 * @author leiwenxue
 * @version 1.0
 * @ClassName AddUserAccountRelationDto
 * @desc 添加用户帐单关系
 * @date 2019/5/5 下午2:50
 */
@Data
public class AddUserAccountRelationDto {
    /**
     * 用户Number
     */
    private long userNumber;
    /**
     * 帐单Number
     */
    private long accountNumber;
    /**
     * 帐单名称
     */
    private String accountName;
    /**
     * 权限
     */
    private int permission;
}
