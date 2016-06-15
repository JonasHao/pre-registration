<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>增加医生信息</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/main.css" rel="stylesheet">
</head>

<body>
<nav class="navbar navbar-default" style="margin-bottom:0;border:0;border-radius:0;">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-grain"></span>&nbsp;在线挂号系统后台</a>
        </div>

        <span class="navbar-text" style="float:right;"><a href="#">退出管理</a></span>
        <span class="navbar-text" style="float:right;">欢迎登录，XXX</span>
    </div>
</nav>


<div class="container" style="overflow:hidden;margin-left:300px;width:100%;padding:0px;">
    <div class="row">
        <div class="col-xs-6">
            <p class="biao"><a>首页></a><a>管理医院信息></a><a>添加医院信息</a></p>
            <s:form action="department/add" validate="true" class="form-horizontal">
                <s:textfield name="id" label="医生ID号" maxLength="20" disabled="true" cssClass="form-control"/>
                <s:textfield cssClass="form-control" name="name" label="医生名字"/>
                <s:textarea cssClass="form-control"  name="introduction" label="描述"/>
                <s:textarea cssClass="form-control"  name="title" label="职称"/>
                <s:file id="professional" name="professional" label="上传图片"/>
                <p class="help-block">（提示：上传图片不能大于2m）</p>
                <s:submit value="确认提交" cssClass="btn btn-primary"  style="width:50%;font-size:1em;text-align:center;"/>
            </s:form>
        </div>
    </div>
    <%--<div class="form-group">--%>
    <%--<label for="input" class="col-xs-3 control-label"><span style="color:red">*</span>照片：</label>--%>
    <%--<div class="col-xs-6">--%>
    <%--<input type="file" id="professional" name="professional">--%>
    <%--<p class="help-block">（提示：上传图片不能大于2m）</p>--%>
    <%--</div>--%>
    <%--</div>--%>
</div>
</body>
<script src="js/jquery-1.11.3.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/YMDClass.js"></script>
<script>
    window.onload = function () {
        new YMDselect('year', 'month', 'day');
        if ($("body").height() < window.innerHeight) {
            $("#inn").css("height", window.innerHeight - 50);
        }
        else {
            $("#inn").css("height", document.body.scrollHeight - 50);
        }
    };

</script>
</html>
