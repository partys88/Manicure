package com.manicure.product.dao.iface;

import com.manicure.product.entity.ServiceTypeExample;

public interface ITypeDao {
	
	public int getTypeIdByExample(ServiceTypeExample example);
}
