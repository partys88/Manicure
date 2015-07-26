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
import com.manicure.keystone.entity.error.ErrorMsg;
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
	@RequestMapping(value = "/user/sns/query/{openId}/{accessToken}")
	@ResponseBody
	public String getSNSUserInfo(HttpServletRequest request, HttpServletResponse response, @PathVariable String openId, @PathVariable String accessToken) {

		// SNSUserInfo snsUserInfo = userService.getSNSUserInfo(accessToken,
		// openId);
		//
		// if (null != snsUserInfo)
		// logger.info(snsUserInfo.toString());
		// else
		// logger.info("error");
		// return JSONObject.fromObject(snsUserInfo).toString();
		JSONObject resp = userService.getSNSUserInfo(accessToken, openId);
		if (resp.containsKey("errcode")) {
			logger.error(resp.toString());
			return resp.toString();
		}
		return resp.toString();
	}

	/**
	 * SNS User OAuth登录
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/user/sns/oauth", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String SNSUserOAuth(HttpServletRequest request, HttpServletResponse response) {

		// 用户同意授权后，能获取到code
		String code = request.getParameter("code");
		logger.info(code);
		// 用户同意授权
		if (!"authdeny".equals(code) && null != code) {
			// 获取网页授权access_token
			JSONObject sat = userService.getOauth2AccessToken(APP_ID, APP_SECRET, code);
			if (sat.containsKey("errcode")) {
				logger.error(sat.toString());
				return sat.toString();
			}
			// 用户标识
			String openId = sat.getString("openid");
			if ("snsapi_userinfo".equals(sat.getString("scope"))) {

				// // 获取用户信息
				// SNSUserInfo snsUserInfo =
				// userService.getSNSUserInfo(accessToken, openId);
				// logger.info(snsUserInfo.toString());
				//
				// // 设置要传递的参数
				// request.setAttribute("snsUserInfo", snsUserInfo);
				//
				// return JSONObject.fromObject(snsUserInfo).toString();
				JSONObject resp = userService.getSNSUserInfo(sat.getString("access_token"), openId);
				if (resp.containsKey("errcode")) {
					logger.error(resp.toString());
					return resp.toString();
				}
				return resp.toString();
			} else {
				// 调用接口获取access_token
				JSONObject at = coreService.getAccessToken(APP_ID, APP_SECRET);
				if (at.containsKey("errcode")) {
					logger.error(at.toString());
					return at.toString();
				}

				// WeChatUserInfo wechatUserInfo =
				// userService.getWeChatUserInfo(at.getToken(), openId);
				// logger.info(wechatUserInfo.toString());
				//
				// return JSONObject.fromObject(wechatUserInfo).toString();
				JSONObject resp = userService.getWeChatUserInfo(at.getString("access_token"), openId);
				if (resp.containsKey("errcode")) {
					logger.error(resp.toString());
					return resp.toString();
				}
				return resp.toString();
			}
		}
		ErrorMsg errMsg = new ErrorMsg();
		errMsg.setErrcode("-1");
		errMsg.setErrmsg("not authorised");
		return JSONObject.fromObject(errMsg).toString();
	}

	/**
	 * 获取微信User信息
	 * 
	 * @param request
	 * @param response
	 * @param openId
	 * @return
	 */
	@RequestMapping(value = "/user/query/{openId}", produces = "application/json; charset=utf-8")
	@ResponseBody
	public String getWeChatUserInfo(HttpServletRequest request, HttpServletResponse response, @PathVariable String openId) {
		// 调用接口获取access_token
		// 调用接口获取access_token
		JSONObject at = coreService.getAccessToken(APP_ID, APP_SECRET);
		if (at.containsKey("errcode")) {
			logger.error(at.toString());
			return at.toString();
		}

		// WeChatUserInfo wechatUserInfo =
		// userService.getWeChatUserInfo(at.getToken(), openId);
		//
		// if (null != wechatUserInfo)
		// logger.info(wechatUserInfo.toString());
		// else
		// logger.error("user is null");
		// return JSONObject.fromObject(wechatUserInfo).toString();
		JSONObject resp = userService.getWeChatUserInfo(at.getString("access_token"), openId);
		if (resp.containsKey("errcode")) {
			logger.error(resp.toString());
			return resp.toString();
		}
		logger.info(resp.toString());
		return resp.toString();

	}

	@RequestMapping(value = "/user/list/{nextOpenId}")
	@ResponseBody
	public String getWeChatUserList(HttpServletRequest request, HttpServletResponse response, @PathVariable String nextOpenId) {
		// 调用接口获取access_token
		// 调用接口获取access_token
		JSONObject at = coreService.getAccessToken(APP_ID, APP_SECRET);
		if (at.containsKey("errcode")) {
			logger.error(at.toString());
			return at.toString();
		}
		if ("0".equals(nextOpenId))
			nextOpenId = null;

		// WeChatUserList wechatUserList =
		// userService.getWeChatUserList(at.getToken(), nextOpenId);
		//
		// if (null != wechatUserList)
		// logger.info(wechatUserList.toString());
		// else {
		// logger.error("list is null.");
		// }
		//
		// return JSONObject.fromObject(wechatUserList).toString();
		JSONObject resp = userService.getWeChatUserList(at.getString("access_token"), nextOpenId);
		if (resp.containsKey("errcode")) {
			logger.error(resp.toString());
			return resp.toString();
		}
		return resp.toString();
	}
}
