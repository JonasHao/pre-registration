$(document).ready(function() {
	var theData = [
		{"name": "中山医院", "ID": 11, "description":"这是一家很好的医院", "image": "http://o7f17g2ke.bkt.clouddn.com/20160519223340.png"},
    	{"name": "大学城医院", "ID": 12, "description":"大学城里唯一一家", "image": "http://o7f17g2ke.bkt.clouddn.com/20160519224544.png"},
    	{"name": "中山医院", "ID": 13, "description":"这是一家很好的医院这是一家很好的医院这是一家很好的医院这是一家很好的医院这是一家很好的医院这是一家很好的医院这是一家很好的医院", image: "http://o7f17g2ke.bkt.clouddn.com/20160519223340.png"},
    	{"name": "大学城医院", "ID": 14, "description":"大学城里唯一一家", "image": "http://o7f17g2ke.bkt.clouddn.com/20160519224544.png"}
	];
	for (var i=0; i<theData.length; i++) {
		var appendText = "<a href='/hospital?id=" + theData[i].ID + "'><img alt='医院照片' src='" + theData[i].image + "'><p class='name'>" + theData[i].name + "</p><p class='detail'>" + theData[i].description + "</p></a>";
		$(".container .panel .panel-body").append(appendText);
	}
	$(".container .panel .panel-body").append("<div class='clear'></div>");
	$("#search").click(function(event) {
		var url = "/search?searchKey=" + $("#searchKey").val();
		console.log(url);
		// $.get(url, function(data) {
			$(".container .panel .panel-body").empty();
			if (theData.length == 0) {
				$(".container .panel .panel-body").append("无搜索结果");
			}
			for (var i=0; i<theData.length; i++) {
				var appendText = "<a href='/hospital?id=" + theData[i].ID + "'><img src='" + theData[i].image + "'><p class='name'>" + theData[i].name + "</p><p class='detail'>" + theData[i].description + "</p></a>";
				$(".container .panel .panel-body").append(appendText);
			}
			$(".container .panel .panel-body").append("<div class='clear'></div>");
		// });
		return false;
	});
	$(".container .panel .panel-body").on('click', 'a', function() {
		// $.get($(this).prop("href"), function(data) {
			/*optional stuff to do after success */


		// });
		return false;
	});
});
