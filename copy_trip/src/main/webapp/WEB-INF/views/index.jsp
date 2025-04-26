<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ENJOY_TRIP - 메인 페이지</title>
    <style>
        /* 기존 스타일 그대로 유지 */
        .navbar {
            background-color: #007BFF;
            overflow: hidden;
        }

        .navbar a {
            float: left;
            display: block;
            color: #ffffff;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
        }

        .navbar a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="navbar">
    <a href="${pageContext.request.contextPath}/attractions/map">지역별 여행지</a>
    <a href="${pageContext.request.contextPath}/travelPlans">나의 여행계획</a>
    <a href="${pageContext.request.contextPath}/boards">게시판</a>
    <a href="${pageContext.request.contextPath}/reviews">리뷰조회</a>
    <c:choose>
        <c:when test="${not empty sessionScope.user}">
            <a href="${pageContext.request.contextPath}/users/${sessionScope.user.no}">마이페이지</a>
            <!-- 로그아웃 링크를 /users/auth/logout으로 변경 -->
            <a href="${pageContext.request.contextPath}/users/auth/logout">로그아웃</a>
        </c:when>
        <c:otherwise>
            <a href="${pageContext.request.contextPath}/login.jsp">로그인</a>
            <a href="${pageContext.request.contextPath}/join.jsp">회원가입</a>
        </c:otherwise>
    </c:choose>
</div>
<div class="content">
    <h1>ENJOY_TRIP에 오신 것을 환영합니다!</h1>
    <p>다양한 여행 정보를 확인하고, 나만의 여행 계획을 세워보세요.</p>
</div>
</body>
</html>
