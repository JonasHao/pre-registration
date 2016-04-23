<%--
  Created by IntelliJ IDEA.
  User: Koche
  Date: 2016/4/22
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>登陆</title>
</head>
<body>
<s:form action="login" validate="false">
    <s:textfield label="User Name"  required="false"/>
    <s:password label="Password" required="false"/>
    <s:iterator value="errors">
        <s:property/>
    </s:iterator>
    <s:submit value="login"/>
</s:form>
</body>

</html>
