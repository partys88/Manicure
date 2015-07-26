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
import com.manicure.keystone.entity.request.material.MaterialListReq;
import com.manicure.keystone.entity.request.material.MaterialReq;
import com.manicure.keystone.service.iface.ICoreService;
import com.manicure.keystone.service.iface.IMaterialService;

/**
 * @author Barrie
 *
 */
@Service
public class MaterialService extends BaseService implements IMaterialService {
	@Resource
	ICoreService coreService;

	/**
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * 
	 */
	public JSONObject getMaterialList(String accessToken) {

		String url = URL_MATERIAL_GET_LIST.replace("ACCESS_TOKEN", accessToken);

		MaterialListReq request = new MaterialListReq();
		request.setType(MaterialListReq.TYPE_NEWS);
		request.setCount(20);
		request.setOffset(0);

		JSONObject response = HttpClientUtil.doHttpsPost(url, "POST", JSONObject.fromObject(request).toString());

		if (null == response) {
			ErrorMsg errMsg = new ErrorMsg();
			errMsg.setErrcode("-1");
			errMsg.setErrmsg("server is busy");

			return JSONObject.fromObject(errMsg);
		}
		return response;
	}

	/**
	 * 
	 * @param accessToken
	 * @param mediaId
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public JSONObject getMaterial(String accessToken, String mediaId) {

		String url = URL_MATERIAL_GET_DETAIL.replace("ACCESS_TOKEN", accessToken);

		MaterialReq request = new MaterialReq();
		request.setMedia_id(mediaId);
		
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
