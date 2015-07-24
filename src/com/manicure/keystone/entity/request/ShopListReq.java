/**
 * 
 */
package com.manicure.keystone.entity.request;

import com.manicure.base.entity.BaseEntity;

/**
 * @author Barrie
 *
 */
public class ShopListReq extends BaseEntity {
	private int begin;
	private int limit;

	/**
	 * @return the begin
	 */
	public int getBegin() {
		return begin;
	}

	/**
	 * @param begin
	 *            the begin to set
	 */
	public void setBegin(int begin) {
		this.begin = begin;
	}

	/**
	 * @return the limit
	 */
	public int getLimit() {
		return limit;
	}

	/**
	 * @param limit
	 *            the limit to set
	 */
	public void setLimit(int limit) {
		this.limit = limit;
	}

}
