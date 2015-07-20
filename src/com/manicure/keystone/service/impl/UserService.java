/**
 * 
 */
package com.manicure.keystone.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.manicure.base.service.BaseService;
import com.manicure.keystone.entity.SNSUserInfo;
import com.manicure.keystone.entity.WeChatOauth2Token;
import com.manicure.keystone.entity.WeChatUserInfo;
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
	public WeChatOauth2Token getOauth2AccessToken(String appId, String appSecret, String code) {
		WeChatOauth2Token wat = null;
		// 拼装创建菜单的url
		String url = SNS_OAUTH2_GET_TOKEN_URL.replace("APPID", appId).replace("SECRET", appSecret).replace("CODE", code);
		// 获取网页授权凭证
		JSONObject jsonObject = coreService.httpsRequest(url, "GET", null);
		if (null != jsonObject) {
			try {
				wat = new WeChatOauth2Token();
				wat.setAccessToken(jsonObject.getString("access_token"));
				wat.setExpiresIn(jsonObject.getInt("expires_in"));
				wat.setRefreshToken(jsonObject.getString("refresh_token"));
				wat.setOpenId(jsonObject.getString("openid"));
				wat.setScope(jsonObject.getString("scope"));
			} catch (Exception e) {
				wat = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				logger.error("获取网页授权凭证失败 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return wat;
	}

	/**
	 * 刷新网页授权凭证
	 * 
	 * @param appId
	 * @param refreshToken
	 * @return
	 */
	public WeChatOauth2Token refreshOauth2AccessToken(String appId, String refreshToken) {
		WeChatOauth2Token wat = null;
		// 拼装创建菜单的url
		String url = SNS_OAUTH2_REFRESH_TOKEN_URL.replace("APPID", appId).replace("REFRESH_TOKEN", refreshToken);
		// 刷新网页授权凭证
		JSONObject jsonObject = coreService.httpsRequest(url, "GET", null);
		if (null != jsonObject) {
			try {
				wat = new WeChatOauth2Token();
				wat.setAccessToken(jsonObject.getString("access_token"));
				wat.setExpiresIn(jsonObject.getInt("expires_in"));
				wat.setRefreshToken(jsonObject.getString("refresh_token"));
				wat.setOpenId(jsonObject.getString("openid"));
				wat.setScope(jsonObject.getString("scope"));
			} catch (Exception e) {
				wat = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				logger.error("刷新网页授权凭证失败 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return wat;
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
	@SuppressWarnings({ "deprecation", "unchecked" })
	public SNSUserInfo getSNSUserInfo(String accessToken, String openId) {
		SNSUserInfo snsUserInfo = null;

		// 拼装创建菜单的url
		String url = SNS_USER_GET_INFO_URL.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
		// 通过网页授权获取用户信息
		JSONObject jsonObject = coreService.httpsRequest(url, "GET", null);

		if (null != jsonObject) {
			try {
				snsUserInfo = new SNSUserInfo();
				// 用户的标识
				snsUserInfo.setOpenId(jsonObject.getString("openid"));
				// 昵称
				snsUserInfo.setNickname(jsonObject.getString("nickname"));
				// 性别（1是男性，2是女性，0是未知）
				snsUserInfo.setSex(jsonObject.getInt("sex"));
				// 用户所在国家
				snsUserInfo.setCountry(jsonObject.getString("country"));
				// 用户所在省份
				snsUserInfo.setProvince(jsonObject.getString("province"));
				// 用户所在城市
				snsUserInfo.setCity(jsonObject.getString("city"));
				// 用户头像
				snsUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
				// 用户特权信息
				snsUserInfo.setPrivilegeList(JSONArray.toList(jsonObject.getJSONArray("privilege"), List.class));
			} catch (Exception e) {
				snsUserInfo = null;
				int errorCode = jsonObject.getInt("errcode");
				String errorMsg = jsonObject.getString("errmsg");
				logger.error("获取用户信息失败 errcode:{} errmsg:{}", errorCode, errorMsg);
			}
		}
		return snsUserInfo;
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
	public WeChatUserInfo getWeChatUserInfo(String accessToken, String openId) {
		WeChatUserInfo wechatUserInfo = null;
		// 拼装创建菜单的url
		String url = USER_GET_INFO_URL.replace("ACCESS_TOKEN", accessToken).replace("OPENID", openId);
		// 获取用户信息
		JSONObject jsonObject = coreService.httpsRequest(url, "GET", null);

		if (null != jsonObject) {
			try {
				wechatUserInfo = new WeChatUserInfo();
				// 用户的标识
				wechatUserInfo.setOpenId(jsonObject.getString("openid"));
				// 关注状态（1是关注，0是未关注），未关注时获取不到其余信息
				wechatUserInfo.setSubscribe(jsonObject.getInt("subscribe"));
				// 用户关注时间
				wechatUserInfo.setSubscribeTime(jsonObject.getString("subscribe_time"));
				// 昵称
				wechatUserInfo.setNickname(jsonObject.getString("nickname"));
				// 用户的性别（1是男性，2是女性，0是未知）
				wechatUserInfo.setSex(jsonObject.getInt("sex"));
				// 用户所在国家
				wechatUserInfo.setCountry(jsonObject.getString("country"));
				// 用户所在省份
				wechatUserInfo.setProvince(jsonObject.getString("province"));
				// 用户所在城市
				wechatUserInfo.setCity(jsonObject.getString("city"));
				// 用户的语言，简体中文为zh_CN
				wechatUserInfo.setLanguage(jsonObject.getString("language"));
				// 用户头像
				wechatUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
			} catch (Exception e) {
				if (0 == wechatUserInfo.getSubscribe()) {
					logger.error("用户{}已取消关注", wechatUserInfo.getOpenId());
				} else {
					int errorCode = jsonObject.getInt("errcode");
					String errorMsg = jsonObject.getString("errmsg");
					logger.error("获取用户信息失败 errcode:{} errmsg:{}", errorCode, errorMsg);
				}
			}
		}
		return wechatUserInfo;
	}
}
