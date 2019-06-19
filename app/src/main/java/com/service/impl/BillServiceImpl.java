package com.service.impl;

import com.dao.BillDao;
import com.dto.common.AddUserAccountRelationDto;
import com.dto.common.CreateAccountDto;
import com.dto.request.AddAmountRequestDto;
import com.dto.request.AddSpeciesRequestDto;
import com.dto.response.AccountResponseDto;
import com.dto.response.AmountResponseDto;
import com.google.common.collect.Lists;
import com.model.auto.Account;
import com.model.auto.Amount;
import com.model.auto.Species;
import com.model.auto.UserAccountRelation;
import com.service.BillService;
import com.service.UserService;
import com.util.SnowFlakeIDGenerator;
import com.util.SystemSpeciesList;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

/**
 * @author leiwenxue
 * @version 1.0
 * @ClassName BillServiceImpl
 * @desc BillServiceImpl
 * @date 2019/4/17 上午9:32
 */
@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillDao billDao;

    @Autowired
    private UserService userService;

    @Override
    public List<AccountResponseDto> getAccountByUserNumber(long userNumber) {
        List<UserAccountRelation> userAccountRelations = billDao.selectUserAccountRelationByUserNumber(userNumber);
        List<AccountResponseDto> accountResponseDtoList = userAccountRelations.stream().map(a -> {
            AccountResponseDto accountResponseDto = new AccountResponseDto();
            accountResponseDto.setAccountNumber(a.getAccountNumber());
            accountResponseDto.setAccountName(a.getAccountName());
            accountResponseDto.setPermission(a.getPermission());
            return accountResponseDto;
        }).collect(toList());
        /**
         * 装填账单类型
         */
        List<Long> accountNumbers = userAccountRelations.stream().map(UserAccountRelation::getAccountNumber).collect(toList());
        List<Account> accountList = billDao.selectAccountByNumbers(accountNumbers);
        Map<Long,Integer> accountTypeMap = accountList.stream().collect(toMap(Account::getAccountNumber, Account::getType));
        accountResponseDtoList.forEach(a -> {
            a.setType(accountTypeMap.get(a.getAccountNumber()));
        });
        return accountResponseDtoList;
    }

    @Override
    public List<AmountResponseDto> getAmount(long accountNumber,Integer type) {
        List<Amount> amountList =  billDao.getAmount(accountNumber,type);
        List<Long> specieNumberList = amountList.stream().map(Amount::getSpeciesNumber).distinct().collect(toList());
        Map<Long,String> speciesNameMap = billDao.getSpeciesBySpeciesNumbers(specieNumberList).stream().collect(toMap(Species::getSpeciesNumber,Species::getSpeciesName));
        return amountList.stream().map(a -> {
            AmountResponseDto amountResponseDto = new AmountResponseDto();
            BeanUtils.copyProperties(a,amountResponseDto);
            amountResponseDto.setSpeciesName(speciesNameMap.get(amountResponseDto.getSpeciesNumber()));
            return amountResponseDto;
        }).collect(toList());
    }

    @Override
    public AmountResponseDto getAmountById(int id) {
        Amount amount = billDao.getAmountById(id);
        if(amount == null){
            return new AmountResponseDto();
        }
        AmountResponseDto amountResponseDto = new AmountResponseDto();
        BeanUtils.copyProperties(amount,amountResponseDto);
        Map<Long,String> speciesNameMap = billDao.getSpeciesBySpeciesNumbers(Lists.newArrayList(amount.getSpeciesNumber())).stream().collect(toMap(Species::getSpeciesNumber,Species::getSpeciesName));
        amountResponseDto.setSpeciesName(speciesNameMap.get(amount.getSpeciesNumber()));
        return amountResponseDto;
    }

    @Override
    public int deleteAmountById(int id) {
        return billDao.deleteAmountById(id);
    }

    @Override
    public int addAmount(AddAmountRequestDto addAmountRequestDto) {
        Amount amount = new Amount();
        BeanUtils.copyProperties(addAmountRequestDto,amount);
        return billDao.insertAmount(amount);
    }

    @Override
    public boolean isHadSameSpecies(AddSpeciesRequestDto addSpeciesRequestDto) {
        List<Species> speciesList = billDao.selectSpeciesByAccountAndSpeciesNameAndType(
                addSpeciesRequestDto.getAccountNumber(),
                addSpeciesRequestDto.getSpeciesName(),
                addSpeciesRequestDto.getSpeciesType());
        return speciesList.size() > 0;
    }

    @Override
    public int addSpecies(AddSpeciesRequestDto addSpeciesRequestDto) {
//        if(isHadSameSpecies(addSpeciesRequestDto)){
//            return 0;
//        }
        Species species = new Species();
        BeanUtils.copyProperties(addSpeciesRequestDto,species);
        species.setSpeciesNumber(SnowFlakeIDGenerator.nextNumber());
        return billDao.insertSpecies(species);
    }

    @Override
    public boolean isHadSameNameAccount(CreateAccountDto createAccountDto) {
        return billDao.isHadSameNameAccount(createAccountDto);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void createAccount(CreateAccountDto createAccountDto) {
        if (isHadSameNameAccount(createAccountDto)) {
            return;
        }
        //创建帐单
        long accountNumber = SnowFlakeIDGenerator.nextNumber();
        createAccountDto.setAccountNumber(accountNumber);
        billDao.addAccount(createAccountDto);
        //添加用户帐单关系
        AddUserAccountRelationDto addUserAccountRelationDto = new AddUserAccountRelationDto();
        addUserAccountRelationDto.setAccountNumber(accountNumber);
        addUserAccountRelationDto.setAccountName(createAccountDto.getAccountName());
        addUserAccountRelationDto.setUserNumber(createAccountDto.getCreator());
        addUserAccountRelationDto.setPermission(2);
        userService.addUserAccountRelation(addUserAccountRelationDto);
        //添加系统种类
        addSystemSpecies(accountNumber);

    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteAccount(long accountNumber) {
        //删除帐单
        billDao.deleteAccount(accountNumber);
        //删除用户帐单关系
        userService.deleteUserAccountRelation(accountNumber);
        //删除类别
        billDao.deleteSpeciesByAccountNumber(accountNumber);
        //删除记录
        billDao.deleteAmountByAccountNumber(accountNumber);
        return true;
    }

    /**
     * 添加系统种类
     *
     * @param accountNumber
     * @return
     */
    public int addSystemSpecies(long accountNumber) {
        List<Species> speciesList = Lists.newArrayList();
        String[] incomeNames = SystemSpeciesList.incomeNames;
        String[] spendingNames = SystemSpeciesList.spendingNames;
        for (String name : incomeNames) {
            Species species = new Species();
            species.setSpeciesNumber(SnowFlakeIDGenerator.nextNumber());
            species.setAccountNumber(accountNumber);
            species.setSpeciesName(name);
            species.setCreator(10000L);
            species.setSpeciesType(1);
            speciesList.add(species);
        }
        for (String name : spendingNames) {
            Species species = new Species();
            species.setSpeciesNumber(SnowFlakeIDGenerator.nextNumber());
            species.setAccountNumber(accountNumber);
            species.setSpeciesName(name);
            species.setCreator(10000L);
            species.setSpeciesType(0);
            speciesList.add(species);
        }
        return billDao.batchInsertSpecies(speciesList);
    }

    @Override
    public List<Species> getSpecies(long accountNumber, int type) {
        return billDao.getSpecies(accountNumber, type);
    }

    @Override
    public List<Species> getDelSystemSpecies(long accountNumber, int type) {
        return billDao.getDelSystemSpecies(accountNumber, type);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteSpecies(Long speciesNumber) {
        billDao.deleteSpecies(speciesNumber);
        billDao.deleteAmountBySpeciesNumber(speciesNumber);
        return true;
    }

    @Override
    public boolean addSystemSpecies(Long speciesNumber) {
        billDao.addSystemSpecies(speciesNumber);
        return true;
    }
}
