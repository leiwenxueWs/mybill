package com.mapper.auto;

import com.model.auto.Object;
import com.model.auto.ObjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ObjectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill..object
     *
     * @mbg.generated Tue Apr 02 14:54:01 CST 2019
     */
    long countByExample(ObjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill..object
     *
     * @mbg.generated Tue Apr 02 14:54:01 CST 2019
     */
    int deleteByExample(ObjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill..object
     *
     * @mbg.generated Tue Apr 02 14:54:01 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill..object
     *
     * @mbg.generated Tue Apr 02 14:54:01 CST 2019
     */
    int insert(Object record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill..object
     *
     * @mbg.generated Tue Apr 02 14:54:01 CST 2019
     */
    int insertSelective(Object record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill..object
     *
     * @mbg.generated Tue Apr 02 14:54:01 CST 2019
     */
    List<Object> selectByExample(ObjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill..object
     *
     * @mbg.generated Tue Apr 02 14:54:01 CST 2019
     */
    Object selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill..object
     *
     * @mbg.generated Tue Apr 02 14:54:01 CST 2019
     */
    int updateByExampleSelective(@Param("record") Object record, @Param("example") ObjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill..object
     *
     * @mbg.generated Tue Apr 02 14:54:01 CST 2019
     */
    int updateByExample(@Param("record") Object record, @Param("example") ObjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill..object
     *
     * @mbg.generated Tue Apr 02 14:54:01 CST 2019
     */
    int updateByPrimaryKeySelective(Object record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table bill..object
     *
     * @mbg.generated Tue Apr 02 14:54:01 CST 2019
     */
    int updateByPrimaryKey(Object record);
}