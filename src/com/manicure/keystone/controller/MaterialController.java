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
import org.springframework.web.bind.annotation.ResponseBody;

import com.manicure.base.controller.BaseController;
import com.manicure.keystone.entity.WeChatAccessToken;
import com.manicure.keystone.service.iface.ICoreService;
import com.manicure.keystone.service.impl.MaterialService;

/**
 * @author Barrie
 *
 */
@Controller
@RequestMapping(value = "/api/keystone")
public class MaterialController extends BaseController {
	@Resource
	MaterialService materialService;
	@Resource
	ICoreService coreService;

	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/material/list")
	@ResponseBody
	public String getMaterialList(HttpServletRequest request, HttpServletResponse response) {
		// 调用接口获取access_token
		JSONObject at = coreService.getAccessToken(APP_ID, APP_SECRET);
		if (at.containsKey("errcode")) {
			logger.error(at.toString());
		}
		JSONObject resp = materialService.getMaterialList(at.getString("access_token"));
		if (resp.containsKey("errcode")) {
			logger.error(resp.toString());
		}
		return resp.toString();
	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param mediaId
	 * @return
	 */
	@RequestMapping(value = "/material/query/{mediaId}")
	@ResponseBody
	public String getMaterial(HttpServletRequest request, HttpServletResponse response, @PathVariable String mediaId) {
		// 调用接口获取access_token
		JSONObject at = coreService.getAccessToken(APP_ID, APP_SECRET);
		if (at.containsKey("errcode")) {
			logger.error(at.toString());
			return at.toString();
		}
		JSONObject resp = materialService.getMaterial(at.getString("access_token"), mediaId);
		if (resp.containsKey("errcode")) {
			logger.error(resp.toString());
			return resp.toString();
		}
		return resp.toString();
		
	}
}
