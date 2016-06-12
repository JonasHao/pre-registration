<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Koche
  Date: 2016/5/11
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <title>管理教师信息</title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/main.css" rel="stylesheet">
</head>

<body>
<nav class="navbar navbar-default" style="margin-bottom:0;border:0;border-radius:0;">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="#"><span class="glyphicon glyphicon-grain"></span>&nbsp;学生信息管理员后台系统</a>
        </div>

        <span class="navbar-text" style="float:right;"><a href="#">退出管理</a></span>
        <span class="navbar-text" style="float:right;">欢迎登录，XXX</span>
    </div>
</nav>

<div class="container" style="overflow:hidden;margin:0;width:100%;padding:0px;">


    <div class="container">
        <p class="biao"><a>首页></a><a>管理教师信息</a></p>

        <div class="row">
            <div class="col-xs-4">
                <form class="form-inline">
                    <button onclick="javascript:window.location.href='add.html';" type="button"
                            class="btn btn-primary"><span class="glyphicon glyphicon-plus"></span>新增
                    </button>
                    <div class="input-group" class="col-xs-3;">
                        <input type="text" class="form-control" placeholder="关键字...">
                <span class="input-group-btn">
                  <button class="btn btn-default" type="button">搜索</button>
                </span>
                    </div>
                </form>
            </div>

        </div>

        <div class="row">
            <div class="col-xs-12">
                <table class="table table-striped table-bordered">
                    <tr>
                        <td style="background-color:#3fb4c6; color:#fff;width:15%;">id</td>
                        <td style="background-color:#3fb4c6; color:#fff;width:25%;">名字</td>
                        <td style="background-color:#3fb4c6; color:#fff;width:30%;">描述</td>

                        <td style="background-color:#3fb4c6; color:#fff;width:15%;">操作</td>
                    </tr>

                    <s:iterator value="hospitals">
                        <tr>
                            <s:url var="get" action="getByID">
                                <s:param name="hospitalID">
                                    <s:property value="id"/>
                                </s:param>
                            </s:url>

                            <s:url var="update" action="update">
                                <s:param name="hospitalID">
                                    <s:property value="id"/>
                                </s:param>
                            </s:url>

                            <s:url var="delete" action="delete">
                                <s:param name="hospitalID">
                                    <s:property value="id"/>
                                </s:param>
                            </s:url>


                            <a href="<s:property value="get"/>">
                                <td><s:property value="id"/></td>
                                <td><s:property value="name"/></td>
                                <td><s:property value="description"/></td>
                            </a>

                            <td><a href="<s:property value="#get"/>" class="check"><span
                                    class=" glyphicon glyphicon-search"></span>查看</a>
                                /<a href="<s:property value="#update"/>" class="change"><span
                                        class="glyphicon glyphicon-pencil"></span>修改</a>
                                /<a href="<s:property value="#delete"/>" class="delete"><span
                                        class="glyphicon glyphicon-trash"></span>删除</a>
                            </td>
                        </tr>
                    </s:iterator>

                </table>
            </div>
        </div>

    </div>

</div>
<div style="width:100%;height:100%;position:absolute;background-color:#000;top:0;left:0;z-index:2;opacity:0.3;display:none;"
     id="cover"></div>
<div style="position:absolute;top:5em;width:100%;z-index:3;text-align:left;display:none;" id="pushWindow">
    <div class="container-fluid">
        <div class="row">
            <div class="col-xs-4 col-xs-offset-4" style="background-color:#fff;padding:0;">
                <p style="background-color:#3fb4c6;margin:0;padding:5px;color:#fff;">删除询问</p>

                <div style="text-align:center;">
                    <p style="margin:3em;">确定删除该文件吗？</p>

                    <div style="text-align:right;background-color:#eee;padding:5px;">
                        <button class="btn btn-default">确认</button>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <button class="btn btn-default" id="cancel">取消</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
<script src="../js/jquery-1.11.3.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script>
    window.onload = function () {
        $(".delete").click(function () {
            $("#cover").show();
            $("#pushWindow").show();
        });
        $("#cover").click(function () {
            $("#cover").hide();
            $("#pushWindow").hide();
        })
        $("#cancel").click(function () {
            $("#cover").hide();
            $("#pushWindow").hide();
        })
        if ($("body").height() < window.innerHeight) {
            $("#inn").css("height", window.innerHeight - 50);
        }
        else {
            $("#inn").css("height", document.body.scrollHeight - 50);
        }
    };
</script>
</html>