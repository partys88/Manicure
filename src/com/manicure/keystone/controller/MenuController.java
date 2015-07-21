/**
 * 
 */
package com.manicure.keystone.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.manicure.base.controller.BaseController;
import com.manicure.base.helper.ConfigUtil;
import com.manicure.keystone.entity.ErrorMsg;
import com.manicure.keystone.entity.WeChatAccessToken;
import com.manicure.keystone.service.impl.CoreService;
import com.manicure.keystone.service.impl.MenuService;

/**
 * @author Barrie
 *
 */
@Controller
@RequestMapping(value = "/api/keystone")
public class MenuController extends BaseController {
	@Resource
	MenuService menuService;
	@Resource
	CoreService coreService;

	@RequestMapping(value = "/menu/create")
	@ResponseBody
	public String create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 调用接口获取access_token		
		JSONObject at = coreService.getAccessToken(APP_ID, APP_SECRET);
		if (at.containsKey("errcode")) {
			logger.error(at.toString());
			return at.toString();
		}
		
		// 调用接口创建菜单
		JSONObject resp = menuService.create(at.getString("access_token"), ConfigUtil.getJson("menu.json"));
		if (resp.containsKey("errcode")) {
			logger.error(resp.toString());
			return resp.toString();
		}
		return resp.toString();
	}
}
