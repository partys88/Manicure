/**
 * 
 */
package com.manicure.keystone.entity.request.product;

import com.manicure.base.entity.BaseEntity;

/**
 * @author Barrie
 *
 */
public class ProductListReq extends BaseEntity {
	private int status;

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}
}
