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
import com.manicure.keystone.entity.request.product.ProductListReq;
import com.manicure.keystone.service.iface.ICoreService;
import com.manicure.keystone.service.iface.IProductService;

/**
 * @author Barrie
 *
 */
@Service
public class ProductService extends BaseService implements IProductService {
	@Resource
	ICoreService coreService;
	protected final int ALL = 0;
	protected final int ON_SHELVES = 1;
	protected final int OFF_SHELVES = 2;

	/**
	 * 
	 */
	public JSONObject getProductList(String accessToken, int status) {
		String url = URL_PROGUCT_GET_LIST.replace("ACCESS_TOKEN", accessToken);
		ProductListReq productListReq = new ProductListReq();
		productListReq.setStatus(status);
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
