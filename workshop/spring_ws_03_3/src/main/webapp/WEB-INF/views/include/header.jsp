<!-- /WEB-INF/views/include/header.jsp -->

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <%-- 페이지들이 가져갈 공통적인 내용들 위치 --%>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"/>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<style>
    header > #logo {
        width: 90px;
        margin-bottom: 8px;
        margin-left: 10px;
    }

    header > h1 {
        line-height: 50px;
        display: inline-block;
        height: 50px;
    }
</style>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="root" value="${pageContext.servletContext.contextPath }"/>
<div class="container">
    <!-- 전체 .container 시작 -->
    <header class="d-flex justify-content-center my-5 align-items-center">
        <h1 class="text-center">Welcome To SSAFY 도서관리</h1>
        <img src="${root }/resources/img/ssafy_logo.png" id="logo"/>
    </header>
    <div class="d-flex justify-content-end">
        <a href="${root }/index" class="mx-3">홈으로</a> |
        <!-- TODO: 07-1. login 여부에 따라 달라질 화면을 분석해보세요. -->
        <c:if test="${empty loginUser }">
            <form method="post" action="${root}/users/login">
                <div>
                    <input type="text" name="id" placeholder="아이디"/>
                    <input type="password" name="pass" placeholder="비밀번호"/>
                    <input type="submit" class="btn btn-primary" value="로그인"/>
                </div>
            </form>
        </c:if>
        <c:if test="${!empty loginUser }">
            <a href="#" class="mx-3">${loginUser.name }님 반갑습니다</a> |
            <a href="${root }/users/logout" class="mx-3">로그아웃</a>
        </c:if>
    </div>
    <hr/>
    <script type="text/javascript">
        const alertMsg =
        ${param.alertMsg} ||
        ${alertMsg}; // 메시지 자체에 ""가 포함되기 도 함
        if (alertMsg) {
            alert(alertMsg);
        }
        /*
                         html에서 작성하고 주석 처리 해 두는게 오히려 가독성이 좋을 수도.
<c:remove var="alertMsg" scope="session"/>
                     */
    </script>