package com.dto.request;

import lombok.Data;

/**
 * @author leiwenxue
 * @version 1.0
 * @ClassName AddMemberRequest
 * @desc TODO
 * @date 2019/5/9 下午3:29
 */
@Data
public class AddMemberRequest {
    private Long accountNumber;
    private String accountName;
    private Long userNumber;
    private int permission;
}
