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
		String url = URL_SNS_OAUTH2_GET_TOKEN.replace("APPID", appId).replace("SECRET", appSecret).replace("CODE", code);
		// 获取网页授权凭证
		String response = HttpClientUtil.doHttpsPost(url, null, "UTF-8");
		JSONObject jsonObject = JSONObject.fromObject(response);
		// if (null != jsonObject) {
		// try {
		// wat = new WeChatOauth2Token();
		// wat.setAccessToken(jsonObject.getString("access_token"));
		// wat.setExpiresIn(jsonObject.getInt("expires_in"));
		// wat.setRefreshToken(jsonObject.getString("refresh_token"));
		// wat.setOpenId(jsonObject.getString("openid"));
		// wat.setScope(jsonObject.getString("scope"));
		// } catch (Exception e) {
		// wat = null;
		// int errorCode = jsonObject.getInt("errcode");
		// String errorMsg = jsonObject.getString("errmsg");
		// logger.error("获取网页授权凭证失败 errcode:{} errmsg:{}", errorCode, errorMsg);
		// }
		// }
		// return wat;
		if (null == jsonObject) {
			ErrorMsg errMsg = new ErrorMsg();
			errMsg.setErrcode("-1");
			errMsg.setErrmsg("server is busy");
			return JSONObject.fromObject(errMsg);
		}
		return jsonObject;

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
		String url = URL_SNS_OAUTH2_REFRESH_TOKEN.replace("APPID", appId).replace("REFRESH_TOKEN", refreshToken);
		// 刷新网页授权凭证
		String response = HttpClientUtil.doHttpsPost(url, null, "UTF-8");
		JSONObject jsonObject = JSONObject.fromObject(response);
		// if (null != jsonObject) {
		// try {
		// wat = new WeChatOauth2Token();
		// wat.setAccessToken(jsonObject.getString("access_token"));
		// wat.setExpiresIn(jsonObject.getInt("expires_in"));
		// wat.setRefreshToken(jsonObject.getString("refresh_token"));
		// wat.setOpenId(jsonObject.getString("openid"));
		// wat.setScope(jsonObject.getString("scope"));
		// } catch (Exception e) {
		// wat = null;
		// int errorCode = jsonObject.getInt("errcode");
		// String errorMsg = jsonObject.getString("errmsg");
		// logger.error("刷新网页授权凭证失败 errcode:{} errmsg:{}", errorCode, errorMsg);
		// }
		// }
		// return wat;
		if (null == jsonObject) {
			ErrorMsg errMsg = new ErrorMsg();
			errMsg.setErrcode("-1");
			errMsg.setErrmsg("server is busy");
			return JSONObject.fromObject(errMsg);
		}
		return jsonObject;
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
		String response = HttpClientUtil.doHttpsPost(url, null, "UTF-8");
		JSONObject jsonObject = JSONObject.fromObject(response);

		// if (null != jsonObject) {
		// try {
		// snsUserInfo = new SNSUserInfo();
		// // 用户的标识
		// snsUserInfo.setOpenId(jsonObject.getString("openid"));
		// // 昵称
		// snsUserInfo.setNickname(jsonObject.getString("nickname"));
		// // 性别（1是男性，2是女性，0是未知）
		// snsUserInfo.setSex(jsonObject.getInt("sex"));
		// // 用户所在国家
		// snsUserInfo.setCountry(jsonObject.getString("country"));
		// // 用户所在省份
		// snsUserInfo.setProvince(jsonObject.getString("province"));
		// // 用户所在城市
		// snsUserInfo.setCity(jsonObject.getString("city"));
		// // 用户头像
		// snsUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
		// // 用户特权信息
		// snsUserInfo.setPrivilegeList(JSONArray.toList(jsonObject.getJSONArray("privilege"),
		// List.class));
		// } catch (Exception e) {
		// snsUserInfo = null;
		// int errorCode = jsonObject.getInt("errcode");
		// String errorMsg = jsonObject.getString("errmsg");
		// logger.error("获取用户信息失败 errcode:{} errmsg:{}", errorCode, errorMsg);
		// }
		// }
		// return snsUserInfo;
		if (null == jsonObject) {
			ErrorMsg errMsg = new ErrorMsg();
			errMsg.setErrcode("-1");
			errMsg.setErrmsg("server is busy");

			return JSONObject.fromObject(errMsg);
		}
		return jsonObject;
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
		String response = HttpClientUtil.doHttpsPost(url, null, "UTF-8");
		
				
		JSONObject jsonObject = JSONObject.fromObject(response);

		// if (null != jsonObject) {
		// try {
		// wechatUserInfo = new WeChatUserInfo();
		// // 用户的标识
		// wechatUserInfo.setOpenId(jsonObject.getString("openid"));
		// // 关注状态（1是关注，0是未关注），未关注时获取不到其余信息
		// wechatUserInfo.setSubscribe(jsonObject.getInt("subscribe"));
		// // 用户关注时间
		// wechatUserInfo.setSubscribeTime(jsonObject.getString("subscribe_time"));
		// // 昵称
		// wechatUserInfo.setNickname(jsonObject.getString("nickname"));
		// // 用户的性别（1是男性，2是女性，0是未知）
		// wechatUserInfo.setSex(jsonObject.getInt("sex"));
		// // 用户所在国家
		// wechatUserInfo.setCountry(jsonObject.getString("country"));
		// // 用户所在省份
		// wechatUserInfo.setProvince(jsonObject.getString("province"));
		// // 用户所在城市
		// wechatUserInfo.setCity(jsonObject.getString("city"));
		// // 用户的语言，简体中文为zh_CN
		// wechatUserInfo.setLanguage(jsonObject.getString("language"));
		// // 用户头像
		// wechatUserInfo.setHeadImgUrl(jsonObject.getString("headimgurl"));
		// } catch (Exception e) {
		// if (0 == wechatUserInfo.getSubscribe()) {
		// logger.error("用户{}已取消关注", wechatUserInfo.getOpenId());
		// } else {
		// int errorCode = jsonObject.getInt("errcode");
		// String errorMsg = jsonObject.getString("errmsg");
		// logger.error("获取用户信息失败 errcode:{} errmsg:{}", errorCode, errorMsg);
		// }
		// }
		// }
		// return wechatUserInfo;
		if (null == jsonObject) {
			ErrorMsg errMsg = new ErrorMsg();
			errMsg.setErrcode("-1");
			errMsg.setErrmsg("server is busy");

			return JSONObject.fromObject(errMsg);
		}
		return jsonObject;
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
		String response = HttpClientUtil.doHttpsPost(url, null, "UTF-8");
		JSONObject jsonObject = JSONObject.fromObject(response);
		// // 如果请求成功
		// if (null != jsonObject &&
		// !"0".equals(jsonObject.get("count").toString())) {
		// try {
		// wechatUserList = new WeChatUserList();
		// wechatUserList.setTotal(jsonObject.getInt("total"));
		// wechatUserList.setCount(jsonObject.getInt("count"));
		// wechatUserList.setNextOpenId(jsonObject.getString("next_openid"));
		// JSONObject dataObject = (JSONObject) jsonObject.get("data");
		// wechatUserList.setOpenIdList(JSONArray.toList(dataObject.getJSONArray("openid"),
		// List.class));
		// } catch (JSONException e) {
		// wechatUserList = null;
		// int errorCode = jsonObject.getInt("errcode");
		// String errorMsg = jsonObject.getString("errmsg");
		// logger.error("获取关注者列表失败 errcode:{} errmsg:{}", errorCode, errorMsg);
		// }
		// }
		// return wechatUserList;
		if (null == jsonObject) {
			ErrorMsg errMsg = new ErrorMsg();
			errMsg.setErrcode("-1");
			errMsg.setErrmsg("server is busy");

			return JSONObject.fromObject(errMsg);
		}
		return jsonObject;
	}

}
