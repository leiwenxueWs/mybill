package com.dto.request;

import lombok.Data;

/**
 * @author leiwenxue
 * @version 1.0
 * @ClassName AddAmountRequestDto
 * @desc 添加记录金额请求
 * @date 2019/4/22 下午3:19
 */
@Data
public class AddAmountRequestDto {
    /**
     * 帐单Number
     */
    private long accountNumber;
    /**
     * 类别Number
     */
    private long speciesNumber;
    /**
     * 记录人
     */
    private long recorder;
    /**
     * 金额(分)
     */
    private long amount;
    /**
     * 记录时间ms
     */
    private long recordDate;
    /**
     * 记录类别
     */
    private int type;
}
