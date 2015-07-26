/**
 * 
 */
package com.manicure.base.helper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

import net.sf.json.JSONObject;

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
	public static String doPost(String url, Map<String, String> params, String charset) {
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


	public static String doGet(String url, String param, String charset) {
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

	public static JSONObject httpsRequest(String requestUrl, String requestMethod, String outputStr) {
		JSONObject jsonObject = null;
		try {
			// 创建SSLContext对象，并使用我们指定的信任管理器初始化
			TrustManager[] tm = { new CustomX509TrustManager() };
			SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
			sslContext.init(null, tm, new java.security.SecureRandom());
			// 从上述SSLContext对象中得到SSLSocketFactory对象
			SSLSocketFactory ssf = sslContext.getSocketFactory();

			URL url = new URL(requestUrl);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setSSLSocketFactory(ssf);
			
			conn.setDoOutput(true);
			conn.setDoInput(true);
			conn.setUseCaches(false);
			// 设置请求方式（GET/POST）
			conn.setRequestMethod(requestMethod);

			// 当outputStr不为null时向输出流写数据
			if (null != outputStr) {
				OutputStream outputStream = conn.getOutputStream();
				// 注意编码格式
				outputStream.write(outputStr.getBytes("UTF-8"));
				outputStream.close();
			}

			// 从输入流读取返回内容
			InputStream inputStream = conn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String str = null;
			StringBuffer buffer = new StringBuffer();
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}

			// 释放资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			inputStream = null;
			conn.disconnect();
			jsonObject = JSONObject.fromObject(buffer.toString());
		} catch (ConnectException ce) {
			//logger.error("连接超时：{}", ce);
		} catch (Exception e) {
			//logger.error("https请求异常：{}", e);
		}
		return jsonObject;
	}

	public static void main(String[] args) {
		String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=hB0x_KaeNdaS8XzxuarxcbLUR-filDG--JOhIMPGjpm8J9Ar0nt2EPO6Ij_ghok6riQfylNVr9jnMw8gKoh3ln1qRll8rj6GugfWL1NDnQw&openid=oxgY4xIDiXXO-CHEhUYZeRD44C7M";
		String charset = "utf-8";
		String httpOrgCreateTest = url;
		Map<String, String> createMap = new HashMap<String, String>();
		createMap.put("authuser", "*****");
		createMap.put("authpass", "*****");
		createMap.put("orgkey", "****");
		createMap.put("orgname", "****");
		String httpOrgCreateTestRtn = HttpClientUtil.doHttpsPost(url, null, charset);
		System.out.println("result:" + httpOrgCreateTestRtn);
		
		JSONObject jsonObject = HttpClientUtil.httpsRequest(url, "POST", null);
		System.out.println("result:" + jsonObject);
	}
}
