<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="meta/config.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>Home</title>
<%@ include file="meta/meta.jsp"%>


<script type="text/javascript">
	$(document).on("pagecontainerchange", function() {
		
	});
</script>
</head>
<body>
	<div data-role="page" id="order-page" data-title="订单">
		<div data-role="header">
			<a data-rel="back" class="ui-btn ui-btn-left ui-alt-icon ui-nodisc-icon ui-corner-all ui-btn-icon-notext ui-icon-carat-l">后退</a>
			<h2>我的米宝</h2>
		</div>
		<div role="main">

			<a href="${ctx}/list" class="ui-btn ui-shadow ui-corner-all">上门服务</a>
			
		</div>
		<%@ include file="meta/footer.jsp"%>
		<!-- /footer -->
	</div>
</body>
</html>