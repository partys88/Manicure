/**
 * 
 */
package com.manicure.keystone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

	@RequestMapping(value = "/list/{id}/{name}", method = RequestMethod.GET)
	@ResponseBody
	public String list(@PathVariable String id, @PathVariable String name) {
		String rst = demoService.selectList();
		rst += "{" + id + "}" + "{" + name + "}";
		logger.info(rst);

		return rst;
	}

}