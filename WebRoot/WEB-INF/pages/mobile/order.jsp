<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="meta/config.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>Home</title>
<%@ include file="meta/meta.jsp"%>
<style type="text/css">
.footer {
	position: fixed;
	bottom: 0px;
	width: 100%;
}
</style>
</head>
<body>
	<div data-role="page">
		<div data-role="footer" class="footer">
			<div data-role="navbar">
				<ul>
					<li><a href="home" data-icon="home">首页</a></li>
					<li><a href="home" data-icon="star">收藏</a></li>
					<li><a href="order" data-icon="shop" class="ui-btn-active">订单</a></li>
				</ul>
			</div>
			<!-- /navbar -->
		</div>
		<!-- /footer -->
	</div>
</body>
</html>