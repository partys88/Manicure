/**
 * 
 */
package com.manicure.keystone.entity.shop;

import java.util.List;

import com.manicure.base.entity.BaseEntity;

/**
 * @author Barrie
 *
 */
public class ShopList extends BaseEntity {
	private int total_count;
	private List<Shop> shop_list;

	/**
	 * @return the total_count
	 */
	public int getTotal_count() {
		return total_count;
	}

	/**
	 * @param total_count
	 *            the total_count to set
	 */
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}

	/**
	 * @return the shop_list
	 */
	public List<Shop> getShop_list() {
		return shop_list;
	}

	/**
	 * @param shop_list
	 *            the shop_list to set
	 */
	public void setShop_list(List<Shop> shop_list) {
		this.shop_list = shop_list;
	}
}
