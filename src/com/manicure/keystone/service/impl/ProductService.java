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
import com.manicure.keystone.entity.request.product.ProductReq;
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

		ProductListReq request = new ProductListReq();
		request.setStatus(status);

		JSONObject response = HttpClientUtil.doHttpsPost(url, "POST", JSONObject.fromObject(request).toString());

		if (null == response) {
			ErrorMsg errMsg = new ErrorMsg();
			errMsg.setErrcode("-1");
			errMsg.setErrmsg("server is busy");

			return JSONObject.fromObject(errMsg);
		}

		return response;
	}

	public JSONObject getProduct(String accessToken, String productId) {
		String url = URL_PROGUCT_GET_DETAIL.replace("ACCESS_TOKEN", accessToken);

		ProductReq request = new ProductReq();
		request.setProduct_id(productId);

		JSONObject response = HttpClientUtil.doHttpsPost(url, "POST", JSONObject.fromObject(request).toString());

		if (null == response) {
			ErrorMsg errMsg = new ErrorMsg();
			errMsg.setErrcode("-1");
			errMsg.setErrmsg("server is busy");

			return JSONObject.fromObject(errMsg);
		}

		return response;
	}
}
