package com.service.impl;

import com.dao.StatisticsDao;
import com.dto.common.SpeciesTotalAmountDto;
import com.dto.request.StatisticsPercentageRequestDto;
import com.dto.response.StatisticsPercentageResponseDto;
import com.google.common.collect.Lists;
import com.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author leiwenxue
 * @version 1.0
 * @ClassName StatisticsServicesImpl
 * @desc StatisticsServicesImpl
 * @date 2019/5/21 上午10:35
 */
@Service
public class StatisticsServicesImpl implements StatisticsService {
    @Autowired
    private StatisticsDao statisticsDao;

    @Override
    public List<StatisticsPercentageResponseDto> StatisticsPercentageAmount(StatisticsPercentageRequestDto request) {
        Long total = statisticsDao.selectTotalAmount(request);
        List<SpeciesTotalAmountDto> speciesTotalAmountDtoList = statisticsDao.selectSpeciesTotalAmount(request).stream().sorted(Comparator.comparing(SpeciesTotalAmountDto::getSpeciesTotalAmount).reversed()).collect(Collectors.toList());
        List<StatisticsPercentageResponseDto> response = Lists.newArrayList();
        speciesTotalAmountDtoList.forEach(a -> {
            StatisticsPercentageResponseDto result = new StatisticsPercentageResponseDto();
            result.setSpeciesNumber(a.getSpeciesNumber());
            result.setSpeciesName(a.getSpeciesName());
            String percent = String.format("%.2f",(double)a.getSpeciesTotalAmount() * 100 /total)+"%";
            result.setPercentage(percent);
            result.setSpeciesTotalAmount(a.getSpeciesTotalAmount());
            response.add(result);
        });
        return response;
    }

    public static void main(String[] args) {
        Long a = 10L;
        Long b = 3L;
        String c = String.format("%.2f",(double)b*100/a)+"%";
        System.out.println(c);
    }
}
