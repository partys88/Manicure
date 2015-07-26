<%@ page import="com.manicure.keystone.entity.user.WeChatUserInfo" language="java"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/" + "mobile";
	application.setAttribute("ctx", basePath);
	response.setContentType("text/html;charset=UTF-8");
	HttpSession s = request.getSession(); 
	WeChatUserInfo u = (WeChatUserInfo)s.getAttribute("user");
%>

