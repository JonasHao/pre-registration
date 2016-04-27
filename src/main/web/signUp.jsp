<%--
  Created by IntelliJ IDEA.
  User: Koche
  Date: 2016/4/27
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<s:form action="signUp" validate="true" >
    <s:textfield name="username" label="用户名"/>
    <s:password name="password" label="密码"/>
    <s:password label="确认密码"/>
    <s:textfield name="name" label="真实姓名"/>
    <s:textfield name="id" label="身份证"/>
    <s:textfield name="phone" label="电话"/>

    <s:iterator value="errors">
        <s:property/>
    </s:iterator>
    <s:submit value="注册"/>
</s:form>
</body>
</html>
