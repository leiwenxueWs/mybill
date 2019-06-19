package com.dto.request;

import lombok.Data;

/**
 * @author leiwenxue
 * @version 1.0
 * @ClassName StatisticsPercentageRequestDto
 * @desc StatisticsPercentageRequestDto
 * @date 2019/5/20 下午5:29
 */
@Data
public class StatisticsPercentageRequestDto {
    private Long accountNumber;
    private Integer amountType;
    private Long startTime;
    private Long endTime;
}
