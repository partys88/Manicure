package com.manicure.product.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manicure.product.dao.iface.IProductDao;
import com.manicure.product.entity.Service;
import com.manicure.product.entity.ServiceComment;
import com.manicure.product.entity.ServiceCommentExample;
import com.manicure.product.entity.ServiceExample;
import com.manicure.product.mapper.ServiceCommentMapper;
import com.manicure.product.mapper.ServiceMapper;

@Repository
public class IProductDaoImpl implements IProductDao {

	@Autowired
	private ServiceMapper serviceMapper;
	
	@Autowired
	private ServiceCommentMapper serviceCommentMapper;
	
	@Override
	public List<Service> getServiceByType(ServiceExample example) {
		return serviceMapper.selectByExample(example);
	}

	@Override
	public Service getServiceById(int id) {
		return serviceMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ServiceComment> getServiceCommentByServiceId(ServiceCommentExample example) {
		return serviceCommentMapper.selectByExample(example);
	}

}
