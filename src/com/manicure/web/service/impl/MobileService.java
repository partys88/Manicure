/**
 * 
 */
package com.manicure.web.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.manicure.base.helper.HttpClientUtil;
import com.manicure.base.service.BaseService;
import com.manicure.keystone.entity.user.WeChatUserInfo;
import com.manicure.web.service.iface.IMobileService;

/**
 * @author Barrie
 *
 */
@Service
public class MobileService extends BaseService implements IMobileService {
	public void setUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		WeChatUserInfo userInfo = new WeChatUserInfo();

		String code = request.getParameter("code");
		String path = request.getContextPath();
		int port = request.getServerPort();
		String basePath = null;
		if (80 == port) {
			basePath = request.getScheme() + "://" + request.getServerName() + path;
		} else {
			basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
		}

		String url = basePath + "/api/keystone/user/sns/oauth";
		Map<String, String> params = new HashMap();
		params.put("code", code);
		String resp = HttpClientUtil.doPost(url, params, "UTF-8");
		if (null == resp) {
			logger.error("fail to post");
		}
		JSONObject jUserInfo = JSONObject.fromObject(resp);
		if (!jUserInfo.containsKey("errcode")) {
			userInfo = (WeChatUserInfo) JSONObject.toBean(jUserInfo, WeChatUserInfo.class);

		} else {
			logger.error(jUserInfo.toString());
		}

		WeChatUserInfo currentUser = (WeChatUserInfo) session.getAttribute("user");
		if (null == currentUser || null == currentUser.getOpenid()) {
			session.setAttribute("user", userInfo);
		}
		
	}
}
