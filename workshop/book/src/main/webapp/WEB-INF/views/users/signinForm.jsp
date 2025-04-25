<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Insert title here</title>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<h1>login</h1>
<form action="${root}/users/signin" method="post" class="m-3">

    <div class="mb-3 row">
        <label for="email" class="col-sm-2 col-form-label">이메일</label>
        <div class="col-sm-10">
            <!-- TODO: 08-1. rememberMe 쿠키의 값으로 email을 설정하세요.-->
            <input type="email" id="email" name="email" placeholder="email 입력"
                   class="form-control" required value="${cookie.rememberMe.value}"/>
        </div>
    </div>

    <div class="mb-3 row">
        <label for="password" class="col-sm-2 col-form-label">비밀번호</label>
        <div class="col-sm-10">
            <input type="password" name="password" id="password" class="form-control" required/>
        </div>
    </div>

    <div class="d-flex justify-content-end align-items-center">
        <div class="form-check">
            <!-- TODO: 08-2. rememberMe 쿠키의 존재 여부에 따라 rememberMe의 checked를 설정하세요.-->
            <input type="checkbox" value="on" name="rememberMe" id="remember-me" class="form-check-input"
            ${cookie.rememberMe!=null?"checked":"" } />
            <label for="remember-me" class="form-check-label">id 기억하기</label>
        </div>
        <button type="submit" class="btn btn-primary ms-3">로그인</button>
    </div>
</form>
<%@ include file="/WEB-INF/views/include/footer.jsp" %>
</body>
</html>
