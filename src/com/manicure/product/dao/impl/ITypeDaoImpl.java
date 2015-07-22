package com.manicure.product.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manicure.product.dao.iface.ITypeDao;
import com.manicure.product.entity.ServiceTypeExample;
import com.manicure.product.mapper.ServiceTypeMapper;

@Repository
public class ITypeDaoImpl implements ITypeDao {

	@Autowired
	private ServiceTypeMapper serviceTypeMapper;
	
	@Override
	public int getTypeIdByExample(ServiceTypeExample example) {
		return serviceTypeMapper.selectIdByExample(example);
	}

}
