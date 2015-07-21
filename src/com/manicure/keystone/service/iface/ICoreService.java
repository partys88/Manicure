/**
 * 
 */
package com.manicure.keystone.service.iface;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.manicure.keystone.entity.WeChatAccessToken;

/**
 * @author Barrie
 *
 */
public interface ICoreService {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	public JSONObject httpsRequest(String requestUrl, String requestMethod,
			String outputStr);

	public JSONObject getAccessToken(String appid, String appsecret);
}
