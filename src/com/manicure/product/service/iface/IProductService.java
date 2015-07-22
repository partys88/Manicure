package com.manicure.product.service.iface;

import java.util.List;

import com.manicure.product.entity.Service;
import com.manicure.product.entity.ServiceComment;
import com.manicure.product.entity.ServiceCommentExample;

public interface IProductService {
	
	public List<Service> getServiceByType(String type);
	
	public List<Service> getServiceByTypeAndSales(String type, int sales);
	
	public List<Service> getServiceByTypeAndPrice(String type, int price);
	
	public Service getServiceById(int id);
	
	public List<ServiceComment> getServiceCommentByServiceId(int serviceId);
	
	public List<Service> getServiceByTypeAndBetweenPrice(String type, int low, int high);
}
