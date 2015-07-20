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
import com.manicure.base.helper.ConfigUtil;
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
	public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 调用接口获取access_token
		WeChatAccessToken at = coreService.getAccessToken(APP_ID, APP_SECRET);

		if (null != at) {
			// 调用接口创建菜单
			int result = menuService.create(at.getToken(), ConfigUtil.getJson("menu.json"));

			// 判断菜单创建结果
			if (0 == result)
				logger.info("菜单创建成功！");
			else
				logger.info("菜单创建失败，错误码：" + result);
		}

	}
}
