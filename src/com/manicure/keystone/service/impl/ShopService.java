/**
 * 
 */
package com.manicure.keystone.service.impl;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.manicure.base.service.BaseService;
import com.manicure.keystone.entity.ErrorMsg;
import com.manicure.keystone.entity.request.ShopReq;
import com.manicure.keystone.entity.request.ShopListReq;
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
		JSONObject jsonObject = coreService.httpsRequest(url, "POST", JSONObject.fromObject(shopListReq).toString());
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
		
		JSONObject jsonObject = coreService.httpsRequest(url, "POST", JSONObject.fromObject(shopReq).toString());
		if (null == jsonObject) {
			ErrorMsg errMsg = new ErrorMsg();
			errMsg.setErrcode("-1");
			errMsg.setErrmsg("server is busy");

			return JSONObject.fromObject(errMsg);
		}
		return jsonObject;
	}

}
