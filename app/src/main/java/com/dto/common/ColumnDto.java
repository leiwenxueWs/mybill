package com.dto.common;

import lombok.Data;

import java.util.Date;

/**
 * @author leiwenxue
 * @version 1.0
 * @ClassName ColumnDto
 * @desc ColumnDto
 * @date 2019/4/2 下午3:03
 */
@Data
public class ColumnDto {
    private Integer id;

    private Long columnNumber;

    private String columnName;

    private Long objectNumber;

    private Integer columnType;

    private String key;

    private Date createTime;

    private Date updateTime;

    private Boolean isdel;
}
