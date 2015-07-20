/**
 * 
 */
package com.manicure.keystone.service.impl;

import java.io.IOException;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.manicure.base.service.BaseService;
import com.manicure.keystone.service.iface.ICoreService;

/**
 * @author Barrie
 *
 */
@Service
public class MenuService extends BaseService {

	@Resource
	ICoreService coreService;

	/**
	 * 创建菜单
	 * 
	 * @param menu
	 *            菜单实例
	 * @param accessToken
	 *            有效的access_token
	 * @return 0表示成功，其他值表示失败
	 * @throws IOException
	 */
	public int create(String accessToken, JSONObject json) {
		int result = 0;

		// 拼装创建菜单的url
		String url = MENU_CREATE_URL.replace("ACCESS_TOKEN", accessToken);
		// 将菜单对象转换成json字符串
		String jsonMenu = json.toString();
		// 调用接口创建菜单
		JSONObject jsonObject = coreService.httpsRequest(url, "POST", jsonMenu);

		if (null != jsonObject) {
			if (0 != jsonObject.getInt("errcode")) {
				result = jsonObject.getInt("errcode");
				logger.error("创建菜单失败 errcode:{} errmsg:{}", jsonObject.getInt("errcode"), jsonObject.getString("errmsg"));
			}
		}

		return result;
	}
}