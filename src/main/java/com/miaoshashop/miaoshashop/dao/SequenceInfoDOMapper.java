package com.miaoshashop.miaoshashop.dao;

import com.miaoshashop.miaoshashop.dataobject.SequenceInfoDO;

public interface SequenceInfoDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Sun Mar 24 11:37:07 CST 2019
     */
    int deleteByPrimaryKey(String name);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Sun Mar 24 11:37:07 CST 2019
     */
    int insert(SequenceInfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Sun Mar 24 11:37:07 CST 2019
     */
    int insertSelective(SequenceInfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Sun Mar 24 11:37:07 CST 2019
     */
    SequenceInfoDO selectByPrimaryKey(String name);

    SequenceInfoDO getSequenceByName(String name);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Sun Mar 24 11:37:07 CST 2019
     */
    int updateByPrimaryKeySelective(SequenceInfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sequence_info
     *
     * @mbg.generated Sun Mar 24 11:37:07 CST 2019
     */
    int updateByPrimaryKey(SequenceInfoDO record);


}