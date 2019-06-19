package com.dto.response;

import lombok.Data;

/**
 * @author leiwenxue
 * @version 1.0
 * @ClassName AccountResponseDto
 * @desc AccountResponseDto
 * @date 2019/4/24 下午2:18
 */
@Data
public class AccountResponseDto {
    private long accountNumber;
    private String accountName;
    private int type;
    /**
     * 权限
     */
    int permission;
}
