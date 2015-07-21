/**
 * 
 */
package com.manicure.keystone.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.manicure.base.controller.BaseController;
import com.manicure.keystone.service.impl.CoreService;

/**
 * @author Barrie
 *
 */
@Controller
@RequestMapping(value = "/api/keystone")
public class CoreController extends BaseController {

	@Resource
	CoreService coreService;

	@RequestMapping(value = "/core")
	public void connect(HttpServletRequest request, HttpServletResponse response) {
		String method = request.getMethod();
		logger.info(method);
		if ("GET".equals(method)) {
			try {
				coreService.doGet(request, response);
			} catch (Exception e) {
				logger.error(e.getMessage());
			}

		} else if ("POST".equals(method)) {
			try {
				coreService.doPost(request, response);
			} catch (Exception e) {
				logger.error(e.getMessage());
			}
		}

	}
}
