/**
 * 
 */
package com.manicure.keystone.entity.request.shop;

import com.manicure.base.entity.BaseEntity;

/**
 * @author Barrie
 *
 */
public class ShopReq extends BaseEntity {
	private String poi_id;

	/**
	 * @return the poi_id
	 */
	public String getPoi_id() {
		return poi_id;
	}

	/**
	 * @param poi_id
	 *            the poi_id to set
	 */
	public void setPoi_id(String poi_id) {
		this.poi_id = poi_id;
	}
}
