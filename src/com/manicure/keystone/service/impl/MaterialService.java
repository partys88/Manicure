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
	 * 
	 */
	public JSONObject getMaterialList(String accessToken) {

		String url = URL_MATERIAL_GET_LIST.replace("ACCESS_TOKEN", accessToken);

		MaterialListReq request = new MaterialListReq();

		request.setType(MaterialListReq.TYPE_NEWS);
		request.setOffset(0);
		request.setCount(20);
		String response = HttpClientUtil.doHttpsPost(url, null, "UTF-8");
		JSONObject jsonObject=JSONObject.fromObject(response);
		
		if(null==jsonObject){
			ErrorMsg errMsg = new ErrorMsg();
			errMsg.setErrcode("-1");
			errMsg.setErrmsg("server is busy");
			
			return JSONObject.fromObject(errMsg);
		}
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

		MaterialReq request = new MaterialReq();

		request.setMedia_id(mediaId);

		String response = HttpClientUtil.doHttpsPost(url, null, "UTF-8");
		JSONObject jsonObject=JSONObject.fromObject(response);
		
		if(null==jsonObject){
			ErrorMsg errMsg = new ErrorMsg();
			errMsg.setErrcode("-1");
			errMsg.setErrmsg("server is busy");
			
			return JSONObject.fromObject(errMsg);
		}
		return jsonObject;
	}
}
