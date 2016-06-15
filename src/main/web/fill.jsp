
<%--
  Created by IntelliJ IDEA.
  User: Koche
  Date: 2016/5/20
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>填写订单</title>
</head>
<body>

<s:form action="register">
    <s:textfield disabled="true" label="医院名称" name="hospital"/>
    <s:textfield disabled="true" label="科室名称" name="department"/>
    <s:textfield disabled="true" label="医生名称" name="doctorName"/>
    <s:textfield disabled="true" label="就医时间" name="slot"/>
    <s:select list="contacts" name="contact"
              label="就诊人信息" listkey="id" listvalue="name"/>
    <s:submit value="提交"/>

</s:form>

</body>
</html>
