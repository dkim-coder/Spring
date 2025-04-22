<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"
		 import="com.ssafy.ws.model.dto.Book" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>도서 등록 정보</title>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<h2>등록 도서 정보</h2>
<%--  Book book =(Book)request.getAttribute("book"); --%>
<table  border="1">
	<tr>
		<th>항목</th>
		<th>내용</th>
	</tr>
	<tr>
		<td>도서번호</td>
		<td> ${book.isbn}</td>
	</tr>
	<tr>
		<td>도서명</td>
		<td>${book.title }</td>
	</tr>
	<tr>
		<td>저자</td>
		<td>${book.author }</td>
	</tr>
	<tr>
		<td>가격</td>
		<td>${book.price }</td>
	</tr>
	<tr>
		<td>설명</td>
		<td>${ book.content}</td>
	</tr>
</table>
<c:if test="${!empty loginUser }" >
	<a href="${root}/regist">추가등록</a> &nbsp;&nbsp;
</c:if>
<a href="${root}/list">도서목록</a>
</body>
</html>