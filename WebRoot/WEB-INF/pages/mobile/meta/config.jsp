<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/" + "mobile";
	application.setAttribute("ctx", basePath);
	response.setContentType("text/html;charset=UTF-8");
%>

