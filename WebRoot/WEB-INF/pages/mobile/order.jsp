<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="meta/config.jsp"%>
<!DOCTYPE html>
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
	<div data-role="page" id="order-page">
		<div data-role="header">
			<h2>我的米宝</h2>
		</div>
		<div role="main"></div>
		<div data-role="footer" data-position="fixed">
			<div data-role="navbar">
				<ul>
					<li><a id="nav_bar_btn_home" href="${ctx}/home" data-icon="home" data-ajax="false">首页</a></li>
					<li><a id="nav_bar_btn_favs" href="#" data-icon="star" data-ajax="false">收藏</a></li>
					<li><a id="nav_bar_btn_order" href="#" data-icon="shop" class="ui-btn-active" data-ajax="false">订单</a></li>
				</ul>
			</div>
			<!-- /navbar -->
		</div>
		<!-- /footer -->
	</div>
</body>
</html>