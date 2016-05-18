<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Koche
  Date: 2016/5/17
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>科室列表</title>
</head>
<body>
<ul>
    <s:iterator value="departments">
        <li>
            <s:property value="id"/>
            <s:property value="name"/>
            <s:property value="description"/>
        </li>
    </s:iterator>
</ul>
</body>
</html>
