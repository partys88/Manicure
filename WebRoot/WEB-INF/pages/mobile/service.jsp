<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="meta/config.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<%@ include file="meta/meta.jsp"%>
<style type="text/css">
.ui-page {
	-webkit-backface-visibility: hidden;
}

.btnContainer {
	padding: 10px;
}

.mainContainer {
	margin-top: 50px;
}
</style>
<script type="text/javascript">
	$(document).bind("pageshow", function() {

		

		//alert();
	});
</script>

</head>
<body>
	<div data-role="page">
		<div data-role="header">
			<h2>服务方式</h2>
		</div>
		<!-- /header -->
		<div role="main" class="ui-content mainContainer">
			<div class="btnContainer">
				<a href="${ctx}/home" data-prefetch="true" data-ajax="false" data-transition="slidefade" class="ui-btn ui-shadow ui-corner-all show-page-loading-msg">到店服务</a>
			</div>
			<div class="btnContainer">
				<a href="${ctx}/home" data-prefetch="true" data-transition="slidefade" class="ui-btn ui-shadow ui-corner-all show-page-loading-msg">上门服务</a>
			</div>

		</div>
		<div data-role="footer" data-position="fixed">
			<h2>欢迎光临米兰美甲艺社</h2>
		</div>
		<!-- /footer -->
	</div>
</body>
</html>
