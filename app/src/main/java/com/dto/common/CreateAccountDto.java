package com.dto.common;

import lombok.Data;

/**
 * @author leiwenxue
 * @version 1.0
 * @ClassName CreateAccountDto
 * @desc 创建帐单dto
 * @date 2019/4/20 上午11:31
 */
@Data
public class CreateAccountDto {
    private long accountNumber;
    private String accountName;
    private int type;
    private long creator;
}
