/**
 * 
 */
package com.manicure.keystone.entity;

import com.manicure.base.entity.BaseEntity;

/**
 * @author Barrie
 *
 */
public class ErrorMsg extends BaseEntity{
	private String errCode;
	private String errMsg;

	/**
	 * @return the errCode
	 */
	public String getErrCode() {
		return errCode;
	}

	/**
	 * @param errCode
	 *            the errCode to set
	 */
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	/**
	 * @return the errMsg
	 */
	public String getErrMsg() {
		return errMsg;
	}

	/**
	 * @param errMsg
	 *            the errMsg to set
	 */
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	
}
