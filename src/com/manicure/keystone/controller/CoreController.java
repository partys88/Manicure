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
import com.manicure.keystone.service.iface.ICoreService;

/**
 * @author Barrie
 *
 */
@Controller
@RequestMapping(value = "/api")
public class CoreController extends BaseController {
	@Resource
	ICoreService coreService;

	@RequestMapping(value = "/core")
	public void connect(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();
		logger.info(method);
		if ("GET".equals(method)) {
			logger.info(request.getParameter("signature"));
			coreService.doGet(request, response);

		} else if ("POST".equals(method)) {
			logger.info(request.getInputStream().toString());
			coreService.doPost(request, response);
		}

	}
}
