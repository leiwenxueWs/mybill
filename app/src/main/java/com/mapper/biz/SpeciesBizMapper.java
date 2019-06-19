package com.mapper.biz;


import com.model.auto.Species;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author leiwenxue
 * @version 1.0
 * @ClassName SpeciesBizMapper
 * @desc SpeciesBizMapper
 * @date 2019/4/17 上午9:37
 */
public interface SpeciesBizMapper {
    /**
     * 根据帐单Number
     * @param accountNumber
     * @param type
     * @return
     */
    List<Species> getSpeciesByAccountNumberAndType(@Param("accountNumber") long accountNumber, @Param("type") int type);

    /**
     * 获取已删除的系统类别
     * @param accountNumber
     * @param type
     * @return
     */
    List<Species> selectDelSystemSpecies(@Param("accountNumber") long accountNumber, @Param("type") int type);

    /**
     * 批量插入Species
     * @param speciesList
     * @return
     */
    int batchInsertSpecies(@Param("items") List<Species> speciesList);

    /**
     * 逻辑删除类别
     * @param speciesNumber
     * @return
     */
    int deleteSpecies(@Param("speciesNumber") Long speciesNumber);
}
