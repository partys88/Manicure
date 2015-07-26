/**
 * 
 */
package com.manicure.keystone.entity.request.material;

import com.manicure.base.entity.BaseEntity;

/**
 * @author Barrie
 *
 */
public class MaterialReq extends BaseEntity{
	private String media_id;

	/**
	 * @return the media_id
	 */
	public String getMedia_id() {
		return media_id;
	}

	/**
	 * @param media_id
	 *            the media_id to set
	 */
	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

}
