<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Koche
  Date: 2016/5/20
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>医生：<s:property value="doctor.name"/></title>
</head>
<body>
<h1><s:property value="doctor.name"/></h1>
<h3><s:property value="doctor.title"/></h3>
<p><s:property value="doctor.introduction"/></p>


<ul>
    <s:iterator value="doctor.capacities">
        <li>
            <s:url var="orderUrl" action="fill">
                <s:param name="doctorID"><s:property value="doctor.ID"/></s:param><s:param name="capacityID"><s:property value="id"/></s:param>
            </s:url>

            <a href="<s:property value="#orderUrl"/> ">
                    <%--<s:property value="year"/>年--%>
                    <%--<s:property value="month"/>月--%>
                    <%--<s:property value="day"/>日--%>
                    <%--<s:property value="hour"/>点--%>
                <s:property value="surplus"/>/
                <s:property value="total"/>
            </a>

        </li>
    </s:iterator>
</ul>

</body>
</html>
