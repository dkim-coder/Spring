<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.ssafy.ws.dto.Book" %>
<%@ page import =" java.util.List" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 등록 정보</title>
</head>
<body>
	<%@ include file="/WEB-INF/views/include/header.jsp" %>
	<h2>등록 도서 정보</h2>
	<table  border="1">
		<tr>
				<th>도서 제목</th>
				<th>저자</th>
				<th>가격</th>
				<th>설명</th>
		</tr>
		<c:forEach items="${books}"  var="book">
			<tr>
					<td><a href="${root}/books/view?isbn=${book.isbn}" >${book.title}</td>
					<td>${book.author}</td>
					<td>${book.price }</td>
					<td>${book.desc }</td>			
			</tr>
		</c:forEach>			
	</table>
	<c:if test="${!empty loginUser }" >
    	<a href="${root}/books/regist">추가등록</a>
    </c:if>
</body>
</html>