package com.manicure.base.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.manicure.base.helper.ReadConfig;

/**
 * 
 * @author Barrie
 *
 * @param <T>
 */
public abstract class BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	protected ReadConfig config;

}
