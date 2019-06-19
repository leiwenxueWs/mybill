package com.controller.statistice;

import com.dto.request.StatisticsPercentageRequestDto;
import com.dto.response.StatisticsPercentageResponseDto;
import com.service.StatisticsService;
import com.util.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author leiwenxue
 * @version 1.0
 * @ClassName StatisticsController
 * @desc StatisticsController
 * @date 2019/5/20 下午3:40
 */
@RestController
@RequestMapping("/statistics")
public class StatisticsController {
    @Autowired
    private StatisticsService statisticsService;

    @PostMapping("/bill")
    public RestResponse<List<StatisticsPercentageResponseDto>> getExportStatisticsInfo(@RequestBody StatisticsPercentageRequestDto request){
        return RestResponse.success(statisticsService.StatisticsPercentageAmount(request));
    }

}
