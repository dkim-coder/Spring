<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         import="com.ssafy.ws.dto.Movie" %>
<%@ page import=" java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>도서 등록 정보</title>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<h2>등록 도서 정보</h2>
<table border="1">
    <tr>
        <th>도서 제목</th>
        <th>저자</th>
        <th>가격</th>
        <th>설명</th>
    </tr>
    <c:forEach items="${movies}" var="movie">
        <tr>
            <td>${movie.title}</td>
            <td>${movie.director}</td>
            <td>${movie.genre }</td>
            <td>${movie.runningTime }</td>
        </tr>
    </c:forEach>
</table>
<a href="${root }/movie/regist">추가등록</a>
</body>
</html>