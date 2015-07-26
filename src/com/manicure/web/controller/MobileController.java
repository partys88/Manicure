/**
 * 
 */
package com.manicure.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manicure.base.controller.BaseController;
import com.manicure.base.helper.HttpClientUtil;
import com.manicure.keystone.service.impl.CoreService;
import com.manicure.keystone.service.impl.UserService;

/**
 * @author Barrie
 *
 */
@Controller
@RequestMapping(value = "/mobile")
public class MobileController extends BaseController {
	@Resource
	CoreService coreService;
	@Resource
	UserService userService;

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

	@RequestMapping(value = "/space")
	public String space() {
		return "/mobile/space";
	}

	@RequestMapping(value = "/product/{productId}")
	public String item(HttpServletRequest request, HttpServletResponse response, ModelMap model, @PathVariable String productId) {
		model.addAttribute("pid", productId);
		return "/mobile/product";
	}

	@RequestMapping(value = { "/", "/index" }, produces = "application/json; charset=utf-8")
	public String index(HttpServletRequest request, HttpServletResponse response) {
		String code = request.getParameter("code");

		String path = request.getContextPath();
		int port = request.getServerPort();
		String basePath = null;
		if (80 == port) {
			basePath = request.getScheme() + "://" + request.getServerName() + path;
		} else {
			basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
		}

		String url = basePath + "/api/keystone/user/sns/oauth";
		logger.info(url);
		Map<String, String> params = new HashMap();
		params.put("code", code);
		
		String resp = HttpClientUtil.doHttpPost(url, params, "UTF-8");

		if (null == resp) {
			logger.error("fail to post");
		}
		logger.info(resp);
		// JSONObject userInfo = JSONObject.fromObject(resp);
//		if (!userInfo.containsKey("errcode")) {
//			logger.info(userInfo.toString());
//
//		}

		return "/mobile/service";
	}
}
