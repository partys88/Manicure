/**
 * 
 */
package com.manicure.base.helper;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Barrie
 *
 */
public class UrlUtil {
	public static String getServerUrl(HttpServletRequest request, String target) {
		String path = request.getContextPath();
		int port = request.getServerPort();
		String basePath = null;
		if (80 == port) {
			basePath = request.getScheme() + "://" + request.getServerName() + path;
		} else {
			basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
		}

		String url = basePath + target;
		return url;
	}
}
