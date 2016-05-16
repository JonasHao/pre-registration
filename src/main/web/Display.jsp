<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>预约下单</title>
</head>

<body>

<ul>
    <s:iterator status="stat" value="hospitals">
        <li>
            <s:property value="ID"/>
            <s:property value="name"/>
            <s:property value="description"/>
        </li>
        <s:iterator value="departments">
            <s:property value="[0].id"/>
            <s:property value="[0].name"/>
            <s:property value="[0].description"/>
        </s:iterator>
    </s:iterator>

</ul>


<s:form action="register">
    <s:select value="contactID" list="${applicationScope.contacts}" listkey="idNo" listvalue="name"/>
    <s:date name="reserveDate"/>
    <s:textfield name="doctorID" value="doctor ID"/>
    <s:submit value="提交"/>
</s:form>


</body>
</html>
