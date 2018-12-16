<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table class="formtable">
			<tr>
				<th>수강년도</th>
				<th>학기</th>
				<th>교과코드</th>
				<th>교과목명</th>
				<th>구분</th>
				<th>학점</th>	
			</tr>
		
			<c:forEach var="offer" items="${offers}">
				<tr>
					<td><c:out value="${offer.year}"></c:out></td>
					<td><c:out value="${offer.semester}"></c:out></td>
					<td><c:out value="${offer.code}"></c:out></td>
					<td><c:out value="${offer.name}"></c:out></td>															
					<td><c:out value="${offer.type}"></c:out></td>
					<td><c:out value="${offer.point}"></c:out></td>
				</tr>
			</c:forEach>

	</table>
</body>
</html>