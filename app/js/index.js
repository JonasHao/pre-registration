$(document).ready(function() {
	var user;
	var indexData = [
		{"name": "中山医院", "id": 11, "description":"这是一家很好的医院", "image": "http://o7f17g2ke.bkt.clouddn.com/20160519223340.png"},
    	{"name": "大学城医院", "id": 12, "description":"大学城里唯一一家", "image": "http://o7f17g2ke.bkt.clouddn.com/20160519224544.png"},
    	{"name": "中山医院", "id": 13, "description":"这是一家很好的医院这是一家很好的医院这是一家很好的医院这是一家很好的医院这是一家很好的医院这是一家很好的医院这是一家很好的医院", image: "http://o7f17g2ke.bkt.clouddn.com/20160519223340.png"},
    	{"name": "大学城医院", "id": 14, "description":"大学城里唯一一家", "image": "http://o7f17g2ke.bkt.clouddn.com/20160519224544.png"}
	];
	var searchData = [
		{"name": "中山医院", "id": 13, "description":"这是一家很好的医院这是一家很好的医院这是一家很好的医院这是一家很好的医院这是一家很好的医院这是一家很好的医院这是一家很好的医院", image: "http://o7f17g2ke.bkt.clouddn.com/20160519223340.png"},
    	{"name": "大学城医院", "id": 14, "description":"大学城里唯一一家", "image": "http://o7f17g2ke.bkt.clouddn.com/20160519224544.png"}
	];
	var bookData = [];

	$(".container").show();
	$(".container .panel .panel-heading").html("医院列表");
	for (var i=0; i<indexData.length; i++) {
		var appendText = "<a class='hospital' href='/hospital?id=" + indexData[i].id + "'><img alt='医院照片' src='" + indexData[i].image + "'><p class='name'>" + indexData[i].name + "</p><p class='detail'>" + indexData[i].description + "</p></a>";
		$(".container .panel .panel-body").append(appendText);
	}

	
	$(".nav-menu").click(function(event) {
		$(".active").removeClass('active');
		$(this).parent().addClass('active');
	});

	$(".homeSpace").click(function(event) {
		$(".space").hide();
		$(".container").show();

		$(".container .panel .panel-heading").html("医院列表");
		$(".container .panel .panel-body").empty();
		for (var i=0; i<indexData.length; i++) {
			var appendText = "<a class='hospital' href='/hospital?id=" + indexData[i].id + "'><img alt='医院照片' src='" + indexData[i].image + "'><p class='name'>" + indexData[i].name + "</p><p class='detail'>" + indexData[i].description + "</p></a>";
			$(".container .panel .panel-body").append(appendText);
		}
	});
	$(".userSpace").click(function(event) {
		$(".space").hide();
		$(".user").show();
			
		if (!user) {
			$(".login").show();
			$(".signup").show();
			$(".order").hide();
		} else {
			$(".login").hide();
			$(".signup").hide();
			$(".order").show();
		}
	});
	$(".bookSpace").click(function(event) {
		$(".space").hide();
		if (!user) {
			alert("请先登录");
			$(".user").show();
			$(".active").removeClass('active');
			$(".userSpace").parent().addClass('active');
		} else {
			$(".book").show();
		}
	});

	$("#login").click(function(event) {
		if (!$("#loginUserName").val() || !$("#loginUserPass").val()) {
			alert("用户名或密码不能为空");
		}
		user = {
			userName: $("#loginUserName").val(),
			userPass: $("#loginUserPass").val()
		}
		$(".navbar-right li a").append("<span class='glyphicon glyphicon-user' aria-hidden='true'></span> " + user.userName);
		$(".user").hide();
		$(".container").show();
		$(".active").removeClass('active');
		$(".homeSpace").parent().addClass('active');
	});

	$("#search").click(function(event) {
		var url = "/search?searchKey=" + $("#searchKey").val();
		console.log(url);
		// $.get(url, function(data) {
			$(".container .panel .panel-heading").html("搜索结果");
			$(".container .panel .panel-body").empty();
			if (searchData.length == 0) {
				$(".container .panel .panel-body").append("无搜索结果");
			}
			for (var i=0; i<searchData.length; i++) {
				var appendText = "<a class='hospital' href='/hospital?id=" + searchData[i].id + "'><img src='" + searchData[i].image + "'><p class='name'>" + searchData[i].name + "</p><p class='detail'>" + searchData[i].description + "</p></a>";
				$(".container .panel .panel-body").append(appendText);
			}
			$(".container .panel .panel-body").append("<div class='clear'></div>");
		// });
		return false;
	});
	$(".container .panel .panel-body").on('click', '.hospital', function() {
		var detailData = {
            id: 1,
            departments: [
                {description: "人民医院的内科", id: 4, name: "内科", image: "http://o7f17g2ke.bkt.clouddn.com/20160519224544.png"},
                {description: "胸外科", id: 1, name: "外科", image: "http://o7f17g2ke.bkt.clouddn.com/20160519223340.png"}
            ],
            description: "人民的医院",
            name: "人民医院",
            image: "http://o7f17g2ke.bkt.clouddn.com/20160519223340.png"
        };


		// $.get($(this).prop("href"), function(data) {
			$(".container .panel .panel-heading").html("医院详情");
			$(".container .panel .panel-body").empty();

			//医院图片名字介绍
			$(".container .panel .panel-body").append("<div class='hospital-detail-top'><div class='hospital-detail-top-left'><img src='" + detailData.image + "' alt=''></div><div class='hospital-detail-top-right'><p class='hospital-detail-name'>" + detailData.name + "</p><p class='hospital-detail-description'>" + detailData.description + "</p></div><div class='clear'></div></div>");
			//科室
			for (var i=0; i<detailData.departments.length; i++) {
				var appendText = "<a class='department' href='/department/detailShow?id=" + detailData.departments[i].id + "'><img src='" + detailData.departments[i].image + "'><p class='name'>" + detailData.departments[i].name + "</p><p class='detail'>" + detailData.departments[i].description + "</p></a>";
				$(".container .panel .panel-body").append(appendText);
			}
		// });
		return false;
	});
	$(".container .panel .panel-body").on('click', '.department', function() {
		var department = {
            "doctors": [
            	{"name":"王一", "id":1,"title":"特级医生","introduction":"世家医生"},
            	{"name":"王二", "id":2,"title":"一级医生","introduction":"0.0"}
            ],
            "id": 18,
            "name": "内科"
        };
		return false;
	});
	
	
});
