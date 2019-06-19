package com.dto.response;

import lombok.Data;

/**
 * @author leiwenxue
 * @version 1.0
 * @ClassName StatisticsResponseDto
 * @desc StatisticsResponseDto
 * @date 2019/5/20 下午4:45
 */
@Data
public class StatisticsPercentageResponseDto {
    private Long speciesNumber;
    private String speciesName;
    /**
     * 百分比
     */
    private String percentage;
    private Long speciesTotalAmount;
}
