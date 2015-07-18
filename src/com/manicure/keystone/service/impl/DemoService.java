/**
 * 
 */
package com.manicure.keystone.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manicure.keystone.dao.impl.VentorDaoImpl;

/**
 * @author Barrie
 *
 */
@Service
public class DemoService {
	
	@Autowired
	private VentorDaoImpl ven;
	
	public String selectList() {

		return ven.selectList();
	}

}
