<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>

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
