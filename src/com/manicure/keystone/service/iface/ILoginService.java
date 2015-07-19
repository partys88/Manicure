/**
 * 
 */
package com.manicure.keystone.service.iface;

/**
 * @author Barrie
 *
 */
public interface ILoginService {
	public boolean checkSignature(String token, String signature,
			String timestamp, String nonce);

}
