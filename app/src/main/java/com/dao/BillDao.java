package com.dao;

import com.dto.common.CreateAccountDto;
import com.google.common.collect.Lists;
import com.mapper.auto.AccountMapper;
import com.mapper.auto.AmountMapper;
import com.mapper.auto.SpeciesMapper;
import com.mapper.auto.UserAccountRelationMapper;
import com.mapper.biz.AmountBizMapper;
import com.mapper.biz.SpeciesBizMapper;
import com.model.auto.Account;
import com.model.auto.AccountExample;
import com.model.auto.Amount;
import com.model.auto.AmountExample;
import com.model.auto.Species;
import com.model.auto.SpeciesExample;
import com.model.auto.UserAccountRelation;
import com.model.auto.UserAccountRelationExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author leiwenxue
 * @version 1.0
 * @ClassName BillDao
 * @desc BillDao
 * @date 2019/4/17 上午9:35
 */
@Component
public class BillDao {
    @Autowired
    private SpeciesMapper speciesMapper;

    @Autowired
    private SpeciesBizMapper speciesBizMapper;

    @Autowired
    private UserAccountRelationMapper userAccountRelationMapper;

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private AmountMapper amountMapper;

    @Autowired
    private AmountBizMapper amountBizMapper;

    /**
     * 根据帐单number获取帐单信息
     * @param accountNumbers
     * @return
     */
    public List<Account> selectAccountByNumbers(List<Long> accountNumbers) {
        if (accountNumbers.isEmpty()) {
            return Lists.newArrayList();
        }
        AccountExample example = new AccountExample();
        AccountExample.Criteria criteria = example.createCriteria();
        criteria.andAccountNumberIn(accountNumbers);
        criteria.andIsdelEqualTo(false);
        return accountMapper.selectByExample(example);
    }

    /**
     * 根据帐单number逻辑删除帐单
     * @param accountNumber
     * @return
     */
    public int deleteAccount(long accountNumber){
        if(accountNumber == 0){
            return 0;
        }
        Account account = new Account();
        account.setIsdel(true);
        AccountExample example = new AccountExample();
        AccountExample.Criteria criteria = example.createCriteria();
        criteria.andAccountNumberEqualTo(accountNumber);
        return accountMapper.updateByExampleSelective(account,example);
    }

    /**
     * 根据帐单number逻辑删除类别
     * @param accountNumber
     * @return
     */
    public int deleteSpeciesByAccountNumber(long accountNumber){
        if(accountNumber == 0){
            return 0;
        }
        Species species = new Species();
        species.setIsdel(true);
        SpeciesExample example = new SpeciesExample();
        SpeciesExample.Criteria criteria = example.createCriteria();
        criteria.andAccountNumberEqualTo(accountNumber);
        return speciesMapper.updateByExampleSelective(species,example);
    }

    /**
     * 根据帐单number逻辑删除记录
     * @param accountNumber
     * @return
     */
    public int deleteAmountByAccountNumber(long accountNumber){
        if(accountNumber == 0){
            return 0;
        }
        Amount amount = new Amount();
        amount.setIsdel(true);
        AmountExample example = new AmountExample();
        AmountExample.Criteria criteria = example.createCriteria();
        criteria.andAccountNumberEqualTo(accountNumber);
        return amountMapper.updateByExampleSelective(amount,example);
    }

    /**
     * 获取帐单的记录
     *
     * @param accountNumber
     * @return
     */
    public List<Amount> getAmount(long accountNumber, Integer type) {
        return amountBizMapper.selectAmountByAccountNumber(accountNumber, type);
    }

    /**
     * 根据Id获取记录
     * @param id
     * @return
     */
    public Amount getAmountById(int id){
        if(id == 0){
            return null;
        }
        return amountMapper.selectByPrimaryKey(id);
    }

    public int deleteAmountById(int id){
        if(id == 0){
            return 0;
        }
        Amount amount = new Amount();
        amount.setIsdel(true);
        AmountExample example = new AmountExample();
        AmountExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        return amountMapper.updateByExampleSelective(amount,example);
    }

    /**
     * 添加金额记录
     *
     * @param amount
     * @return
     */
    public int insertAmount(Amount amount) {
        if (amount == null) {
            return 0;
        }
        return amountMapper.insertSelective(amount);
    }

    /**
     * 添加类别
     *
     * @param species
     * @return
     */
    public int insertSpecies(Species species) {
        if (species == null) {
            return 0;
        }
        return speciesMapper.insertSelective(species);
    }

