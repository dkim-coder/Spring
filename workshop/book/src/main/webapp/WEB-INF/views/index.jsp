<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SSAFY 도서관리</title>
</head>
<body>

<%@ include file="/WEB-INF/views/include/header.jsp" %>
<c:if test="${!empty loginUser }">
    <a href="${root}/books/regist"> 도서 등록 </a> <br/>
</c:if>
<a href="${root}/books/list"> 도서 목록</a>
</body>
</html>