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
import com.manicure.keystone.service.impl.ShopService;

/**
 * @author Barrie
 *
 */
@Controller
@RequestMapping(value = "/api/keystone")
public class ShopController extends BaseController {
	@Resource
	CoreService coreService;
	@Resource
	ShopService shopService;

	@RequestMapping(value = "/shop/query/{poiId}", method = RequestMethod.GET)
	@ResponseBody
	public String getWeChatUserInfo(HttpServletRequest request, HttpServletResponse response, @PathVariable String poiId) {
		JSONObject at = coreService.getAccessToken(APP_ID, APP_SECRET);
		if (at.containsKey("errcode")) {
			logger.error(at.toString());
			return at.toString();
		}

		JSONObject resp = shopService.getShop(at.getString("access_token"), poiId);
		if (resp.containsKey("errcode")) {
			logger.error(resp.toString());
			return resp.toString();
		}
		return resp.toString();

	}

	@RequestMapping(value = "/shop/list/{begain}/{limit}", method = RequestMethod.GET)
	@ResponseBody
	public String getWeChatUserList(HttpServletRequest request, HttpServletResponse response, @PathVariable int begain, @PathVariable int limit) {
		JSONObject at = coreService.getAccessToken(APP_ID, APP_SECRET);
		if (at.containsKey("errcode")) {
			logger.error(at.toString());
			return at.toString();
		}

		JSONObject resp = shopService.getShopList(at.getString("access_token"), begain, limit);
		if (resp.containsKey("errcode")) {
			logger.error(resp.toString());
			return resp.toString();
		}
		return resp.toString();
	}
}
