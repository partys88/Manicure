/**
 * 
 */
package com.manicure.keystone.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manicure.base.controller.BaseController;
import com.manicure.keystone.entity.WeatherInfo;
import com.manicure.keystone.service.iface.IDemoService;
import com.manicure.keystone.service.impl.DemoService;

/**
 * 
 * @author Barrie
 *
 */
@Controller
@RequestMapping(value = "/auth")
public class Demo extends BaseController<WeatherInfo> {
	IDemoService demoService;

	@Autowired
	public void setDemoService(DemoService demoService) {
		this.demoService = demoService;
	}
	@RequestMapping(value="/list")
	//@RequestMapping(value="/list",produces = "plain/text; charset=UTF-8") 
	@ResponseBody
	public String list() throws UnsupportedEncodingException {
		String rst = demoService.selectList();
		logger.info(rst);
		//System.out.println(new String("阿 dasd ".getBytes("iso8859-1"),"UTF-8"));
		return demoService.selectList();
	}

}