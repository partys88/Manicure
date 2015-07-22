package com.manicure.product.dao.iface;

import java.util.List;

import com.manicure.product.entity.Service;
import com.manicure.product.entity.ServiceComment;
import com.manicure.product.entity.ServiceCommentExample;
import com.manicure.product.entity.ServiceExample;

public interface IProductDao {

	
	public List<Service> getServiceByType(ServiceExample example);
	
	public Service getServiceById(int id);
	
	public List<ServiceComment> getServiceCommentByServiceId(ServiceCommentExample example);
}
