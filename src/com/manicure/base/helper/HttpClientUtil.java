/**
 * 
 */
package com.manicure.base.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * @author Barrie
 *
 */
public class HttpClientUtil {
	public static String doHttpPost(String url, Map<String, String> params, String charset) {
		try {  
	        HttpPost httpPost = new HttpPost(url);  
	        HttpClient client = new DefaultHttpClient();  
	        List<NameValuePair> valuePairs = new ArrayList<NameValuePair>(params.size());  
	        for(Map.Entry<String, String> entry : params.entrySet()){  
	            NameValuePair nameValuePair = new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue()));  
	            valuePairs.add(nameValuePair);  
	        }  
	        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(valuePairs, charset);  
	        httpPost.setEntity(formEntity);  
	        HttpResponse resp = client.execute(httpPost);  
	          
	        HttpEntity entity = resp.getEntity();  
	        String respContent = EntityUtils.toString(entity , charset).trim();  
	        httpPost.abort();  
	        client.getConnectionManager().shutdown();  
	  
	        return respContent;  
	          
	    } catch (Exception e) {  
	        e.printStackTrace();  
	        return null;  
	    }  
	}  


	public static String get(String url, String param, String charset) {
		try {  
            HttpGet httpGet = new HttpGet(url);  
            HttpClient client = new DefaultHttpClient();  
            HttpResponse resp = client.execute(httpGet);  
              
            HttpEntity entity = resp.getEntity();  
            String respContent = EntityUtils.toString(entity , charset).trim();  
            httpGet.abort();  
            client.getConnectionManager().shutdown();  
  
            return respContent;  
              
        } catch (Exception e) {  
            e.printStackTrace();  
            return null;  
        }  
	}

	public static String doHttpsPost(String url, Map<String, String> map, String charset) {
		HttpClient httpClient = null;
		HttpPost httpPost = null;
		String result = null;
		try {
			httpClient = new SSLClient();
			httpPost = new HttpPost(url);
			// 设置参数
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			if (null != map) {
				Iterator iterator = map.entrySet().iterator();
				while (iterator.hasNext()) {
					Entry<String, String> elem = (Entry<String, String>) iterator.next();
					list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
				}
			}
			if (list.size() > 0) {
				UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
				httpPost.setEntity(entity);
			}
			HttpResponse response = httpClient.execute(httpPost);
			if (response != null) {
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					result = EntityUtils.toString(resEntity, charset);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {
		String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=KAniRZdfXKPd4XBk5uftl6_eqTyibwQ8KbxOl0dhKPU7Xrey4paU24QMkqxvCa93leqF43Qg_orM8SuCbQMlNmEJ1IV72w3PFUagwT4tUSY&openid=oxgY4xIDiXXO-CHEhUYZeRD44C7M";
		String charset = "utf-8";
		String httpOrgCreateTest = url;
		Map<String, String> createMap = new HashMap<String, String>();
		createMap.put("authuser", "*****");
		createMap.put("authpass", "*****");
		createMap.put("orgkey", "****");
		createMap.put("orgname", "****");
		String httpOrgCreateTestRtn = HttpClientUtil.doHttpsPost(url, null, charset);
		System.out.println("result:" + httpOrgCreateTestRtn);
	}
}
