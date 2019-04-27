<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/huang_login/css/print.css" />
</head>
<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center">
  <tr>
    <td  class="biaoti" >注册信息表</td>
  </tr>
</table>
<table width="100%" border="0" cellspacing="1" cellpadding="2" bgcolor="#cccccc" class="tabtop13" >
	<tr>
	    <td  class="btbg font-center titfont" >账号</td>
	    <td  class="btbg font-center titfont">手机号码</td>
	    <td  class="btbg font-center titfont">权限id(1:超级管理员 3:管理员 5:用户)</td>
	<c:forEach items="${list}" var="arrayList" >
	<tr>
	   <td ><a href="user.jsp"><c:out value="${arrayList.username}" /></a></td>
	   <td ><c:out value="${arrayList.phonenumber}"/></td>
	   <td ><c:out value="${arrayList.right_id}"/></td>
	</tr>
	</c:forEach>
</table>

<table align= "center" >
    <tr>   
		<td bgcolor= "white" >
		<%=request.getAttribute("bar")%>
		<a href="user.jsp">返回</a>
		</td>	
 	</tr>
 </table>
</body>
</html>