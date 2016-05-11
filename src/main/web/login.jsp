<%--
  Created by IntelliJ IDEA.
  User: Koche
  Date: 2016/4/22
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<s:form action="login" validate="true">
    <s:textfield name="username"  label="用户名" maxLength="20"  required="true"/>
    <s:password name="password" label="密码" maxLength="16" required="true"/>
    <s:iterator value="errors">
        <s:property/>
    </s:iterator>
    <s:submit value="登陆"/>
</s:form>
</body>
</html>
