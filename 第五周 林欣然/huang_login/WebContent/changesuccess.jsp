<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<center>权限修改成功,稍后跳转用户页面......</center>
<jsp:useBean id="regUser" class="com.huang.model.User" scope="session"  ></jsp:useBean>	
	<%
		//得到用户类型,便以正确转换页面
		int rid1=regUser.getright_id();
		if(rid1==1){
			response.setHeader("refresh", "3;url=/huang_login/user.jsp");
		}else if(rid1==3){
			response.setHeader("refresh", "3;url=/huang_login/user2.jsp");			
		}

	%>

</body>
</html>