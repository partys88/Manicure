package com.manicure.keystone.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.manicure.keystone.dao.iface.IVentorDao;
import com.manicure.keystone.entity.WeatherInfo;
import com.manicure.keystone.entity.WeatherInfoExample;
import com.manicure.keystone.mapper.WeatherInfoMapper;

@Repository
public class VentorDaoImpl implements IVentorDao {
	@Autowired
	private WeatherInfoMapper map;

	@Override
	public String selectList() {
		// TODO Auto-generated method stub
		WeatherInfoExample example = new WeatherInfoExample();
		
		return map.selectByExample(example).toString();
	}

}
