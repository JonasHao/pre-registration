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
    <title>医院列表</title>
</head>
<body>

<ul>
    <s:iterator value="hospitals">
        <li>
            <s:url var="hospitalUrl" action="hospital">
                <s:param name="hospitalID">
                    <s:property value="ID"/>
                </s:param>
            </s:url>

            <a href="<s:property value="#hospitalUrl"/>">
                <s:property value="ID"/>
                <s:property value="name"/>
                <s:property value="description"/>
            </a>
        </li>
    </s:iterator>
</ul>

</body>
</html>
