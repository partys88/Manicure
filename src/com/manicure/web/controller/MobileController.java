/**
 * 
 */
package com.manicure.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manicure.base.controller.BaseController;

/**
 * @author Barrie
 *
 */
@Controller
@RequestMapping(value = "/mobile")
public class MobileController extends BaseController {
	@RequestMapping(value = "/home")
	public String home() {
		return "/mobile/home";
	}

	@RequestMapping(value = "/order")
	public String order() {
		return "/mobile/order";
	}

	@RequestMapping(value = "/service")
	public String service() {
		return "/mobile/service";
	}

	@RequestMapping(value = "/list")
	public String list() {
		return "/mobile/list";
	}
	
	@RequestMapping(value = {"/","/index"})
	public String index() {
		return "/mobile/service";
	}
}
