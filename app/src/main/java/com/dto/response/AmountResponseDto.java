package com.dto.response;

import lombok.Data;

/**
 * @author leiwenxue
 * @version 1.0
 * @ClassName AmountResponseDto
 * @desc AmountResponseDto
 * @date 2019/4/22 下午3:42
 */
@Data
public class AmountResponseDto {
    int id;
    /**
     * 帐单Number
     */
    private long accountNumber;
    /**
     * 类别Number
     */
    private long speciesNumber;
    /**
     * 类别名称
     */
    private String speciesName;
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
     * 记录类型
     */
    private Integer type;

}
