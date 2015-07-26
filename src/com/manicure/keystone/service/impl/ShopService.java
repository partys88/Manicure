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
import com.manicure.keystone.entity.request.shop.ShopListReq;
import com.manicure.keystone.entity.request.shop.ShopReq;
import com.manicure.keystone.service.iface.ICoreService;
import com.manicure.keystone.service.iface.IShopService;

/**
 * @author Barrie
 *
 */
@Service
public class ShopService extends BaseService implements IShopService {
	@Resource
	ICoreService coreService;

	/**
	 * 
	 */
	public JSONObject getShopList(String accessToken, int begin, int limit) {
		String url = URL_SHOP_GET_LIST.replace("TOKEN", accessToken);
		ShopListReq shopListReq = new ShopListReq();
		shopListReq.setBegin(begin);
		shopListReq.setLimit(limit);
		String response = HttpClientUtil.doHttpsPost(url, null, "UTF-8");
		JSONObject jsonObject=JSONObject.fromObject(response);
		
		if (null == jsonObject) {
			ErrorMsg errMsg = new ErrorMsg();
			errMsg.setErrcode("-1");
			errMsg.setErrmsg("server is busy");

			return JSONObject.fromObject(errMsg);
		}
		return jsonObject;
	}

	/**
	 * 
	 */
	public JSONObject getShop(String accessToken, String poi_id) {
		String url = URL_SHOP_GET_DETAIL.replace("TOKEN", accessToken);
		ShopReq shopReq = new ShopReq();
		shopReq.setPoi_id(poi_id);

		String response = HttpClientUtil.doHttpsPost(url, null, "UTF-8");
		JSONObject jsonObject=JSONObject.fromObject(response);
		
		if (null == jsonObject) {
			ErrorMsg errMsg = new ErrorMsg();
			errMsg.setErrcode("-1");
			errMsg.setErrmsg("server is busy");

			return JSONObject.fromObject(errMsg);
		}
		return jsonObject;
	}

}
