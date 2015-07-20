package com.manicure.base.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.manicure.base.helper.ConfigUtil;

/**
 * 
 * @author Barrie
 *
 */
public class BaseService {

	private final String propertiesFile = "wechat.properties";
	// 第三方用户唯一凭证
	protected final String APP_ID = ConfigUtil.getProperty(propertiesFile, "appId");
	// 第三方用户唯一凭证密钥
	protected final String APP_SECRET = ConfigUtil.getProperty(propertiesFile, "appSecret");
	// 与接口配置信息中的Token要一致
	protected final String TOKEN = ConfigUtil.getProperty(propertiesFile, "token");
	// 获取access_token的接口地址（GET） 限200（次/天）
	protected final String URL_GET_ACCESS_TOKEN = ConfigUtil.getProperty(propertiesFile, "url.access.token");
	// 菜单创建（POST） 限100（次/天）
	protected final String URL_MENU_CREATE = ConfigUtil.getProperty(propertiesFile, "url.menu.create");

	protected final String URL_SNS_OAUTH2_GET_TOKEN = ConfigUtil.getProperty(propertiesFile, "url.sns.oauth2.get.token");

	protected final String URL_SNS_OAUTH2_REFRESH_TOKEN = ConfigUtil.getProperty(propertiesFile, "url.sns.oauth2.refresh.token");
	// 获取用户信息
	protected final String URL_USER_GET_SNS_INFO = ConfigUtil.getProperty(propertiesFile, "url.user.get.sns.info");

	protected final String URL_USER_GET_INFO = ConfigUtil.getProperty(propertiesFile, "url.user.get.info");

	protected final String URL_USER_GET_LIST = ConfigUtil.getProperty(propertiesFile, "url.user.get.list");

	// logger
	protected Logger logger = LoggerFactory.getLogger(getClass());

}
