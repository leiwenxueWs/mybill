package com.dao;

import com.dto.common.SpeciesTotalAmountDto;
import com.dto.request.StatisticsPercentageRequestDto;
import com.google.common.collect.Lists;
import com.mapper.biz.AmountBizMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author leiwenxue
 * @version 1.0
 * @ClassName StatisticsDao
 * @desc StatisticsDao
 * @date 2019/5/21 上午10:39
 */
@Component
public class StatisticsDao {
    @Autowired
    private AmountBizMapper amountBizMapper;

    /**
     * 获取类别维度 记录金额总和
     * @param request
     * @return
     */
    public List<SpeciesTotalAmountDto> selectSpeciesTotalAmount(StatisticsPercentageRequestDto request){
        if(request == null){
            return Lists.newArrayList();
        }
        return amountBizMapper.selectSpeciesTotalAmount(request);
    }

    /**
     * 获取记录金额总和
     * @param request
     * @return
     */
    public Long selectTotalAmount(StatisticsPercentageRequestDto request){
        if(request == null){
            return 0L;
        }
        return amountBizMapper.selectTotalAmount(request);
    }
}
