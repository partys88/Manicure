package com.manicure.product.mapper;

import com.manicure.product.entity.ServiceType;
import com.manicure.product.entity.ServiceTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceTypeMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table service_type
	 * @mbggenerated  Wed Jul 22 20:39:19 CST 2015
	 */
	int countByExample(ServiceTypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table service_type
	 * @mbggenerated  Wed Jul 22 20:39:19 CST 2015
	 */
	int deleteByExample(ServiceTypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table service_type
	 * @mbggenerated  Wed Jul 22 20:39:19 CST 2015
	 */
	int deleteByPrimaryKey(Integer typeid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table service_type
	 * @mbggenerated  Wed Jul 22 20:39:19 CST 2015
	 */
	int insert(ServiceType record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table service_type
	 * @mbggenerated  Wed Jul 22 20:39:19 CST 2015
	 */
	int insertSelective(ServiceType record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table service_type
	 * @mbggenerated  Wed Jul 22 20:39:19 CST 2015
	 */
	List<ServiceType> selectByExample(ServiceTypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table service_type
	 * @mbggenerated  Wed Jul 22 20:39:19 CST 2015
	 */
	ServiceType selectByPrimaryKey(Integer typeid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table service_type
	 * @mbggenerated  Wed Jul 22 20:39:19 CST 2015
	 */
	int updateByExampleSelective(@Param("record") ServiceType record,
			@Param("example") ServiceTypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table service_type
	 * @mbggenerated  Wed Jul 22 20:39:19 CST 2015
	 */
	int updateByExample(@Param("record") ServiceType record,
			@Param("example") ServiceTypeExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table service_type
	 * @mbggenerated  Wed Jul 22 20:39:19 CST 2015
	 */
	int updateByPrimaryKeySelective(ServiceType record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table service_type
	 * @mbggenerated  Wed Jul 22 20:39:19 CST 2015
	 */
	int updateByPrimaryKey(ServiceType record);
	
	/**
     * 获取service type的id
     * @param example
     * @return
     */
    int selectIdByExample(ServiceTypeExample example);
}