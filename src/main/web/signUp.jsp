<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>注册</title>
</head>
<body>

<s:form action="signUp" validate="true" >
    <s:textfield name="username" label="用户名" maxLength="20" required="true"/>
    <s:password name="password" label="密码" maxLength="16" required="true"/>
    <s:password name="passwordAgain" label="确认密码" maxLength="16" required="true"/>
    <s:textfield name="phone" label="电话" maxLength="15" required="true"/>
    <s:textfield name="email" label="电子邮箱"/>

    <s:submit value="注册"/>
</s:form>
</body>
</html>
