/**
 * 
 */
package com.manicure.keystone.service.iface;

import net.sf.json.JSONObject;

/**
 * @author Barrie
 *
 */
public interface IProductService {
	public JSONObject getProductList(String accessToken, int status);
}
