/**
 * 
 */
package com.manicure.keystone.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manicure.base.controller.BaseController;
import com.manicure.keystone.service.impl.CoreService;
import com.manicure.keystone.service.impl.ProductService;

/**
 * @author Barrie
 *
 */
@Controller
@RequestMapping(value = "/api/keystone")
public class ProductController extends BaseController {
	@Resource
	CoreService coreService;
	@Resource
	ProductService productService;

	@RequestMapping(value = "/product/list/{status}", method = RequestMethod.GET)
	@ResponseBody
	public String getProductList(HttpServletRequest request, HttpServletResponse response, @PathVariable int status) {
		JSONObject at = coreService.getAccessToken(APP_ID, APP_SECRET);
		if (at.containsKey("errcode")) {
			logger.error(at.toString());
			return at.toString();
		}

		JSONObject resp = productService.getProductList(at.getString("access_token"), status);
		if (resp.containsKey("errcode") && !resp.getString("errcode").equals("0")) {
			logger.error(resp.toString());
			return resp.toString();
		}
		return resp.toString();
	}

	@RequestMapping(value = "/product/query/{productId}", method = RequestMethod.GET)
	@ResponseBody
	public String getProduct(HttpServletRequest request, HttpServletResponse response, @PathVariable String productId) {
		JSONObject at = coreService.getAccessToken(APP_ID, APP_SECRET);
		if (at.containsKey("errcode")) {
			logger.error(at.toString());
			return at.toString();
		}

		JSONObject resp = productService.getProduct(at.getString("access_token"), productId);
		if (resp.containsKey("errcode") && !resp.getString("errcode").equals("0")) {
			logger.error(resp.toString());
			return resp.toString();
		}
		return resp.toString();
	}

}
