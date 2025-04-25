<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>영화정보사이트</title>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

<!-- 메인화면을 구현하세요. -->
<h1>영화관리 Spring Boot </h1>
<a href="${root }/movie/regist">영화 등록</a>
<a href="${root }/movie/list">영화 목록</a>
</body>
</html>
</html>