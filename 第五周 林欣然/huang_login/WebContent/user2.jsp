<%@ page import="com.huang.model.User" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户界面</title>
<link rel="stylesheet" type="text/css" href="/huang_login/css/user.css" />
<style type="text/css">
</style>
</head>
<body>        
		<div class="main">
			<div class="main-con">
				<ul>
					<li><a href="https://baidu.com/">百度一下</a></li>
					<li><a href="/huang_login/update.jsp">修改密码</a></li>
					<li><a href="changeright.jsp">修改权限</a></li>
					<li><a href="quit.jsp">退出</a></li>
				</ul>
				<div class="login">管理员 <br /> 
				<td align="center">用户名<br /><c:out value="${User.username}" /></td> <br /> 
		   		<td align="center">手机号<br /><c:out value="${User.phonenumber}" /></td>   
		   		</div>
			</div>
		</div>
</body>
</html>