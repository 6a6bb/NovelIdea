<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<center>该用户已存在!注册失败,稍后跳转回注册页面......</center>
	<%
		response.setHeader("refresh", "3;url=/huang_login/Register.jsp");
	%>

</body>
</html>