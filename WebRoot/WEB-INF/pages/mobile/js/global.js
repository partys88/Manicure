$(document)
		.on(
				"click",
				"a",
				function() {
					if ($(this).attr("href") != "#") {
						var $this = $(this), theme = $this.jqmData("theme")
								|| $.mobile.loader.prototype.options.theme, msgText = $this
								.jqmData("msgtext")
								|| $.mobile.loader.prototype.options.text, textVisible = $this
								.jqmData("textvisible")
								|| $.mobile.loader.prototype.options.textVisible, textonly = !!$this
								.jqmData("textonly");
						html = $this.jqmData("html") || "";
						$.mobile.loading("show", {
							text : msgText,
							textVisible : textVisible,
							theme : theme,
							textonly : textonly,
							html : html
						});
					}
				})

$(document).on('pagecontainershow', function(e, ui) {
	(function() {
		if (ui.toPage[0].id != "home-page")
			return;
		var script = document.createElement('script');
		script.type = 'text/javascript';
		script.async = true;
		script.src = _ctx + "/js/home.js";
		var s = document.getElementsByTagName('script')[0];
		s.parentNode.insertBefore(script, s);

	})();

});

$(document).on('pagecontainershow', function(e, ui) {
	(function() {
		if (ui.toPage[0].id != "order-page")
			return;

	})();

});
