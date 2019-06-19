package com.dto.request;

import lombok.Data;

/**
 * @author leiwenxue
 * @version 1.0
 * @ClassName AddSpeciesRequestDto
 * @desc AddSpeciesRequestDto
 * @date 2019/4/19 下午1:20
 */
@Data
public class AddSpeciesRequestDto {
    /**
     * 名称
     */
    private String speciesName;
    /**
     * 类型(0:支出、1:收入)
     */
    private int speciesType;
    /**
     * 创建人Number
     */
    private long creator;
    /**
     * 帐单Number
     */
    private long accountNumber;
}
