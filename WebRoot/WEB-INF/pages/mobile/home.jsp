<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="meta/config.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>米兰美甲艺社</title>
<%@ include file="meta/meta.jsp"%>
<link rel="stylesheet" type="text/css" href="${ctx}/css/slider-pro.min.css" media="screen" />
<script type="text/javascript" src="${ctx}/js/jquery.sliderPro.min.js"></script>
<script type="text/javascript">
	$(document).on("pagecontainerchange", function() {

	});
</script>
</head>
<body>
	<div data-role="page" id="home-page" data-title="首页">
		<div data-role="header">
			<a data-rel="back" class="ui-btn ui-btn-left ui-alt-icon ui-nodisc-icon ui-corner-all ui-btn-icon-notext ui-icon-carat-l">后退</a>
			<h2>米兰美甲艺社</h2>
		</div>
		<div role="main" id="main">
			<div class="ui-grid-solo">
				<div id="home-slider" class="slider-pro">
					<div class="sp-slides">
						<div class="sp-slide">
							<img class="sp-image" src="${ctx}/css/images/blank.gif" data-src="${ctx}/images/slides/bridge.jpg" />

						</div>

						<div class="sp-slide">
							<img class="sp-image" src="${ctx}/css/images/blank.gif" data-src="${ctx}/images/slides/leaf.jpg" />

						</div>

						<div class="sp-slide">
							<img class="sp-image" src="${ctx}/css/images/blank.gif" data-src="${ctx}/images/slides/road.jpg" />

						</div>

						<div class="sp-slide">
							<img class="sp-image" src="${ctx}/css/images/blank.gif" data-src="${ctx}/images/slides/sea.jpg" />

						</div>

					</div>


				</div>
			</div>
			<div class="ui-grid-b" style="font-size: 0.8em;text-align: center;">
				<div class="ui-block-a">
					<a href="${ctx}/list" data-theme="b" data-prefetch="true" data-role="button"  data-icon="check" data-iconpos="top">美甲</a>
				</div>
				<div class="ui-block-b">
					<a href="${ctx}/list" data-theme="c" data-prefetch="true" data-role="button" data-icon="cloud" data-iconpos="top">美足</a>
				</div>
				<div class="ui-block-c">
					<a href="${ctx}/list" data-theme="d" data-prefetch="true" data-role="button" data-icon="clock" data-iconpos="top">美睫</a>
				</div>
			</div>
			<div class="ui-grid-a" style="font-size: 0.8em;text-align: center;">
				<div class="ui-block-a">
					<a href="${ctx}/list" data-theme="e" data-prefetch="true" data-role="button"  data-icon="edit" data-iconpos="top">化妆</a>
				</div>
				<div class="ui-block-b">
					<a href="${ctx}/list" data-theme="f" data-prefetch="true" data-role="button" data-icon="eye" data-iconpos="top">护理</a>
				</div>
			</div>
			<div class="ui-grid-solo" style="margin-top: 10px;margin-bottom: 10px;">
				<ul data-role="listview" >
					<li><a> <img src="${ctx}/_assets/img/apple.png" class="ui-li-thumb">
							<h2>低价热卖</h2>
							<p>最新的低价商品</p>

					</a></li>
					<li><a> <img src="${ctx}/_assets/img/blackberry_10.png" class="ui-li-thumb">
							<h2>三好学员</h2>
							<p>本店的优秀学员展示</p>

					</a></li>

				</ul>
			</div>
			<!-- /content -->
		</div>
		<!-- #camera_wrap_1 -->
		<%@ include file="meta/footer.jsp"%>
	</div>
	</div>
</body>
</html>
