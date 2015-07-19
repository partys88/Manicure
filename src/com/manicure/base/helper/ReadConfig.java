/**
 * 
 */
package com.manicure.base.helper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import net.sf.json.JSONObject;

/**
 * @author Barrie
 *
 */
public class ReadConfig extends BaseUtil {
	public static JSONObject getJson(String fileName) throws IOException {
		String path = Thread.currentThread().getContextClassLoader()
				.getResource("/").getPath();
		path = "/" + path.substring(1, path.indexOf("classes")) + "conf/"
				+ fileName;
		FileInputStream fileInputStream = new FileInputStream(path);
		InputStreamReader inputStreamReader = new InputStreamReader(
				fileInputStream, "UTF-8");
		BufferedReader reader = new BufferedReader(inputStreamReader);
		String tempString = null;
		String laststr = "";
		while ((tempString = reader.readLine()) != null) {
			laststr += tempString;
		}
		JSONObject json = JSONObject.fromObject(laststr);
		return json;
	}

	public static String getProperty(String fileName, String name) {
		Properties p = new Properties();
		String result = "";
		try {
			String path = Thread.currentThread().getContextClassLoader()
					.getResource("/").getPath();
			path = "/" + path.substring(1, path.indexOf("classes")) + "conf/"
					+ fileName;
			p.load(new FileInputStream(path));
			result = p.getProperty(name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
