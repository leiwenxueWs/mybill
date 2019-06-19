package com.service;

import com.dto.common.CreateAccountDto;
import com.dto.request.AddAmountRequestDto;
import com.dto.request.AddSpeciesRequestDto;
import com.dto.response.AccountResponseDto;
import com.dto.response.AmountResponseDto;
import com.model.auto.Species;

import java.util.List;

/**
 * @author leiwenxue
 * @version 1.0
 * @ClassName BillService
 * @desc BillService
 * @date 2019/4/17 上午9:32
 */
public interface BillService {

    /**
     * 添加金额信息
     *
     * @param addAmountRequestDto
     * @return
     */
    int addAmount(AddAmountRequestDto addAmountRequestDto);

    /**
     * 根据帐单Number获取记录数据
     * @param accountNumber
     * @param type 记录类型
     * @return
     */
    List<AmountResponseDto> getAmount(long accountNumber,Integer type);

    /**
     * 根据ID获取金额数据
     * @param id
     * @return
     */
    AmountResponseDto getAmountById(int id);

    int deleteAmountById(int id);


    /**
     * 创建帐单
     *
     * @param createAccountDto
     * @return
     */
    void createAccount(CreateAccountDto createAccountDto);

    /**
     *
     * @param accountNumber
     */
    boolean deleteAccount(long accountNumber);

    /**
     * 是否存在相同名称的帐单,用户账号下的订单名称不能重复
     *
     * @param createAccountDto
     * @return
     */
    boolean isHadSameNameAccount(CreateAccountDto createAccountDto);

    /**
     * 获得记账字段种类
     *
     * @param accountNumber
     * @param type
     * @return
     */
    List<Species> getSpecies(long accountNumber, int type);

    /**
     * 已删除的系统类别
     * @param accountNumber
     * @param type
     * @return
     */
    List<Species> getDelSystemSpecies(long accountNumber, int type);

    /**
     * 删除类别
     * @param speciesNumber
     * @return
     */
    boolean deleteSpecies(Long speciesNumber);

    /**
     * 添加系统类别
     * @param speciesNumber
     * @return
     */
    boolean addSystemSpecies(Long speciesNumber);
    /**
     * 种类是否已经存在
     *
     * @param addSpeciesRequestDto
     * @return
     */
    boolean isHadSameSpecies(AddSpeciesRequestDto addSpeciesRequestDto);

    /**
     * 添加记录种类
     * @param addSpeciesRequestDto
     * @return
     */
    int addSpecies(AddSpeciesRequestDto addSpeciesRequestDto);

    /**
     * 获取用户包含的帐单
     * @param userNumber
     * @return
     */
    List<AccountResponseDto> getAccountByUserNumber(long userNumber);


}
