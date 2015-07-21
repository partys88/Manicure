/**
 * 
 */
package com.manicure.keystone.service.impl;

import javax.annotation.Resource;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;

import com.manicure.base.service.BaseService;
import com.manicure.keystone.entity.material.GetMaterialListReq;
import com.manicure.keystone.entity.material.GetMaterialReq;
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
	 * 
	 */
	public JSONObject getMaterialList(String accessToken) {

		String url = URL_MATERIAL_GET_LIST.replace("ACCESS_TOKEN", accessToken);

		GetMaterialListReq request = new GetMaterialListReq();

		request.setType(GetMaterialListReq.TYPE_NEWS);
		request.setOffset(0);
		request.setCount(20);
		JSONObject jsonObject = coreService.httpsRequest(url, "POST", JSONObject.fromObject(request).toString());

		return jsonObject;
	}

	/**
	 * 
	 * @param accessToken
	 * @param mediaId
	 * @return
	 */
	public JSONObject getMaterial(String accessToken, String mediaId) {

		String url = URL_MATERIAL_GET_DETAIL.replace("ACCESS_TOKEN", accessToken);

		GetMaterialReq request = new GetMaterialReq();

		request.setMedia_id(mediaId);

		JSONObject jsonObject = coreService.httpsRequest(url, "POST", JSONObject.fromObject(request).toString());

		return jsonObject;
	}
}