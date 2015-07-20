package com.manicure.product.mapper;

import com.manicure.product.entity.serviceComment;
import com.manicure.product.entity.serviceCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface serviceCommentMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table service_comment
	 * @mbggenerated  Mon Jul 20 20:27:17 CST 2015
	 */
	int countByExample(serviceCommentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table service_comment
	 * @mbggenerated  Mon Jul 20 20:27:17 CST 2015
	 */
	int deleteByExample(serviceCommentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table service_comment
	 * @mbggenerated  Mon Jul 20 20:27:17 CST 2015
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table service_comment
	 * @mbggenerated  Mon Jul 20 20:27:17 CST 2015
	 */
	int insert(serviceComment record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table service_comment
	 * @mbggenerated  Mon Jul 20 20:27:17 CST 2015
	 */
	int insertSelective(serviceComment record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table service_comment
	 * @mbggenerated  Mon Jul 20 20:27:17 CST 2015
	 */
	List<serviceComment> selectByExample(serviceCommentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table service_comment
	 * @mbggenerated  Mon Jul 20 20:27:17 CST 2015
	 */
	serviceComment selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table service_comment
	 * @mbggenerated  Mon Jul 20 20:27:17 CST 2015
	 */
	int updateByExampleSelective(@Param("record") serviceComment record,
			@Param("example") serviceCommentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table service_comment
	 * @mbggenerated  Mon Jul 20 20:27:17 CST 2015
	 */
	int updateByExample(@Param("record") serviceComment record,
			@Param("example") serviceCommentExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table service_comment
	 * @mbggenerated  Mon Jul 20 20:27:17 CST 2015
	 */
	int updateByPrimaryKeySelective(serviceComment record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table service_comment
	 * @mbggenerated  Mon Jul 20 20:27:17 CST 2015
	 */
	int updateByPrimaryKey(serviceComment record);
}