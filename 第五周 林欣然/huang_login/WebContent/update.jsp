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
<script type="text/javascript" src="/huang_login/js/updatepassword.js"></script>

</head>
<body>
	<c:if test="${ empty user }">
		<center>
			<h1>您还未登录，不能访问此页面</h1>
			<h3>
				点击<a href="/huang_login/Login.jsp">登录</a>或者<a
					href="/huang_login/Register.jsp">注册</a>
			</h3>
		</center>
	</c:if>
	<c:if test="${not empty user }">

	<img src="/huang_login/image/login.jpg">
	<div id="reg">
		<h1>用户信息</h1>
		<form name="form3" action="updateservlet" method="post"
			onsubmit="return check()">
			<p>
				<span>用&nbsp;户&nbsp;名：</span> <input type="username" name="username"
					value="${param.username}">
			</p>
			<p>
				<span>原&nbsp;密&nbsp;码：</span> <input type="password"
					name="oldPassword" value="${param.oldPassword}">
			</p>
			<p>
				<span>新&nbsp;密&nbsp;码：</span> <input type="password"
					name="newPassword" value="${param.newPassword}"></input>
			</p>
			<p>
				<button class="button" type="submit">确认修改</button>
			</p>
			<a href="javascript:history.back(-1)">返回上一页</a>
			<h4 style="color: red;">
			账号: 6-20位的数字英文组合<br> 密码：6-25位数字
			</h4>
		</form>
	</div>
	</c:if>
</body>
</html>