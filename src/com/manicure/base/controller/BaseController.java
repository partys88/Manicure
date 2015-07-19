package com.manicure.base.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.manicure.base.helper.ConfigUtil;

/**
 * 
 * @author Barrie
 *
 * @param <T>
 */
public abstract class BaseController {

	private final String propertiesFile = "wechat.properties";
	// 第三方用户唯一凭证
	protected final String APP_ID = ConfigUtil.getProperty(propertiesFile, "appId");
	// 第三方用户唯一凭证密钥
	protected final String APP_SECRET = ConfigUtil.getProperty(propertiesFile, "appSecret");
	// logger
	protected Logger logger = LoggerFactory.getLogger(getClass());

}
