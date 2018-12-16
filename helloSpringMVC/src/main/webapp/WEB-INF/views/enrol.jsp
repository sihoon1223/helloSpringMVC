<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<title>Insert title here</title>
</head>
<body>
	<sf:form method="post"
		action="${pageContext.request.contextPath}/createoffer"
		modelAttribute="offer">
		<table class="formtable">
			<tr>
				<td class="label">Year</td>
				<td><sf:input class="control" type="text" path="year"
						 readonly="readonly" /> <br/> <sf:errors
						class="error" path="year" /></td>
			</tr>
			<tr>
				<td class="label">Semester:</td>
				<td><sf:input class="control" type="text" path="semester"
						readonly="readonly" /> <br/> <sf:errors class="error"
						path="semester" /></td>
			</tr>
			<tr>
				<td class="label">Subject Code:</td>
				<td><sf:input class="control" type="text" path="code" />
					<br /> <sf:errors class="error" path="code" /></td>
			</tr>
			<tr>
				<td class="label">Offer Name:</td>
				<td><sf:input class="control" type="text" path="subjectName" /> <br/>
			</tr>
			<tr>
				<td class="label">Type:</td>
				<td><sf:input class="control" type="text" path="type" /> <br/>
					<sf:errors class="error" path="type" /></td>
			</tr>
			<tr>
				<td class="label">Grade:</td>
				<td><sf:input class="control" type="text"
						path="point" /> <br /> <sf:errors class="error" path="point" /></td>
			</tr>
			<tr>
				<td class="label"></td>
				<td><input class="control" type="submit" value="createoffer" /></td>
			</tr>
		</table>
	</sf:form>

</body>
</html>
