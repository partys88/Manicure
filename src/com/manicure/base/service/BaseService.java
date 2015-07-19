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
	// 与接口配置信息中的Token要一致
	protected final String TOKEN = ConfigUtil.getProperty(propertiesFile, "token");
	// 获取access_token的接口地址（GET） 限200（次/天）
	protected final String ACCESS_TOKEN_URL = ConfigUtil.getProperty(propertiesFile, "url.access.token");
	// 菜单创建（POST） 限100（次/天）
	protected final String MENU_CREATE_URL = ConfigUtil.getProperty(propertiesFile, "url.menu.create");
	// logger
	protected Logger logger = LoggerFactory.getLogger(getClass());

}
