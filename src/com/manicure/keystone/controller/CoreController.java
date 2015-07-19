/**
 * 
 */
package com.manicure.keystone.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manicure.base.controller.BaseController;
import com.manicure.base.helper.ReadConfig;
import com.manicure.keystone.entity.AccessToken;
import com.manicure.keystone.helper.InterfaceUtil;
import com.manicure.keystone.service.iface.ICoreService;

/**
 * @author Barrie
 *
 */
@Controller
@RequestMapping(value = "/api")
public class CoreController extends BaseController {
	// 第三方用户唯一凭证
	String appId = ReadConfig.getProperty("wechat.properties", "appId");
	// 第三方用户唯一凭证密钥
	String appSecret = ReadConfig.getProperty("wechat.properties", "appSecret");;

	@Resource
	ICoreService coreService;
	@Resource
	InterfaceUtil ifaceUtil;

	@RequestMapping(value = "/core")
	public void connect(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method = request.getMethod();
		logger.info(method);
		if ("GET".equals(method)) {
			logger.info(request.getParameter("signature"));
			coreService.doGet(request, response);

		} else if ("POST".equals(method)) {
			logger.info(request.getInputStream().toString());
			coreService.doPost(request, response);
		}

	}

	@RequestMapping(value = "/core/menu")
	public void createMenu(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// 调用接口获取access_token
		AccessToken at = coreService.getAccessToken(appId, appSecret);

		if (null != at) {
			new ReadConfig();
			// 调用接口创建菜单
			int result = ifaceUtil.createMenu(
					ReadConfig.getJson("menu.json"), at.getToken());

			// 判断菜单创建结果
			if (0 == result)
				logger.info("菜单创建成功！");
			else
				logger.info("菜单创建失败，错误码：" + result);
		}

	}
}
