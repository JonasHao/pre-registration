<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Koche
  Date: 2016/5/11
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<s:iterator status="stat" value="hospitals">
    <s:property value="ID"/>
    <s:property value="name"/>
    <s:property value="description"/>
    <s:iterator value="departments">
        <s:property value="id"/>
        <s:property value="name"/>
        <s:property value="description"/>
    </s:iterator>
</s:iterator>
</body>
</html>
