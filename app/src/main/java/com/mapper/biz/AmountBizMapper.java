package com.mapper.biz;

import com.dto.common.SpeciesTotalAmountDto;
import com.dto.request.StatisticsPercentageRequestDto;
import com.model.auto.Amount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author leiwenxue
 * @version 1.0
 * @ClassName AmountBizMapper
 * @desc AmountBizMapper
 * @date 2019/4/24 下午12:32
 */
public interface AmountBizMapper {
    /**
     * 根据帐单number获取记录的金额数据
     *
     * @param accountNumber
     * @return
     */
    List<Amount> selectAmountByAccountNumber(@Param("accountNumber") long accountNumber,@Param("type") Integer type);

    /**
     * 逻辑删除记录
     * @param speciesNumber
     * @return
     */
    int deleteAmountBySpecies(@Param("speciesNumber") long speciesNumber);

    /**
     * 查询类别金额总数
     * @param request
     * @return
     */
    List<SpeciesTotalAmountDto> selectSpeciesTotalAmount(@Param("item")StatisticsPercentageRequestDto request);

    /**
     * 查询金额总数
     * @param request
     * @return
     */
    Long selectTotalAmount(@Param("item")StatisticsPercentageRequestDto request);
}
