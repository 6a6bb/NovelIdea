<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
	<body>
		<center>
			信息有误！密码找回失败,稍后跳转原页面......
		</center>
		<% response.setHeader("refresh","3;url=/huang_login/Getback.jsp");%> 
	</body>
</html>