    /**
     * 批量插入Species
     *
     * @param speciesList
     * @return
     */
    public int batchInsertSpecies(List<Species> speciesList) {
        if (speciesList.isEmpty()) {
            return 0;
        }
        return speciesBizMapper.batchInsertSpecies(speciesList);
    }


    /**
     * 根据帐单number、Species名称、type查询Species
     *
     * @param accountNumber
     * @param speciesName
     * @param speciesType
     * @return
     */
    public List<Species> selectSpeciesByAccountAndSpeciesNameAndType(long accountNumber, String speciesName, int speciesType) {
        SpeciesExample example = new SpeciesExample();
        SpeciesExample.Criteria criteria = example.createCriteria();
        criteria.andAccountNumberEqualTo(accountNumber);
        criteria.andSpeciesNameEqualTo(speciesName);
        criteria.andSpeciesTypeEqualTo(speciesType);
        return speciesMapper.selectByExample(example);
    }


    /**
     * 添加帐单
     *
     * @param createAccountDto
     * @return
     */
    public int addAccount(CreateAccountDto createAccountDto) {
        if (createAccountDto == null) {
            return 0;
        }
        if (isHadSameNameAccount(createAccountDto)) {
            return 0;
        }
        Account account = new Account();
        account.setAccountName(createAccountDto.getAccountName());
        account.setType(createAccountDto.getType());
        account.setCreator(createAccountDto.getCreator());
        account.setAccountNumber(createAccountDto.getAccountNumber());
        return accountMapper.insertSelective(account);
    }

    /**
     * 判断是否含有相同名称的订单
     *
     * @param createAccountDto
     * @return
     */
    public boolean isHadSameNameAccount(CreateAccountDto createAccountDto) {
        UserAccountRelationExample example = new UserAccountRelationExample();
        UserAccountRelationExample.Criteria criteria = example.createCriteria();
        criteria.andAccountNameEqualTo(createAccountDto.getAccountName());
        criteria.andUserNumberEqualTo(createAccountDto.getCreator());
        criteria.andIsdelEqualTo(false);
        List<UserAccountRelation> list = userAccountRelationMapper.selectByExample(example);
        return list.size() > 0 ? true : false;
    }

    public List<UserAccountRelation> selectUserAccountRelationByUserNumber(long userNumber) {
        UserAccountRelationExample example = new UserAccountRelationExample();
        UserAccountRelationExample.Criteria criteria = example.createCriteria();
        criteria.andUserNumberEqualTo(userNumber);
        criteria.andIsdelEqualTo(false);
        return userAccountRelationMapper.selectByExample(example);
    }

    /**
     * 获取Species，根据帐单number与类别种类
     *
     * @param accountNumber
     * @param type
     * @return
     */
    public List<Species> getSpecies(long accountNumber, int type) {
        return speciesBizMapper.getSpeciesByAccountNumberAndType(accountNumber, type);
    }

    public List<Species> getDelSystemSpecies(long accountNumber, int type) {
        return speciesBizMapper.selectDelSystemSpecies(accountNumber, type);
    }

    public List<Species> getSpeciesBySpeciesNumbers(List<Long> speciesNumberList) {
        if (speciesNumberList.isEmpty()) {
            return Lists.newArrayList();
        }
        SpeciesExample example = new SpeciesExample();
        SpeciesExample.Criteria criteria = example.createCriteria();
        criteria.andSpeciesNumberIn(speciesNumberList);
        return speciesMapper.selectByExample(example);
    }

    /**
     * 删除类别
     *
     * @param speciesNumber
     * @return
     */
    public int deleteSpecies(Long speciesNumber) {
        if (speciesNumber == null || speciesNumber.equals(0L)) {
            return 0;
        }
        return speciesBizMapper.deleteSpecies(speciesNumber);
    }

    /**
     * 通过类别number删除记录
     *
     * @param speciesNumber
     * @return
     */
    public int deleteAmountBySpeciesNumber(Long speciesNumber) {
        if (speciesNumber == null || speciesNumber.equals(0L)) {
            return 0;
        }
        return amountBizMapper.deleteAmountBySpecies(speciesNumber);
    }

    /**
     * 添加系统类别
     * @param speciesNumber
     * @return
     */
    public int addSystemSpecies(Long speciesNumber) {
        if (speciesNumber == null) {
            return 0;
        }
        Species species = new Species();
        species.setIsdel(false);
        SpeciesExample example = new SpeciesExample();
        SpeciesExample.Criteria criteria = example.createCriteria();
        criteria.andSpeciesNumberEqualTo(speciesNumber);
        return speciesMapper.updateByExampleSelective(species, example);
    }

}
