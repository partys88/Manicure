/**
 * 
 */
package com.manicure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author Barrie
 *
 */
@Controller
@RequestMapping(value = "/auth")
public class Demo {
	DemoService demoService;

	@Autowired
	public void setDemoService(DemoService demoService) {
		this.demoService = demoService;
	}

	@RequestMapping(value = "/list")
	@ResponseBody
	public String list() {
		return demoService.selectList();
	}

}