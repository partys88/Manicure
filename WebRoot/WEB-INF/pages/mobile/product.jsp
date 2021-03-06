<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="meta/config.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>Home</title>
<%@ include file="meta/meta.jsp"%>
<SCRIPT type="text/javascript">
	//var _pid = "${pid}";
</SCRIPT>
</head>
<body>
	<div data-role="page" id="product-page">
		<div data-role="header">
			<a data-rel="back" class="ui-btn ui-btn-left ui-alt-icon ui-nodisc-icon ui-corner-all ui-btn-icon-notext ui-icon-carat-l">后退</a>
			<h2 id="product-header">无此商品</h2>
		</div>
		<div role="main">
			<div class="ui-grid-solo">
				<img id="product-main-img" src="${ctx}/mobile/images/slides/bridge.jpg" style="width: 100%;height: 200px;">
			</div>
			<div style="padding: 20px;">
				<div class="ui-grid-a">
					<div class="ui-block-a" style="text-align: left;">
						<h2 style="color:#ff7070;margin-top:5px; margin-bottom: 5px" id="product-price">¥0</h2>
						<p style="font-size: 0.6em;">
							店面价：
							<del id="product-ori-price">¥0</del>
						</p>
					</div>
					<div class="ui-block-b" style="text-align: right;">
						<p style="color:orange;">0人做过</p>
					</div>
				</div>
				<div class="ui-grid-solo">
					<p style="font-size: 0.8em;" id="product-description">商品可能已下架</p>
				</div>
				<hr />
				<div class="ui-grid-a" style="text-align: left;">
					<div class="ui-block-a">
						<p style="font-size: 0.8em;">
							耗时：<em id="product-cost">0分钟</em>
						</p>
					</div>
					<div class="ui-block-b">
						<p style="font-size: 0.8em;">
							保持：<em id="product-last">0天</em>
						</p>
					</div>
				</div>
			</div>
			<div class="ui-grid-solo" style="padding-left: 10px;padding-right: 10px;padding-bottom: 10px;">
				<ul data-role="listview" data-inset="true">
					<li><a href="#"> <img src="${ctx}/mobile/_assets/img/blackberry_10.png">
							<h2>Demo</h2>
							<p>Demo</p>
							<p class="ui-li-aside">Demo</p>
					</a></li>
					<li><a href="#"> <img src="${ctx}/mobile/_assets/img/blackberry_10.png">
							<h2>Demo</h2>
							<p>Demo</p>
							<p class="ui-li-aside">Demo</p>
					</a></li>
					<li><a href="#"> <img src="${ctx}/mobile/_assets/img/blackberry_10.png">
							<h2>Demo</h2>
							<p>Demo</p>
							<p class="ui-li-aside">Demo</p>
					</a></li>
				</ul>
			</div>
			<div class="ui-grid-solo" style="padding-left: 10px;padding-right: 10px;padding-bottom: 10px;">
				<a id="product-btn-pay" href="#" class="ui-btn ui-btn-d ui-shadow ui-corner-all">预约</a>
			</div>
		</div>
		<%@ include file="meta/footer.jsp"%>
		<!-- /footer -->
	</div>
</body>
</html>