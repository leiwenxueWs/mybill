package com.service;

import com.dto.request.StatisticsPercentageRequestDto;
import com.dto.response.StatisticsPercentageResponseDto;

import java.util.List;

/**
 * @author leiwenxue
 * @version 1.0
 * @ClassName StatisticsServices
 * @desc StatisticsServices
 * @date 2019/5/21 上午10:28
 */
public interface StatisticsService {
    /**
     * 获取记录百分比
     * @param request
     * @return
     */
    List<StatisticsPercentageResponseDto> StatisticsPercentageAmount(StatisticsPercentageRequestDto request);
}
