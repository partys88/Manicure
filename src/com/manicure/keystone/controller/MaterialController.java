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
		WeChatAccessToken at = coreService.getAccessToken(APP_ID, APP_SECRET);
		JSONObject jsonObject = materialService.getMaterialList(at.getToken());
		// logger.info(a);
		return jsonObject.toString();
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
		WeChatAccessToken at = coreService.getAccessToken(APP_ID, APP_SECRET);
		JSONObject jsonObject = materialService.getMaterial(at.getToken(), mediaId);
		// logger.info(a);
		return jsonObject.toString();
	}
}
