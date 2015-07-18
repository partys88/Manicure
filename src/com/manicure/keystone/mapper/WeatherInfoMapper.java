package com.manicure.keystone.mapper;

import com.manicure.keystone.entity.WeatherInfo;
import com.manicure.keystone.entity.WeatherInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WeatherInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weatherinfo
     *
     * @mbggenerated Sun Jul 19 04:37:20 CST 2015
     */
    int countByExample(WeatherInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weatherinfo
     *
     * @mbggenerated Sun Jul 19 04:37:20 CST 2015
     */
    int deleteByExample(WeatherInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weatherinfo
     *
     * @mbggenerated Sun Jul 19 04:37:20 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weatherinfo
     *
     * @mbggenerated Sun Jul 19 04:37:20 CST 2015
     */
    int insert(WeatherInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weatherinfo
     *
     * @mbggenerated Sun Jul 19 04:37:20 CST 2015
     */
    int insertSelective(WeatherInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weatherinfo
     *
     * @mbggenerated Sun Jul 19 04:37:20 CST 2015
     */
    List<WeatherInfo> selectByExample(WeatherInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weatherinfo
     *
     * @mbggenerated Sun Jul 19 04:37:20 CST 2015
     */
    WeatherInfo selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weatherinfo
     *
     * @mbggenerated Sun Jul 19 04:37:20 CST 2015
     */
    int updateByExampleSelective(@Param("record") WeatherInfo record, @Param("example") WeatherInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weatherinfo
     *
     * @mbggenerated Sun Jul 19 04:37:20 CST 2015
     */
    int updateByExample(@Param("record") WeatherInfo record, @Param("example") WeatherInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weatherinfo
     *
     * @mbggenerated Sun Jul 19 04:37:20 CST 2015
     */
    int updateByPrimaryKeySelective(WeatherInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table weatherinfo
     *
     * @mbggenerated Sun Jul 19 04:37:20 CST 2015
     */
    int updateByPrimaryKey(WeatherInfo record);
}