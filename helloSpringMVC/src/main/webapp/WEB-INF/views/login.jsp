<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">

</head>
<body onload='document.f.username.focus();'>
	<h3>Custom Login with username and password</h3>
	<c:if test="${not empty logoutMsg}">
		<!--로그아웃 성공시 로그아웃 메세지 -->
		<div style="color: #0000ff">
			<h3>${logoutMsg}</h3>
		</div>
	</c:if>

	<form name='f' action="<c:url value="/login"/>" method='POST'>

		<c:if test="${not empty errorMsg}">
			<!-- 에러메세지 null 아니면  출력 -->
			<div style="color: #ff0000">
				<h3>${errorMsg}</h3>
			</div>
		</c:if>
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login" /></td>
			</tr>
			 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</table>
	</form>
</body>
</html>