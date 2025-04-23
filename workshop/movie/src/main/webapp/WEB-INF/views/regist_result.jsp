<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="com.ssafy.ws.dto.Movie"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 응답</title>
</head>
<body>
	<h1>영화 등록 결과</h1>
	<h2>지금까지 등록한 영화 수 :</h2>
	<h2>등록 영화 정보</h2>
	
	<table border="1">
		<tr>
			<th>항목</th>
			<th>내용</th>
		</tr>
		<tr>
			<td>영화 제목</td>
			<td>${movie.title}</td>
		</tr>
		<tr>
			<td>감독</td>
			<td>${movie.director}</td>
		</tr>
		<tr>
			<td>장르</td>
			<td>${movie.genre}</td>
		</tr>
		<tr>
			<td>상영 시간</td>
			<td>${movie.runningTime}</td>
		</tr>
	</table>
	<a href="${pageContext.servletContext.contextPath }/regist">추가등록</a>
	<a href="${pageContext.servletContext.contextPath }/list">영화목록</a>
</body>
</html>