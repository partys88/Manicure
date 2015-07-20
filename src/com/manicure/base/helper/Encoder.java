/**
 * 
 */
package com.manicure.base.helper;

import java.io.UnsupportedEncodingException;

/**
 * @author Barrie
 *
 */
public class Encoder {
	/**
	 * URL编码（utf-8）
	 * 
	 * @param source
	 * @return
	 */
	public static String urlEncodeUTF8(String source) {
		String result = source;
		try {
			result = java.net.URLEncoder.encode(source, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
}
