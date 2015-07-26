$(document).on('pagecontainershow', function(e, ui) {
	(function() {
		if (ui.toPage[0].id != "home-page")
			return;
		$('#home-slider').sliderPro({
			width : "100%",
			aspectRatio : 2,
			arrows : true,
			buttons : false,
			fullScreen : false,
			shuffle : true,
		});
		
	})();

});