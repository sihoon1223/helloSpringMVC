<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<p>
		<a href="${pageContext.request.contextPath}/offers_semester">1. 학기별 이수 학점 조회</a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/enrol">2. 수강 신청하기</a>
	</p>
	<p>
		<a href="${pageContext.request.contextPath}/select_enrol?year=2018&semester=2">3. 수강 신청 조회 메뉴</a>
	</p>
	<c:if test="${pageContext.request.userPrincipal.name !=null }">
		<a href="javascript:document.getElementById('logout').submit()">Logout</a>
	</c:if>
	
	<form id="logout" action="<c:url value="/logout" />" method="post">
		<input type="hidden" name="${_csrf.parameterName }"
			value="${_csrf.token }" />
	</form>
	
	<c:if test="${success != null}">
		<br/>
		<c:out value="성공!"></c:out>
		<br/>
	</c:if>
	
</body>
</html>

