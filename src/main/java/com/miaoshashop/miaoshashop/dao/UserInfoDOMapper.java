package com.miaoshashop.miaoshashop.dao;

import com.miaoshashop.miaoshashop.dataobject.UserInfoDO;

public interface UserInfoDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Tue Mar 19 21:05:07 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Tue Mar 19 21:05:07 CST 2019
     */
    int insert(UserInfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Tue Mar 19 21:05:07 CST 2019
     */
    int insertSelective(UserInfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Tue Mar 19 21:05:07 CST 2019
     */
    UserInfoDO selectByPrimaryKey(Integer id);

    UserInfoDO selectByPhone(String phone);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Tue Mar 19 21:05:07 CST 2019
     */
    int updateByPrimaryKeySelective(UserInfoDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_info
     *
     * @mbg.generated Tue Mar 19 21:05:07 CST 2019
     */
    int updateByPrimaryKey(UserInfoDO record);
}