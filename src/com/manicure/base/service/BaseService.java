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
	protected final String ACCESS_TOKEN_URL = ConfigUtil.getProperty(propertiesFile, "url.access.token");
	// 菜单创建（POST） 限100（次/天）
	protected final String MENU_CREATE_URL = ConfigUtil.getProperty(propertiesFile, "url.menu.create");
	// 获取用户信息
	protected final String SNS_USER_GET_INFO_URL = ConfigUtil.getProperty(propertiesFile, "url.sns.user.get.info");

	protected final String SNS_OAUTH2_GET_TOKEN_URL = ConfigUtil.getProperty(propertiesFile, "url.sns.oauth2.get.token");

	protected final String SNS_OAUTH2_REFRESH_TOKEN_URL = ConfigUtil.getProperty(propertiesFile, "url.sns.oauth2.refresh.token");

	protected final String USER_GET_INFO_URL = ConfigUtil.getProperty(propertiesFile, "url.user.get.info");
	// logger
	protected Logger logger = LoggerFactory.getLogger(getClass());

}
