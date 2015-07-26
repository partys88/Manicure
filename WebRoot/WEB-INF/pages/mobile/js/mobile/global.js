//$(document)
//		.on(
//				"click",
//				"a",
//				function() {
//					// if ($(this).attr("href") != "#") {
//					var $this = $(this), theme = $this.jqmData("theme")
//							|| $.mobile.loader.prototype.options.theme, msgText = $this
//							.jqmData("msgtext")
//							|| $.mobile.loader.prototype.options.text, textVisible = $this
//							.jqmData("textvisible")
//							|| $.mobile.loader.prototype.options.textVisible, textonly = !!$this
//							.jqmData("textonly");
//					html = $this.jqmData("html") || "";
//					$.mobile.loading("show", {
//						text : msgText,
//						textVisible : textVisible,
//						theme : theme,
//						textonly : textonly,
//						html : html
//					});
//					// }
//				})

$(function() {
	$("[data-role='navbar']").navbar();
	$("[data-role='header'], [data-role='footer']").toolbar();
});
// Update the contents of the toolbars
$(document).on("pagecontainerchange", function() {
	// Each of the four pages in this demo has a data-title attribute
	// which value is equal to the text of the nav button
	// For example, on first page: <div data-role="page" data-title="Info">
	var current = $(".ui-page-active").jqmData("title");
	// Change the heading
	$("#footer-nav h1").text(current);
	// Remove active class from nav buttons
	$("#footer-nav a.ui-btn-active").removeClass("ui-btn-active");
	// Add active class to current nav button
	$("#footer-nav a").each(function() {
		if ($(this).text() === current) {
			$(this).addClass("ui-btn-active");
		}
	});

});





