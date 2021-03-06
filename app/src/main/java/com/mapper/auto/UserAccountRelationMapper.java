package com.mapper.auto;

import com.model.auto.UserAccountRelation;
import com.model.auto.UserAccountRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAccountRelationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill..user_account_relation
     *
     * @mbg.generated Sat Apr 20 12:00:30 CST 2019
     */
    long countByExample(UserAccountRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill..user_account_relation
     *
     * @mbg.generated Sat Apr 20 12:00:30 CST 2019
     */
    int deleteByExample(UserAccountRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill..user_account_relation
     *
     * @mbg.generated Sat Apr 20 12:00:30 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill..user_account_relation
     *
     * @mbg.generated Sat Apr 20 12:00:30 CST 2019
     */
    int insert(UserAccountRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill..user_account_relation
     *
     * @mbg.generated Sat Apr 20 12:00:30 CST 2019
     */
    int insertSelective(UserAccountRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill..user_account_relation
     *
     * @mbg.generated Sat Apr 20 12:00:30 CST 2019
     */
    List<UserAccountRelation> selectByExample(UserAccountRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill..user_account_relation
     *
     * @mbg.generated Sat Apr 20 12:00:30 CST 2019
     */
    UserAccountRelation selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill..user_account_relation
     *
     * @mbg.generated Sat Apr 20 12:00:30 CST 2019
     */
    int updateByExampleSelective(@Param("record") UserAccountRelation record, @Param("example") UserAccountRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill..user_account_relation
     *
     * @mbg.generated Sat Apr 20 12:00:30 CST 2019
     */
    int updateByExample(@Param("record") UserAccountRelation record, @Param("example") UserAccountRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill..user_account_relation
     *
     * @mbg.generated Sat Apr 20 12:00:30 CST 2019
     */
    int updateByPrimaryKeySelective(UserAccountRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill..user_account_relation
     *
     * @mbg.generated Sat Apr 20 12:00:30 CST 2019
     */
    int updateByPrimaryKey(UserAccountRelation record);
}