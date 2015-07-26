/**
 * 
 */
$(document).on('pagecontainershow', function(e, ui) {
	(function() {
		if (ui.toPage[0].id != "list-page")
			return;

		loadAllService("123");

		function loadAllService(json) {
			$("#page-list-list-service").empty();
			AppendListItem("#page-list-list-service", _ctx + "/product/111", _ctx + "/_assets/img/blackberry_10.png", "优雅裸色", "简介简介简介", "¥100");
			AppendListItem("#page-list-list-service", _ctx + "/product/111", _ctx + "/_assets/img/lumia_800.png", "气质款", "简介简介简介", "¥250");
			AppendListItem("#page-list-list-service", _ctx + "/product/111", _ctx + "/_assets/img/galaxy_express.png", "红唇豹纹", "简介简介简介", "¥300");
			AppendListItem("#page-list-list-service", _ctx + "/product/111", _ctx + "/_assets/img/nexus_7.png", "喜庆甲", "简介简介简介", "¥50");
			AppendListItem("#page-list-list-service", _ctx + "/product/111", _ctx + "/_assets/img/firefox_os.png", "俏皮粉", "简介简介简介", "¥1000");
			AppendListItem("#page-list-list-service", _ctx + "/product/111", _ctx + "/_assets/img/tizen.png", "纯色", "简介简介简介", "¥29");

			$("#page-list-list-service").listview('refresh');
		}

		function AppendListItem(target, href, img, title, discription, status) {
			var elmLi = $(document.createElement("li"));
			var elmImg = $(document.createElement("img"));
			var elmA = $(document.createElement("a"));
			var elmH2 = $(document.createElement("h2"));
			var elmP = $(document.createElement("p"));

			var listLi = elmLi.clone();
			var listA = elmA.clone().attr("href", href);
			var listImg = elmImg.clone().attr("src", img).addClass("ui-li-thumb");
			var listH2 = elmH2.clone().text(title);
			var listP = elmP.clone().text(discription);
			var listSt = elmP.clone().addClass("ui-li-aside").css("color", "white").text(status);

			listA.append(listImg);
			listA.append(listH2);
			listA.append(listP);
			listA.append(listSt);
			listLi.append(listA);
			$(target).append(listLi);
		}
	})();

});
