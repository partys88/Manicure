<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="meta/config.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>米兰美甲艺社</title>
<%@ include file="meta/meta.jsp"%>
</head>
<body>
	<div data-role="page" id="home-page">
		<div data-role="header">
			<h2>米兰美甲艺社</h2>
		</div>
		<div role="main" id="main">
			<div class="ui-grid-solo">
				<div class="camera_wrap camera_azure_skin " id="camera_wrap_1">
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
			</div>
			<div class="ui-grid-b">
				<div class="ui-block-a">
					<a href="${ctx}/list" data-theme="b" data-ajax="false" data-role="button">美甲</a>
				</div>
				<div class="ui-block-b">
					<a href="${ctx}/list" data-theme="c" data-ajax="false" data-role="button">美足</a>
				</div>
				<div class="ui-block-c">
					<a href="${ctx}/list" data-theme="d" data-ajax="false" data-role="button">美婕</a>
				</div>
			</div>
			<div class="ui-grid-a">
				<div class="ui-block-a">
					<a href="${ctx}/list" data-theme="e" data-ajax="false" data-role="button">化妆</a>
				</div>
				<div class="ui-block-b">
					<a href="${ctx}/list" data-theme="f" data-ajax="false" data-role="button">护理</a>
				</div>
			</div>
			<div class="ui-grid-solo" style="margin-top: 10px;">
				<ul data-role="listview" data-inset="true">
					<li><a > <img src="${ctx}/images/_assets/img/apple.png" class="ui-li-thumb">
							<h2>低价热卖</h2>
							<p>最新的低价商品</p>
							
					</a></li>
					<li><a > <img src="${ctx}/images/_assets/img/blackberry_10.png" class="ui-li-thumb">
							<h2>三号学员</h2>
							<p>本店的优秀学员展示</p>
							
					</a></li>

				</ul>
			</div>
			<!-- /content -->
		</div>
		<!-- #camera_wrap_1 -->
		<div data-role="footer" data-position="fixed">
			<div data-role="navbar">
				<ul>
					<li><a id="nav_bar_btn_home"  data-icon="home" class="ui-btn-active" data-ajax="false">首页</a></li>
					<li><a id="nav_bar_btn_favs"  data-icon="star" data-ajax="false">收藏</a></li>
					<li><a id="nav_bar_btn_order" href="${ctx}/order" data-icon="shop" data-ajax="false">订单</a></li>
				</ul>
			</div>
			<!-- /navbar -->
		</div>
	</div>
	</div>
</body>
</html>
