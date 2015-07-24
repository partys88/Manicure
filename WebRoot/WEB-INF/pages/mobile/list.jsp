<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="meta/config.jsp"%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<title>Home</title>
<%@ include file="meta/meta.jsp"%>
</head>
<body>
	<div data-role="page" class="list-page">
		<div data-role="header">
			<a data-rel="back" class="ui-btn ui-btn-left ui-alt-icon ui-nodisc-icon ui-corner-all ui-btn-icon-notext ui-icon-carat-l">后退</a>
			<h2>米宝服务</h2>
		</div>
		<div role="main" class="ui-content">
			<div class="ui-grid-b" style="font-size: 0.8em;text-align: center;">
				<div class="ui-block-a typebtn">
					<a href="#" data-theme="b" data-role="button">美甲</a>
				</div>
				<div class="ui-block-b typebtn">
					<a href="#" data-theme="c" data-role="button" >美足</a>
				</div>
				<div class="ui-block-c typebtn">
					<a href="#" data-theme="d" data-role="button" >美婕</a>
				</div>
			</div>
			<div class="ui-grid-a" style="font-size: 0.8em;text-align: center;">
				<div class="ui-block-a typebtn">
					<a data-theme="e" data-role="button">化妆</a>
				</div>
				<div class="ui-block-b typebtn">
					<a data-theme="f" data-role="button" >护理</a>
				</div>
			</div>
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
			<form style="text-align: center;">
				<fieldset data-role="controlgroup" data-type="horizontal">
					<input type="radio" name="radio-choice-h-2" id="radio-choice-h-2a" value="on" checked="checked"> <label for="radio-choice-h-2a">简约</label> <input type="radio" name="radio-choice-h-2"
						id="radio-choice-h-2b" value="off"> <label for="radio-choice-h-2b">彩绘</label> <input type="radio" name="radio-choice-h-2" id="radio-choice-h-2c" value="other"> <label
						for="radio-choice-h-2c">法式</label> <input type="radio" name="radio-choice-h-2" id="radio-choice-h-2d" value="other"> <label for="radio-choice-h-2d">日韩</label>
				</fieldset>
			</form>
			<div class="ui-grid-solo">
				<ul data-role="listview" data-inset="true" >
					<li><a href="#" > <img src="${ctx}/_assets/img/apple.png" class="ui-li-thumb">
							<h2>iOS 6.1</h2>
							<p>Apple released iOS 6.1</p>
							<p class="ui-li-aside">iOS</p>
					</a></li>
					<li><a href="#" > <img src="${ctx}/_assets/img/blackberry_10.png" class="ui-li-thumb">
							<h2>BlackBerry 10</h2>
							<p>BlackBerry launched the Z10 and Q10 with the new BB10 OS</p>
							<p class="ui-li-aside">BB</p>
					</a></li>
					<li><a href="#"> <img src="${ctx}/_assets/img/lumia_800.png" class="ui-li-thumb">
							<h2>WP 7.8</h2>
							<p>Nokia rolls out WP 7.8 to Lumia 800</p>
							<p class="ui-li-aside">WP</p>
					</a></li>
					<li><a href="#"> <img src="${ctx}/_assets/img/galaxy_express.png" class="ui-li-thumb">
							<h2>Galaxy</h2>
							<p>New Samsung Galaxy Express</p>
							<p class="ui-li-aside">Samsung</p>
					</a></li>
					<li><a href="#"> <img src="${ctx}/_assets/img/nexus_7.png" class="ui-li-thumb">
							<h2>Nexus 7</h2>
							<p>Rumours about new full HD Nexus 7</p>
							<p class="ui-li-aside">Android</p>
					</a></li>
					<li><a href="#"> <img src="${ctx}/_assets/img/firefox_os.png" class="ui-li-thumb">
							<h2>Firefox OS</h2>
							<p>ZTE to launch Firefox OS smartphone at MWC</p>
							<p class="ui-li-aside">Firefox</p>
					</a></li>
					<li><a href="#"> <img src="${ctx}/_assets/img/tizen.png" class="ui-li-thumb">
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

		</div>
		<%@ include file="meta/footer.jsp"%>
		<!-- /footer -->
	</div>
</body>
</html>