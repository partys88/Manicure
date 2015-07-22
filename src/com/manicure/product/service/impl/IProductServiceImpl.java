package com.manicure.product.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.manicure.product.dao.impl.IProductDaoImpl;
import com.manicure.product.dao.impl.ITypeDaoImpl;
import com.manicure.product.entity.Service;
import com.manicure.product.entity.ServiceComment;
import com.manicure.product.entity.ServiceCommentExample;
import com.manicure.product.entity.ServiceExample;
import com.manicure.product.entity.ServiceTypeExample;
import com.manicure.product.service.iface.IProductService;

@org.springframework.stereotype.Service
public class IProductServiceImpl implements IProductService {

	@Autowired
	private ITypeDaoImpl iTypeDaoImpl;
	
	@Autowired
	private IProductDaoImpl iProductDaoImpl;

	@Override
	public List<Service> getServiceByType(String type) {
		
		int typeId = getTypeIdByExample(type);
		
		ServiceExample serviceExample = new ServiceExample();
		ServiceExample.Criteria serviceCriteria = serviceExample.createCriteria();
		serviceCriteria.andServicetypeEqualTo(typeId);
		
		List<Service> serviceList = iProductDaoImpl.getServiceByType(serviceExample);
		
		return serviceList;
	}

	@Override
	public List<Service> getServiceByTypeAndSales(String type, int order) {

		int typeId = getTypeIdByExample(type);
		
		ServiceExample serviceExample = new ServiceExample();
		ServiceExample.Criteria serviceCriteria = serviceExample.createCriteria();
		serviceCriteria.andServicetypeEqualTo(typeId);
		if(order == 0) {
			serviceExample.setOrderByClause("sales desc");
		} else if (order == 1) {
			serviceExample.setOrderByClause("sales asc");
		}
		
		List<Service> serviceList = iProductDaoImpl.getServiceByType(serviceExample);
		
		return serviceList;
	}
	
	@Override
	public List<Service> getServiceByTypeAndPrice(String type, int order) {
		int typeId = getTypeIdByExample(type);
		
		ServiceExample serviceExample = new ServiceExample();
		ServiceExample.Criteria serviceCriteria = serviceExample.createCriteria();
		serviceCriteria.andServicetypeEqualTo(typeId);
		
		if(order == 0) {
			serviceExample.setOrderByClause("price desc");
		} else if (order == 1) {
			serviceExample.setOrderByClause("price");
		}
		
		List<Service> serviceList = iProductDaoImpl.getServiceByType(serviceExample);
		
		return serviceList;
	}

	@Override
	public Service getServiceById(int id) {
		Service service = iProductDaoImpl.getServiceById(id);
		return service;
	}

	@Override
	public List<ServiceComment> getServiceCommentByServiceId(int serviceId) {
		ServiceCommentExample commentExample = new ServiceCommentExample();
		ServiceCommentExample.Criteria criteria = commentExample.createCriteria();
		criteria.andServiceidEqualTo(serviceId);
		
		List<ServiceComment> commentList = iProductDaoImpl.getServiceCommentByServiceId(commentExample);
		return commentList;
	}
	
	@Override
	public List<Service> getServiceByTypeAndBetweenPrice(String type, int low,
			int high) {
		int typeId = getTypeIdByExample(type);
		ServiceExample serviceExample = new ServiceExample();
		ServiceExample.Criteria criteria = serviceExample.createCriteria();
		criteria.andServicetypeEqualTo(typeId);
		criteria.andPriceBetween(new BigDecimal(low), new BigDecimal(high));
		
		List<Service> serviceList = iProductDaoImpl.getServiceByType(serviceExample);
		
		return serviceList;
	}
	
	public int getTypeIdByExample(String type) {
		ServiceTypeExample typeExample = new ServiceTypeExample();
		ServiceTypeExample.Criteria typeCriteria = typeExample.createCriteria();
		typeCriteria.andNameEqualTo(type);
		int typeId = iTypeDaoImpl.getTypeIdByExample(typeExample);
		return typeId;
	}

}
