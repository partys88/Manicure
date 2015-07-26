/**
 * 
 */
package com.manicure.keystone.service.impl;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.manicure.base.helper.HttpClientUtil;
import com.manicure.base.service.BaseService;
import com.manicure.keystone.entity.error.ErrorMsg;
import com.manicure.keystone.service.iface.ICoreService;
import com.manicure.keystone.service.iface.IUserService;

/**
 * @author Barrie
 *
 */
@Service
public class UserService extends BaseService implements IUserService {
	@Resource
	ICoreService coreService;

	/**
	 * 获取网页授权凭证
	 * 
	 * @param appId
	 * @param appSecret
	 * @param code
	 * @return
	 */
	public JSONObject getOauth2AccessToken(String appId, String appSecret, String code) {
		// WeChatOauth2Token wat = null;
		// 拼装创建菜单的url
		String url = URL_SNS_OAUTH2_TOKEN_GET.replace("APPID", appId).replace("SECRET", appSecret).replace("CODE", code);
		// 获取网页授权凭证
		JSONObject response = HttpClientUtil.doHttpsPost(url, "POST", null);

		if (null == response) {
			ErrorMsg errMsg = new ErrorMsg();
			errMsg.setErrcode("-1");
			errMsg.setErrmsg("server is busy");

			return JSONObject.fromObject(errMsg);
		}
		return response;

	}

	/**
	 * 刷新网页授权凭证
	 * 
	 * @param appId
	 * @param refreshToken
	 * @return
	 */
	public JSONObject refreshOauth2AccessToken(String appId, String refreshToken) {
		// WeChatOauth2Token wat = null;
		// 拼装创建菜单的url
		String url = URL_SNS_OAUTH2_TOKEN_REFRESH.replace("APPID", appId).replace("REFRESH_TOKEN", refreshToken);
		// 刷新网页授权凭证
		JSONObject response = HttpClientUtil.doHttpsPost(url, "POST", null);

		if (null == response) {
			ErrorMsg errMsg = new ErrorMsg();
			errMsg.setErrcode("-1");
			errMsg.setErrmsg("server is busy");

			return JSONObject.fromObject(errMsg);
		}
		return response;
	}

	/**
	 * 通过网页授权获取用户信息
	 * 
	 * @param accessToken
	 *            网页授权接口调用凭证
	 * @param openId
	 *            用户标识
	 * @return SNSUserInfo
	 */
	// @SuppressWarnings({ "deprecation", "unchecked" })
	public JSONObject getSNSUserInfo(String accessToken, String openId) {
		// SNSUserInfo snsUserInfo = null;

		// 拼装创建菜单的url
		String url = URL_USER_GET_SNS_INFO.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
		// 通过网页授权获取用户信息
		JSONObject response = HttpClientUtil.doHttpsPost(url, "POST", null);

		if (null == response) {
			ErrorMsg errMsg = new ErrorMsg();
			errMsg.setErrcode("-1");
			errMsg.setErrmsg("server is busy");

			return JSONObject.fromObject(errMsg);
		}
		return response;
	}

	/**
	 * 获取用户信息
	 * 
	 * @param accessToken
	 *            接口访问凭证
	 * @param openId
	 *            用户标识
	 * @return WeixinUserInfo
	 */
	public JSONObject getWeChatUserInfo(String accessToken, String openId) {
		// WeChatUserInfo wechatUserInfo = null;
		// 拼装创建菜单的url
		String url = URL_USER_GET_INFO.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
		// 获取用户信息
		JSONObject response = HttpClientUtil.doHttpsPost(url, "POST", null);

		if (null == response) {
			ErrorMsg errMsg = new ErrorMsg();
			errMsg.setErrcode("-1");
			errMsg.setErrmsg("server is busy");

			return JSONObject.fromObject(errMsg);
		}
		return response;
	}

	/**
	 * 获取关注者列表
	 * 
	 * @param accessToken
	 * @param nextOpenId
	 * @return
	 */
	public JSONObject getWeChatUserList(String accessToken, String nextOpenId) {
		// WeChatUserList wechatUserList = null;
		if (null == nextOpenId)
			nextOpenId = "";
		// 拼装创建菜单的url
		String url = URL_USER_GET_LIST.replace("ACCESS_TOKEN", accessToken).replace("NEXT_OPENID", nextOpenId);
		// 获取关注者列表
		JSONObject response = HttpClientUtil.doHttpsPost(url, "POST", null);

		if (null == response) {
			ErrorMsg errMsg = new ErrorMsg();
			errMsg.setErrcode("-1");
			errMsg.setErrmsg("server is busy");

			return JSONObject.fromObject(errMsg);
		}
		return response;
	}

}
