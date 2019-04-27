<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%session.invalidate(); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>Document</title>
<link rel="stylesheet" type="text/css" href="/huang_login/css/Login.css" />
<script type="text/javascript" src="/huang_login/js/login.js"></script>
</head>
<img id="img" src="/huang_login/image/555.png">
<body>
	<div id="login" >
		<h1>用户登陆</h1>
		<form name="form2" action="loginservlet" method="post"
			onsubmit="return check()">
			<p>
				<span>账号：</span> <input type="text" name="username"
					value="${param.username}"></input>
			</p>
			<p>
				<span>密码：</span> <input type="password" name="password"
					value="${param.password}"></input>
			</p>
			
			<table align="center">
				<tr>
					<td><span>验证码：</span><input type="text" name="identifycode" style="height:20px;width:130px;" class="code"
						value="${param.code}"></input></td>
					<td></td>									
					<td>
						<img border=5 style="cursor:pointer;" src="checkcodeservlet" align="bottom" title="看不清可单击图片刷新" onclick="this.src='checkcodeservlet?d='+Math.random();"><br>
					</td>						
				</tr>
			</table>
			<p>
				<button class="button2" type="submit">立即登陆</button>
			</p>
			<table align="center">
				<tr>
					<a href="/huang_login/Register.jsp">注册账户</a>		
				</tr>
			</table>
			<table align="center">
				<tr>
					<a href="/huang_login/trip.jsp">游客	</a>			
				</tr>
				<tr>
					<a href="/huang_login/Getback.jsp">	找回密码</a>			
				</tr>
			</table>
		<h4 style="color: red;">
		账号: 6-20位的数字英文组合<br> 密码：6-25位数字
		</h4>
		</form>
	</div>
</body>
</html>