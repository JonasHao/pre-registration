$(document).ready(function() {
	var user;
	var myBook = [];
	var indexData = [
		{"name": "中山医院1", "id": 11, "description":"这是一家很好的医院", "image": "http://o7f17g2ke.bkt.clouddn.com/20160519223340.png"},
    	{"name": "大学城医院1", "id": 12, "description":"大学城里唯一一家", "image": "http://o7f17g2ke.bkt.clouddn.com/20160519224544.png"},
    	{"name": "中山医院2", "id": 13, "description":"这是一家很好的医院这是一家很好的医院这是一家很好的医院这是一家很好的医院这是一家很好的医院这是一家很好的医院这是一家很好的医院", image: "http://o7f17g2ke.bkt.clouddn.com/20160519223340.png"},
    	{"name": "大学城医院2", "id": 14, "description":"大学城里唯一一家", "image": "http://o7f17g2ke.bkt.clouddn.com/20160519224544.png"}
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
			$(".order .panel table.table tbody").empty();
			var appendText;
			if (myBook.length != 0) {
				appendText = "<tr><th>医院</th><th>科室</th><th>医生姓名</th><th>预约时间</th><th></th></tr>"
				for (var i=0; i<myBook.length; i++) {
					appendText += "<tr><td>" + myBook[i].hospital + "</td><td>" + myBook[i].department + "</td><td>" + myBook[i].doctor + "</td><td>" + myBook[i].time + "</td><td><button name='" + i + "' class='btn btn-default'>取消</button></td></tr>";
				}
				$(".order .panel table.table tbody").append(appendText);
			}
		}
	});
	$(".bookSpace").click(function(event) {
		$(".space").hide();
		if (!user) {
			alert("请先登录");
			$(".user").show();
			$(".login").show();
			$(".signup").show();
			$(".order").hide();
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
		
		// $.get(url, function(data) {
			$(".container .panel .panel-heading").html("搜索结果");
			$(".container .panel .panel-body").empty();
			var count = 0;
			for (var i=0; i<indexData.length; i++) {
				if (indexData[i].name == $("#searchKey").val()) {
					var appendText = "<a class='hospital' href='/hospital?id=" + indexData[i].id + "'><img src='" + indexData[i].image + "'><p class='name'>" + indexData[i].name + "</p><p class='detail'>" + indexData[i].description + "</p></a>";
					$(".container .panel .panel-body").append(appendText);
					count++;
				}
			}
			if (count == 0) {
				$(".container .panel .panel-body").append("无搜索结果");
			}
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
            	{
            	    "capacities": [
            	        {"id":1,"slot":"2016-05-26T17:42:09","slotString":"2016-05-26 17:00 - 17:00","surplus":8,"total":8},
            	        {"id":2,"slot":"2016-05-25T13:56:12","slotString":"2016-05-25 13:00 - 13:00","surplus":3,"total":5}
            	    ],
    	            "department": {"description":"胸外科","id":1,"name":"外科"},
    	            "id":1,
    	            "introduction":"包治百病",
    	            "name":"神奇医生",
    	            "title":"高级医生"
            	},
            	{
            	    "capacities": [
            	        {"id":1,"slot":"2016-05-26T17:42:09","slotString":"2016-05-26 17:00 - 17:00","surplus":8,"total":8},
            	        {"id":2,"slot":"2016-05-25T13:56:12","slotString":"2016-05-25 13:00 - 13:00","surplus":3,"total":5}
            	    ],
    	            "department": {"description":"胸外科","id":1,"name":"外科"},
    	            "id":2,
    	            "introduction":"药到病除",
    	            "name":"无天药师",
    	            "title":"高级医生"
            	}
            ],
            "id": 18,
            "name": "内科",
            "hospital": {"address_area":"ssss","description":"ssss","id":1,"name":"中山"}
        };

        // $.get($(this).prop("href"), function(data) {
			$(".container .panel .panel-heading").html("科室详情");
			$(".container .panel .panel-body").empty();

			//科室名字介绍
			var appendText = "<div class='department-detail-top'><p class='department-detail-name'>" 
							+ department.name + "</p><p class='department-detail-description'>" + department.hospital.name 
							+ "医院</p></div><div class='department-doctors'><table class='table table-bordered'><tbody><tr><th>医生姓名</th><th>医生级别</th><th>医生简介</th><th>填写预约时间</th></tr>";
			
			//医生
			for (var i=0; i<department.doctors.length; i++) {
				appendText += "<tr><td>" + department.doctors[i].name + "</td><td>" + department.doctors[i].title + "</td><td>" + department.doctors[i].introduction + "</td><td><button name='" + department.doctors[i].name + "' class='btn btn-default'>预约</button></td></tr>";
			}
			appendText += "</tbody></table></div>";
			$(".container .panel .panel-body").append(appendText);
		// });

		return false;
	});

	$(".container .panel .panel-body").on('click', 'button.btn.btn-default', function(event) {	
		if (!user) {
			alert("请先登录");
			$(".space").hide();
			$(".user").show();
			$(".login").show();
			$(".signup").show();
			$(".order").hide();
			$(".active").removeClass('active');
			$(".userSpace").parent().addClass('active');
		} else {
			var doctor = {
        	    "capacities": [
        	        {"id":1,"slot":"2016-05-26T17:42:09","slotString":"2016-05-26 17:00 - 17:00","surplus":8,"total":8},
        	        {"id":2,"slot":"2016-05-25T13:56:12","slotString":"2016-05-25 13:00 - 13:00","surplus":3,"total":5}
        	    ],
	            "department": {"description":"胸外科","id":1,"name":"外科"},
	            "id":1,
	            "introduction":"包治百病",
	            "name":"神奇医生",
	            "title":"高级医生"
        	};
			$(".alert").show();
			$(".alert form p span").html(doctor.name);
			$(".alert select.form-control").empty();
			for (var i=0; i<doctor.capacities.length; i++) {
				var appendText = "<option value='" + doctor.capacities[i].slotString + "'>" + doctor.capacities[i].slotString + "</option>"
				$(".alert select.form-control").append(appendText);
			}
		}
		
		return false;
	});
	$(".alert .closebtn").click(function(event) {
		$(".alert").hide("slow");
		return false;
	});
	$(".alert .book-submit button").click(function(event) {
		var data = {
			hospital: $(".department-detail-top .department-detail-name").html(),
			department: $(".department-detail-top .department-detail-description").html(),
			doctor: $(this).parent().parent().children('p').children('span').html(),
			time: $(this).parent().parent().children('.form-group').children('.form-control').val()
		}
		
		var yes = false;
		for (var i=0; i<myBook.length; i++) {
			if (myBook[i].hospital == data.hospital &&
				myBook[i].department == data.department &&
				myBook[i].doctor == data.doctor &&
				myBook[i].time == data.time) {
				yes = true;
			}
		}
		if (!yes) {
			myBook.push(data);
			alert("预约成功");
			$(".alert").hide("slow");
		} else {
			alert("请不要重复预约!");
		}
	});

	/*挂号模块挂号按钮点击事件*/
	$(".book .book-submit").click(function(event) {
		var data = {
			hospital: $("#book-hospital").val(),
			department: $("#book-department").val(),
			doctor: $("#book-doctor").val(),
			time: $("#book-time").val()
		}

		var yes = false;
		for (var i=0; i<myBook.length; i++) {
			if (myBook[i].hospital == data.hospital &&
				myBook[i].department == data.department &&
				myBook[i].doctor == data.doctor &&
				myBook[i].time == data.time) {
				yes = true;
			}
		}
		if (!yes) {
			myBook.push(data);
			alert("预约成功");
		} else {
			alert("请不要重复预约!");
		}
		
		return false;
	});
	
});
