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
import com.manicure.base.helper.Encoder;
import com.manicure.base.helper.UrlUtil;
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
		String menuStr = ConfigUtil.getJson("menu.json");

		String urlHome = URL_SNS_OAUTH2_REDIRECT.replace("REDIRECT_URI", Encoder.urlEncodeUTF8("http://barrieshieh.tunnel.mobi/Manicure/mobile/index")).replace("APPID", APP_ID)
				.replace("SCOPE", "snsapi_base").replace("STATE", "STATE");
		menuStr = menuStr.replace(MenuService.V2002_WEB_HOME, urlHome);
		String urlOrder = URL_SNS_OAUTH2_REDIRECT.replace("REDIRECT_URI", Encoder.urlEncodeUTF8("http://barrieshieh.tunnel.mobi/Manicure/mobile/order")).replace("APPID", APP_ID)
				.replace("SCOPE", "snsapi_base").replace("STATE", "STATE");
		menuStr = menuStr.replace(MenuService.V3002_ORDER, urlOrder);
		String urlNewArrived = URL_SNS_OAUTH2_REDIRECT.replace("REDIRECT_URI", Encoder.urlEncodeUTF8("http://barrieshieh.tunnel.mobi/Manicure/mobile/index")).replace("APPID", APP_ID)
				.replace("SCOPE", "snsapi_base").replace("STATE", "STATE");
		menuStr = menuStr.replace(MenuService.V1003_NEW_ARRIVED, urlNewArrived);
		String urlLottery = URL_SNS_OAUTH2_REDIRECT.replace("REDIRECT_URI", Encoder.urlEncodeUTF8("http://barrieshieh.tunnel.mobi/Manicure/mobile/home")).replace("APPID", APP_ID)
				.replace("SCOPE", "snsapi_base").replace("STATE", "STATE");
		menuStr = menuStr.replace(MenuService.V1001_LOTTERY, urlLottery);
		String urlAddress = URL_SNS_OAUTH2_REDIRECT.replace("REDIRECT_URI", Encoder.urlEncodeUTF8("http://barrieshieh.tunnel.mobi/Manicure/mobile/home")).replace("APPID", APP_ID)
				.replace("SCOPE", "snsapi_base").replace("STATE", "STATE");
		menuStr = menuStr.replace(MenuService.V3001_ADDREDD, urlAddress);
		logger.info(menuStr);
		// 调用接口创建菜单
		JSONObject resp = JSONObject.fromObject(menuService.create(at.getString("access_token"), JSONObject.fromObject(menuStr)));
		if (resp.containsKey("errcode")) {
			logger.error(resp.toString());
			return resp.toString();
		}
		return resp.toString();
	}
}
