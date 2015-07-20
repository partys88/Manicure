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
import com.manicure.keystone.entity.SNSUserInfo;
import com.manicure.keystone.entity.WeChatAccessToken;
import com.manicure.keystone.entity.WeChatOauth2Token;
import com.manicure.keystone.entity.WeChatUserInfo;
import com.manicure.keystone.service.impl.CoreService;
import com.manicure.keystone.service.impl.UserService;

/**
 * @author Barrie
 *
 */
@Controller
@RequestMapping(value = "/api/keystone")
public class UserController extends BaseController {
	@Resource
	CoreService coreService;
	@Resource
	UserService userService;

	/**
	 * 获取SNS User信息
	 * 
	 * @param request
	 * @param response
	 * @param openId
	 * @param accessToken
	 * @return
	 */
	@RequestMapping(value = "/user/sns/{openId}/{accessToken}")
	@ResponseBody
	public String getSNSUserInfo(HttpServletRequest request, HttpServletResponse response, @PathVariable String openId, @PathVariable String accessToken) {
		// 调用接口创建菜单
		SNSUserInfo snsUserInfo = userService.getSNSUserInfo(accessToken, openId);
		// 判断菜单创建结果
		if (null != snsUserInfo)
			logger.info(snsUserInfo.toString());
		else
			logger.info("error");
		return JSONObject.fromObject(snsUserInfo).toString();
	}

	/**
	 * SNS User OAuth登录
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/user/sns/oauth")
	@ResponseBody
	public String SNSUserOAuth(HttpServletRequest request, HttpServletResponse response) {
		// 用户同意授权后，能获取到code
		String code = request.getParameter("code");

		// 用户同意授权
		if (!"authdeny".equals(code) && null != code) {
			// 获取网页授权access_token
			WeChatOauth2Token wechatOauth2Token = userService.getOauth2AccessToken(APP_ID, APP_SECRET, code);
			// 网页授权接口访问凭证
			String accessToken = wechatOauth2Token.getAccessToken();
			logger.info(wechatOauth2Token.toString());
			if ("snsapi_userinfo".equals(wechatOauth2Token.getScope())) {
				// 用户标识
				String openId = wechatOauth2Token.getOpenId();
				// 获取用户信息
				SNSUserInfo snsUserInfo = userService.getSNSUserInfo(accessToken, openId);
				logger.info(snsUserInfo.toString());

				// 设置要传递的参数
				request.setAttribute("snsUserInfo", snsUserInfo);

				return JSONObject.fromObject(snsUserInfo).toString();
			} else {
				// 用户标识
				String openId = wechatOauth2Token.getOpenId();
				// 调用接口获取access_token
				WeChatAccessToken at = coreService.getAccessToken(APP_ID, APP_SECRET);
				// 调用接口创建菜单
				WeChatUserInfo wechatUserInfo = userService.getWeChatUserInfo(at.getToken(), openId);
				logger.info(wechatUserInfo.toString());

				return JSONObject.fromObject(wechatUserInfo).toString();
			}
		}
		// return "/wechat/index";
		return null;
	}

	/**
	 * 获取微信User信息
	 * 
	 * @param request
	 * @param response
	 * @param openId
	 * @return
	 */
	@RequestMapping(value = "/user/{openId}")
	@ResponseBody
	public String getWeChatUserInfo(HttpServletRequest request, HttpServletResponse response, @PathVariable String openId) {
		// 调用接口获取access_token
		WeChatAccessToken at = coreService.getAccessToken(APP_ID, APP_SECRET);
		// 调用接口创建菜单
		WeChatUserInfo wechatUserInfo = userService.getWeChatUserInfo(at.getToken(), openId);
		// 判断菜单创建结果
		if (null != wechatUserInfo)
			logger.info(wechatUserInfo.toString());
		else
			logger.info("error");
		return JSONObject.fromObject(wechatUserInfo).toString();
	}
}
