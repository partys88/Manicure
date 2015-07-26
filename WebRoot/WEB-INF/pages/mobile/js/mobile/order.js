/**
 * 
 */
$(document).on('pagecontainershow', function(e, ui) {
	(function() {
		if (ui.toPage[0].id != "order-page")
			return;
		$(document).on("click", "#page-order-btn-list-all", function() {
			$("#page-order-list-orders").hide();
			$("#page-order-list-orders").fadeIn();
			loadAllOrders("11");

		});
		$(document).on("click", "#page-order-btn-list-processing", function() {
			$("#page-order-list-orders").hide();
			$("#page-order-list-orders").fadeIn();
			loadProcessingOrders("11");
		});
		$(document).on("click", "#page-order-btn-list-not-evaluated", function() {
			$("#page-order-list-orders").hide();
			$("#page-order-list-orders").fadeIn();
			loadNotEvaluatedOrders("11");
		});
		
		$("#page-order-btn-list-all").click();
		
		function loadAllOrders(json) {
			$("#page-order-list-orders").empty();
			AppendListItem("#page-order-list-orders", "#", _ctx + "/mobile/_assets/img/blackberry_10.png", "优雅裸色", "简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介", "待评价");
			AppendListItem("#page-order-list-orders", "#", _ctx + "/mobile/_assets/img/lumia_800.png", "气质款", "简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介", "已完成");
			AppendListItem("#page-order-list-orders", "#", _ctx + "/mobile/_assets/img/galaxy_express.png", "红唇豹纹", "简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介", "待评价");
			AppendListItem("#page-order-list-orders", "#", _ctx + "/mobile/_assets/img/nexus_7.png", "喜庆甲", "简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介", "已完成");
			AppendListItem("#page-order-list-orders", "#", _ctx + "/mobile/_assets/img/firefox_os.png", "俏皮粉", "简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介", "进行中");
			AppendListItem("#page-order-list-orders", "#", _ctx + "/mobile/_assets/img/tizen.png", "纯色", "简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介", "进行中");

			$("#page-order-list-orders").listview('refresh');
		}

		function loadProcessingOrders(json) {
			$("#page-order-list-orders").empty();
			AppendListItem("#page-order-list-orders", "#", _ctx + "/mobile/_assets/img/firefox_os.png", "俏皮粉", "简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介", "进行中");
			AppendListItem("#page-order-list-orders", "#", _ctx + "/mobile/_assets/img/tizen.png", "纯色", "简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介", "进行中");
			$("#page-order-list-orders").listview('refresh');
		}

		function loadNotEvaluatedOrders(json) {
			$("#page-order-list-orders").empty();
			AppendListItem("#page-order-list-orders", "#", _ctx + "/mobile/_assets/img/blackberry_10.png", "优雅裸色", "简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介", "待评价");
			AppendListItem("#page-order-list-orders", "#", _ctx + "/mobile/_assets/img/galaxy_express.png", "红唇豹纹", "简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介简介", "待评价");
			$("#page-order-list-orders").listview('refresh');
		}

		function AppendListItem(target, href, img, title, discription, status) {
			var elmLi = $(document.createElement("li"));
			var elmImg = $(document.createElement("img"));
			var elmA = $(document.createElement("a"));
			var elmH2 = $(document.createElement("h2"));
			var elmP = $(document.createElement("p"));

			var listLi = elmLi.clone();
			var listA = elmA.clone().attr("href", href);
			var listImg = elmImg.clone().attr("src", img);
			var listH2 = elmH2.clone().text(title);
			var listP = elmP.clone().text(discription);
			var listSt = elmP.clone().addClass("ui-li-aside").css("color", "orange").text(status);

			listA.append(listImg);
			listA.append(listH2);
			listA.append(listP);
			listA.append(listSt);
			listLi.append(listA);
			$(target).append(listLi);
		}
	})();

});
