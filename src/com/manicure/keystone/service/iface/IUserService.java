/**
 * 
 */
package com.manicure.keystone.service.iface;

import com.manicure.keystone.entity.SNSUserInfo;

/**
 * @author Barrie
 *
 */
public interface IUserService {
	public SNSUserInfo getSNSUserInfo(String accessToken, String openId);
}
