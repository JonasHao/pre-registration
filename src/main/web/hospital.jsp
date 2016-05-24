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
    <title><s:property value="hospital.name"/></title>
</head>
<body>
<h1><s:property value="hospital.name"/></h1>

<h3>科室列表</h3>

<ul>
    <s:iterator value="hospital.departments">
        <li>
            <s:url var="departmentUrl" action="department">
                <s:param name="id">
                    <s:property value="id"/>
                </s:param>
            </s:url>

            <a href="<s:property value="#departmentUrl"/> ">
                <s:property value="id"/>
                <s:property value="name"/>
                <s:property value="description"/>
            </a>

        </li>
    </s:iterator>
</ul>
</body>
</html>
