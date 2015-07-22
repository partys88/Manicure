<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="meta/config.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>米兰美甲艺社</title>
<%@ include file="meta/meta.jsp"%>
<script>
	// Pagecreate will fire for each of the pages in this demo
	// but we only need to bind once so we use "one()"
	$(document).one("pagecreate", ".service-page", function() {

		$("#camera_wrap_1").camera({
			thumbnails : true,
			playPause : false,
			//navigation: false,
			pauseOnClick : false,
		});

		alert();
	});

</script>
</head>
<body>
	<div data-role="page" id="service-page">
		<div role="main" class="ui-content" style="padding: 0px;">

			<div class="camera_wrap camera_azure_skin" id="camera_wrap_1">
				<div data-thumb="${ctx}/images/slides/thumbs/bridge.jpg" data-src="${ctx}/images/slides/bridge.jpg">
					<div class="camera_caption fadeFromBottom">
						<em>图1</em>
					</div>
				</div>
				<div data-thumb="${ctx}/images/slides/thumbs/leaf.jpg" data-src="${ctx}/images/slides/leaf.jpg">
					<div class="camera_caption fadeFromBottom">
						<em>图2</em>
					</div>
				</div>
				<div data-thumb="${ctx}/images/slides/thumbs/road.jpg" data-src="${ctx}/images/slides/road.jpg">
					<div class="camera_caption fadeFromBottom">
						<em>图3</em>
					</div>
				</div>
				<div data-thumb="${ctx}/images/slides/thumbs/sea.jpg" data-src="${ctx}/images/slides/sea.jpg">
					<div class="camera_caption fadeFromBottom">
						<em>图4</em>
					</div>
				</div>
				<div data-thumb="${ctx}/images/slides/thumbs/shelter.jpg" data-src="${ctx}/images/slides/shelter.jpg">
					<div class="camera_caption fadeFromBottom">
						<em>图5</em>
					</div>
				</div>
				<div data-thumb="${ctx}/images/slides/thumbs/tree.jpg" data-src="${ctx}/images/slides/tree.jpg">
					<div class="camera_caption fadeFromBottom">
						<em>图6</em>
					</div>
				</div>
			</div>
			<!-- #camera_wrap_1 -->

		</div>
		<div data-role="footer" data-id="footnavigate" data-position="fixed">
			<div data-role="navbar">
				<ul>
					<li><a href="tel://10086" data-icon="home" class="ui-btn-active" id="a">首页</a></li>
					<li><a data-icon="star">收藏</a></li>
					<li><a data-icon="shop">订单</a></li>
				</ul>
			</div>
			<!-- /navbar -->
		</div>
		<!-- /footer -->
	</div>
</body>
</html>
