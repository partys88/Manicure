<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="meta/config.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<%@ include file="meta/meta.jsp"%>
<style type="text/css">
.btnContainer {
	padding: 10px;
}

.mainContainer {
	margin-top: 50px;
}
</style>

</head>
<body>
	<div data-role="page">
		<div data-role="header">
			<h2>服务方式</h2>
		</div>
		<!-- /header -->
		<div role="main" class="ui-content mainContainer">
			<div class="btnContainer">
				<a href="${ctx}/mobile/home" class="ui-btn ui-btn-d ui-shadow ui-corner-all">到店服务</a>
			</div>
			<div class="btnContainer">
				<a href="${ctx}/mobile/home" class="ui-btn ui-btn-d ui-shadow ui-corner-all">上门服务</a>
			</div>

		</div>
		<div data-role="footer" data-position="fixed">
			<h2>欢迎光临米兰美甲艺社</h2>
		</div>
		<!-- /footer -->
	</div>
</body>
</html>
