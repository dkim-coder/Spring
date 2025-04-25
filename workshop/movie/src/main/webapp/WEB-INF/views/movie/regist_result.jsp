<%@ page language="java" contentType="text/html; charset=UTF-8"
         import="com.ssafy.ws.dto.Movie" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>도서 등록 정보</title>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

<h1>영화 등록 결과</h1>

<h2>지금까지 등록한 영화 수 : ${movieCount}</h2>
<h2>등록 영화 정보</h2>
<% Movie movie = (Movie) request.getAttribute("movie"); %>
<table border=1>
    <tr>
        <th>항목</th>
        <th>내용</th>
    </tr>
    <tr>
        <td>제목</td>
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
        <td>상영시간</td>
        <td>${movie.runningTime}</td>
    </tr>
</table>
<a href="${root }/movie/regist">추가등록</a>
<a href="${root }/movie/list">영화 목록</a>
</body>
</html>