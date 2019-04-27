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
<script type="text/javascript" src="/huang_login/js/change.js"></script>
</head>
<body>
	<img src="/huang_login/image/login.jpg">
	<div id="reg">
		<h1>更改权限</h1>
		<form name="form88" action="Changerightservlet" method="post"
			onsubmit="return check()">
			<%request.setCharacterEncoding("UTF-8"); %>
			<p>
				<span>用&nbsp;户&nbsp;名：</span> <input type="text" name="username"
					value="${param.username}">
			</p>
			<p>
				<span>新&nbsp;权&nbsp;限：</span> <input type="text"
					name="newRight" value="${param.newRight}"></input>
			</p>
			<p>
				<button class="button" type="submit">确认修改</button>
			</p>
				<h4 style="color: red;">
			账号: 6-20位的数字英文组合<br> 权限：用户 管理员 超级管理员
			</h4>
			<a href="javascript:history.back(-1)">返回上一页</a>
		</form>
	</div>
</body>
</html>