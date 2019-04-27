<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>document</title>
<link rel="stylesheet" type="text/css" href="/huang_login/css/Register.css" />
<script type="text/javascript"
 src = "/huang_login/js/register.js">
</script>
</head>
<body>
	<img src="/huang_login/image/login.jpg">
	<div id="reg">
		<h1>用户信息</h1>
		<form   name="form1" action="Register" method="post" onsubmit="return check()">
			<p>
				<span>&nbsp;帐&nbsp;号&nbsp;：</span> <input type="text"
					name="username"value="${param.username}">
			</p>
			<p>
				<span>手机号码：</span> <input type="text"
					name="phonenumber"value="${param.phonenumber}">
			</p>
			<p>
				<span> &nbsp;密&nbsp;码&nbsp;：</span> <input type="password"
					name="password"value="${param.password}"></input>
			</p>
			<p>
				<button class="button" type="submit">立即注册</button>
			</p>
				<h4 style="color: red;">
		账号: 6-20位的数字英文组合<br> 密码：6-25位数字
	</h4>
		</form>
	</div>
</body>
</html>
