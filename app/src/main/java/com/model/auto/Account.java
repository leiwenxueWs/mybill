package com.model.auto;

import java.util.Date;

public class Account {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill..account.id
     *
     * @mbg.generated Sat Apr 20 12:39:46 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill..account.account_number
     *
     * @mbg.generated Sat Apr 20 12:39:46 CST 2019
     */
    private Long accountNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill..account.account_name
     *
     * @mbg.generated Sat Apr 20 12:39:46 CST 2019
     */
    private String accountName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill..account.type
     *
     * @mbg.generated Sat Apr 20 12:39:46 CST 2019
     */
    private Integer type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill..account.creator
     *
     * @mbg.generated Sat Apr 20 12:39:46 CST 2019
     */
    private Long creator;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill..account.create_time
     *
     * @mbg.generated Sat Apr 20 12:39:46 CST 2019
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill..account.update_time
     *
     * @mbg.generated Sat Apr 20 12:39:46 CST 2019
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bill..account.isdel
     *
     * @mbg.generated Sat Apr 20 12:39:46 CST 2019
     */
    private Boolean isdel;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill..account.id
     *
     * @return the value of bill..account.id
     *
     * @mbg.generated Sat Apr 20 12:39:46 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill..account.id
     *
     * @param id the value for bill..account.id
     *
     * @mbg.generated Sat Apr 20 12:39:46 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill..account.account_number
     *
     * @return the value of bill..account.account_number
     *
     * @mbg.generated Sat Apr 20 12:39:46 CST 2019
     */
    public Long getAccountNumber() {
        return accountNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill..account.account_number
     *
     * @param accountNumber the value for bill..account.account_number
     *
     * @mbg.generated Sat Apr 20 12:39:46 CST 2019
     */
    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill..account.account_name
     *
     * @return the value of bill..account.account_name
     *
     * @mbg.generated Sat Apr 20 12:39:46 CST 2019
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill..account.account_name
     *
     * @param accountName the value for bill..account.account_name
     *
     * @mbg.generated Sat Apr 20 12:39:46 CST 2019
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill..account.type
     *
     * @return the value of bill..account.type
     *
     * @mbg.generated Sat Apr 20 12:39:46 CST 2019
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill..account.type
     *
     * @param type the value for bill..account.type
     *
     * @mbg.generated Sat Apr 20 12:39:46 CST 2019
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill..account.creator
     *
     * @return the value of bill..account.creator
     *
     * @mbg.generated Sat Apr 20 12:39:46 CST 2019
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill..account.creator
     *
     * @param creator the value for bill..account.creator
     *
     * @mbg.generated Sat Apr 20 12:39:46 CST 2019
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill..account.create_time
     *
     * @return the value of bill..account.create_time
     *
     * @mbg.generated Sat Apr 20 12:39:46 CST 2019
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill..account.create_time
     *
     * @param createTime the value for bill..account.create_time
     *
     * @mbg.generated Sat Apr 20 12:39:46 CST 2019
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill..account.update_time
     *
     * @return the value of bill..account.update_time
     *
     * @mbg.generated Sat Apr 20 12:39:46 CST 2019
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill..account.update_time
     *
     * @param updateTime the value for bill..account.update_time
     *
     * @mbg.generated Sat Apr 20 12:39:46 CST 2019
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bill..account.isdel
     *
     * @return the value of bill..account.isdel
     *
     * @mbg.generated Sat Apr 20 12:39:46 CST 2019
     */
    public Boolean getIsdel() {
        return isdel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bill..account.isdel
     *
     * @param isdel the value for bill..account.isdel
     *
     * @mbg.generated Sat Apr 20 12:39:46 CST 2019
     */
    public void setIsdel(Boolean isdel) {
        this.isdel = isdel;
    }
}