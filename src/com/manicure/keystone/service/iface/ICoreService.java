/**
 * 
 */
package com.manicure.keystone.service.iface;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Barrie
 *
 */
public interface ICoreService {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException;

}