<%--
  Created by IntelliJ IDEA.
  User: Koche
  Date: 2016/4/22
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
<h2>Welcome</h2>
<s:if test="#session.user!=null">
    <h2>Hello <s:property value="#session.user.name"/></h2>
</s:if>
</body>
</html>
