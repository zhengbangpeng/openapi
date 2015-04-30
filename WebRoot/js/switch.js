$(function() {
	$(".conGroup").each(function(index, element) {
		$(this).click(function() {
			$(".disGroup").hide();
			if (this.id == "first") {
				$(".first").toggle();
				$(".switch li").removeClass("active");
				$("#firstli").addClass("active");
			} else if (this.id == "second") {
				$(".second").toggle();
				$(".switch li").removeClass("active");
				$("#secondli").addClass("active");
			} else {
				$(".third").toggle();
				$(".switch li").removeClass("active");
				$("#thirdli").addClass("active");
			}
			return false;
		});
	});
});
