package com.dto.common;

import lombok.Data;

/**
 * @author leiwenxue
 * @version 1.0
 * @ClassName TotalAmountDto
 * @desc 统计总金额
 * @date 2019/5/21 上午10:45
 */
@Data
public class SpeciesTotalAmountDto {
    private Long speciesTotalAmount;
    private Long speciesNumber;
    private String speciesName;
}
