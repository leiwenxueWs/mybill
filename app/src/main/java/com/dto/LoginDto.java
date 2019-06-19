package com.dto;

import lombok.Data;

/**
 * @author leiwenxue
 * @version 1.0
 * @ClassName LoginDto
 * @desc LoginDto
 * @date 2019/2/21 上午11:34
 */
@Data
public class LoginDto {
    private Long userNumber;//用户number
    private String password;//密码
}
