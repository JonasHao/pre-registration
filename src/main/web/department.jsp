<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><s:property value="department.name"/></title>
</head>
<body>
<h1><s:property value="department.name"/></h1>

<h3>医生列表</h3>

<ul>
    <s:iterator value="department.doctors">
        <li>
            <s:url var="doctorUrl" action="get">
                <s:param name="id">
                    <s:property value="ID"/>
                </s:param>
            </s:url>

            <a href="<s:property value="#doctorUrl"/> ">
                <s:property value="ID"/>
                <s:property value="name"/>
                <s:property value="introduction"/>
                <s:property value="title"/>
            </a>

        </li>
    </s:iterator>
</ul>
</body>
</html>
