package com.dto;

import lombok.Data;

/**
 * @author leiwenxue
 * @version 1.0
 * @ClassName CreateUserDto
 * @desc TODO
 * @date 2019/2/21 下午4:15
 */
@Data
public class CreateUserDto {
    private Long userNumber;
    private String password;
    private String nickname;
}
