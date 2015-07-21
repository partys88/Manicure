/**
 * 
 */
package com.manicure.keystone.service.iface;

import net.sf.json.JSONObject;

/**
 * @author Barrie
 *
 */
public interface IUserService {
	public JSONObject getOauth2AccessToken(String appId, String appSecret, String code);

	public JSONObject refreshOauth2AccessToken(String appId, String refreshToken);

	public JSONObject getSNSUserInfo(String accessToken, String openId);

	public JSONObject getWeChatUserInfo(String accessToken, String openId);

	public JSONObject getWeChatUserList(String accessToken, String nextOpenId);

}
