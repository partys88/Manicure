<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="meta/config.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>米宝服务</title>
<%@ include file="meta/meta.jsp"%>
<style type="text/css">
.typebtn {
	padding-left: 10px;
	padding-right: 10px;
}
</style>
</head>
<body>
	<div data-role="page" id="list-page">
		<div data-role="header">
			<h2>米宝服务</h2>
		</div>

		<div role="main" class="ui-content">
			<div class="ui-grid-b" style="font-size: 0.8em;text-align: center;">
				<div class="ui-block-a typebtn">
					<a data-theme="b" data-ajax="false" data-role="button" data-icon="check" data-iconpos="top">美甲</a>
				</div>
				<div class="ui-block-b typebtn">
					<a data-theme="c" data-ajax="false" data-role="button" data-icon="cloud" data-iconpos="top">美足</a>
				</div>
				<div class="ui-block-c typebtn">
					<a data-theme="d" data-ajax="false" data-role="button" data-icon="clock" data-iconpos="top">美婕</a>
				</div>
			</div>
			<div class="ui-grid-a" style="font-size: 0.8em;text-align: center;">
				<div class="ui-block-a typebtn">
					<a data-theme="e" data-ajax="false" data-role="button" data-icon="edit" data-iconpos="top">化妆</a>
				</div>
				<div class="ui-block-b typebtn">
					<a data-theme="f" data-ajax="false" data-role="button" data-icon="eye" data-iconpos="top">护理</a>
				</div>
			</div>
			<form style="text-align: center;" id="subtype1">
				<fieldset data-role="controlgroup" data-type="horizontal">
					<input type="radio" name="radio-choice-h-2" id="radio-choice-h-2a" value="on" checked="checked"> <label for="radio-choice-h-2a">简约</label> <input type="radio" name="radio-choice-h-2"
						id="radio-choice-h-2b" value="off"> <label for="radio-choice-h-2b">彩绘</label> <input type="radio" name="radio-choice-h-2" id="radio-choice-h-2c" value="other"> <label
						for="radio-choice-h-2c">法式</label> <input type="radio" name="radio-choice-h-2" id="radio-choice-h-2d" value="other"> <label for="radio-choice-h-2d">日韩</label>
				</fieldset>
			</form>
			<div class="ui-bar ui-bar-b" style="padding: 5px;">
				<div class="ui-grid-b">
					<div class="ui-block-a">
						<select name="select-native-1" id="select-native-1" data-mini="true" data-theme="a">
							<option>-综合-</option>
							<option value="1">升序</option>
							<option value="2">降序</option>
						</select>
					</div>
					<div class="ui-block-b">
						<select name="select-native-2" id="select-native-2" data-mini="true" data-theme="a">
							<option>-价格-</option>
							<option value="1">价格优先</option>
							<option value="2">销量优先</option>
						</select>
					</div>
					<div class="ui-block-c">
						<select name="select-native-3" id="select-native-3" data-mini="true" data-theme="a">
							<option>-筛选-</option>
							<option value="1">0-100</option>
							<option value="2">101-200</option>
							<option value="3">201-400</option>
							<option value="4">401-1000</option>
							<option value="4">1000+</option>
						</select>
					</div>
				</div>
			</div>




			<ul data-role="listview" data-inset="true">
				<li><a href="#"> <img src="${ctx}/images/_assets/img/apple.png" class="ui-li-thumb">
						<h2>iOS 6.1</h2>
						<p>Apple released iOS 6.1</p>
						<p class="ui-li-aside">iOS</p>
				</a></li>
				<li><a href="#"> <img src="${ctx}/images/_assets/img/blackberry_10.png" class="ui-li-thumb">
						<h2>BlackBerry 10</h2>
						<p>BlackBerry launched the Z10 and Q10 with the new BB10 OS</p>
						<p class="ui-li-aside">BB</p>
				</a></li>
				<li><a href="#"> <img src="${ctx}/images/_assets/img/lumia_800.png" class="ui-li-thumb">
						<h2>WP 7.8</h2>
						<p>Nokia rolls out WP 7.8 to Lumia 800</p>
						<p class="ui-li-aside">WP</p>
				</a></li>
				<li><a href="#"> <img src="${ctx}/images/_assets/img/galaxy_express.png" class="ui-li-thumb">
						<h2>Galaxy</h2>
						<p>New Samsung Galaxy Express</p>
						<p class="ui-li-aside">Samsung</p>
				</a></li>
				<li><a href="#"> <img src="${ctx}/images/_assets/img/nexus_7.png" class="ui-li-thumb">
						<h2>Nexus 7</h2>
						<p>Rumours about new full HD Nexus 7</p>
						<p class="ui-li-aside">Android</p>
				</a></li>
				<li><a href="#"> <img src="${ctx}/images/_assets/img/firefox_os.png" class="ui-li-thumb">
						<h2>Firefox OS</h2>
						<p>ZTE to launch Firefox OS smartphone at MWC</p>
						<p class="ui-li-aside">Firefox</p>
				</a></li>
				<li><a href="#"> <img src="${ctx}/images/_assets/img/tizen.png" class="ui-li-thumb">
						<h2>Tizen</h2>
						<p>First Samsung phones with Tizen can be expected in 2013</p>
						<p class="ui-li-aside">Tizen</p>
				</a></li>
				<li><a href="#">
						<h2>Symbian</h2>
						<p>Nokia confirms the end of Symbian</p>
						<p class="ui-li-aside">Symbian</p>
				</a></li>
			</ul>
		</div>
		<!-- /content -->

		<div data-role="footer" data-position="fixed">
			<div data-role="navbar">
				<ul>
					<li><a id="nav_bar_btn_home" href="${ctx}/home" data-icon="home" class="ui-btn-active" data-ajax="false">首页</a></li>
					<li><a id="nav_bar_btn_favs" href="#" data-icon="star" data-ajax="false">收藏</a></li>
					<li><a id="nav_bar_btn_order" href="${ctx}/order" data-icon="shop" data-ajax="false">订单</a></li>
				</ul>
			</div>
			<!-- /navbar -->
		</div>
		<!-- /footer -->
	</div>
</body>
</html>
