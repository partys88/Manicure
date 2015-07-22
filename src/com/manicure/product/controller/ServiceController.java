package com.manicure.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.manicure.product.entity.Service;
import com.manicure.product.entity.ServiceComment;
import com.manicure.product.service.impl.IProductServiceImpl;

@Controller
@RequestMapping(value = "/api/service")
public class ServiceController {
	
	@Autowired
	private IProductServiceImpl iProductServiceImpl;
	
	//按服务类型列出
	@RequestMapping(value = "/list/{type}", method = RequestMethod.GET)
	public ModelAndView listServicesByType(@PathVariable String type) {
		
		ModelAndView mav = new ModelAndView("services");
		List<Service> serviceList = iProductServiceImpl.getServiceByType(type);
		mav.addObject("serviceList", serviceList);
		
		//TODO image
		return mav;
	}
	
	//按服务类型和销量列出
	@RequestMapping(value = "/list/{type}/sales/{order}", method = RequestMethod.GET)
	public ModelAndView listServicesByTypeAndSales(@PathVariable String type, @PathVariable Integer order) {
		
		// sales 1 递增 ; 0 递减
		ModelAndView mav = new ModelAndView("services");
		List<Service> serviceList = iProductServiceImpl.getServiceByTypeAndSales(type,order);
		mav.addObject("serviceList", serviceList);
		
		//TODO image
		return mav;
	}
	
	//按服务类型和价格排序
	@RequestMapping(value = "/list/{type}/price/{order}", method = RequestMethod.GET)
	public ModelAndView listServicesByTypeAndPrice(@PathVariable String type, @PathVariable Integer order) {
		//price 1 递增; 0递减
		// sales 1 递增 ; 0 递减
		ModelAndView mav = new ModelAndView("services");
		List<Service> serviceList = iProductServiceImpl.getServiceByTypeAndPrice(type,order);
		mav.addObject("serviceList", serviceList);
				
		//TODO image
		return mav;
		
	}
	
	//选择指定服务
	@RequestMapping(value = "/query/{serviceId}", method = RequestMethod.GET)
	public ModelAndView listServiceById(@PathVariable Integer serviceId) {
		ModelAndView mav = new ModelAndView("oneservice");
		Service service = iProductServiceImpl.getServiceById(serviceId);
		List<ServiceComment> serviceCommentList = iProductServiceImpl.getServiceCommentByServiceId(serviceId);
		
		mav.addObject("service",service);
		mav.addObject("serviceCommentList",serviceCommentList);
		
		//TODO image
		return mav;
	}
	
	//按类型和价格区间列出
	@RequestMapping(value = "/list/{type}/price/{low}/{high}")
	public ModelAndView listServiceByTypeAndBetweenPrice(@PathVariable String type, @PathVariable Integer low, @PathVariable Integer high) {
		ModelAndView mav = new ModelAndView("services");
		List<Service> serviceList = iProductServiceImpl.getServiceByTypeAndBetweenPrice(type,low,high);
		mav.addObject("serviceList",serviceList);
		
		//TODO image
		return mav;
	}
}





