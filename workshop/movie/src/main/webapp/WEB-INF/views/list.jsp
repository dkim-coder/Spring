<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.ssafy.ws.dto.Movie"%>
<%@ page import=" java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 목록 정보</title>
</head>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<body>
	<h1>영화 목록</h1>
	<h2>지금까지 등록한 영화 수 :</h2>

	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>감독</th>
			<th>장르</th>
			<th>상영시간</th>
		</tr>
		<c:forEach items="${movies }" var="movie">
			<tr>
				<td>${movie.id}</td>
				<td>${movie.title}</td>
				<td>${movie.director}</td>
				<td>${movie.genre}</td>
				<td>${movie.runningTime}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.servletContext.contextPath }/regist">추가등록</a>
</body>
</html>