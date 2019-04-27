<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Document</title>
<link rel="stylesheet" type="text/css"
	href="/huang_login/css/Register.css">
<script type="text/javascript" src="/huang_login/js/getback.js"></script>
</head>
<body>
	<img src="/huang_login/image/login.jpg">
	<div id="reg">
		<h1>用户信息</h1>
		<form name="form4" action="GetBackServlet" method="post"
			onsubmit="return check()">
			<p>
				<span>用&nbsp;户&nbsp;名：</span> <input type="username" name="username"
					value="${param.username}">
			</p>
			<p>
				<span>手&nbsp;机&nbsp;号：</span> <input type="phonenumber"
					name="phonenumber" value="${param.phonenumber}">
			</p>
			<p>
				<span>新&nbsp;密&nbsp;码：</span> <input type="password"
					name="newPassword" value="${param.newPassword}"></input>
			</p>
			<p>
				<button class="button" type="submit">确认修改</button>
			</p>
			<tr>
					<a href="/huang_login/Login.jsp">返回</a>			
			</tr>
				<h4 style="color: red;">
			账号: 6-20位的数字英文组合<br> 密码：6-25位数字
			</h4>
		</form>
	</div>
</body>
</html>