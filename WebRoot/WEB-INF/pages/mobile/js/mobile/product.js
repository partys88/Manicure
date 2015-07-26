$(document).on('pagecontainershow', function(e, ui) {
	(function() {
		if (ui.toPage[0].id != "product-page")
			return;
		$("#header-product-name").text("气质款");
		
	})();

});