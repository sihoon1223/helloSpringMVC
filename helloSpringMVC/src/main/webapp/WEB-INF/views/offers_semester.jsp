<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/main.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table class="formtable">
			<tr >
				<th>년도</th>
				<th>학기</th>
				<th>이수학점</th>
				<th>상세보기</th>
			</tr>
		
			<c:forEach var="offer" items="${offers}">
				<tr>
					<td><c:out value="${offer.year}"></c:out></td>
					<td><c:out value="${offer.semester}"></c:out></td>
					<td><c:out value="${offer.point}"></c:out></td>
					<td><a href="${pageContext.request.contextPath}/subjects?year=${offer.year}&semester=${offer.semester}">링크</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>