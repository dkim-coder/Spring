<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f2f2f2;
        }

        .login-container {
            max-width: 400px;
            margin: 100px auto;
            background: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
        }

        form {
            margin-top: 20px;
        }

        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 10px;
            background: #007BFF;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background: #0056b3;
        }

        .message {
            text-align: center;
            margin-top: 15px;
        }

        .link {
            text-align: center;
            margin-top: 15px;
        }

        .link a {
            color: #007BFF;
            text-decoration: none;
        }

        .link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="login-container">
    <h1>로그인</h1>
    <form action="${pageContext.request.contextPath}/users/login" method="post">
        <input type="text" name="id" placeholder="아이디" required/>
        <input type="password" name="password" placeholder="비밀번호" required/>
        <input type="submit" value="로그인"/>
    </form>
    <div class="message">
        <c:choose>
            <c:when test="${not empty user}">
                <p>환영합니다, ${user.user_name}님!</p>
            </c:when>
            <c:otherwise>
                <p>로그인 정보를 확인해주세요.</p>
            </c:otherwise>
        </c:choose>
    </div>
    <div class="link">
        <p>계정이 없으신가요? <a href="${pageContext.request.contextPath}/join.jsp">회원가입 하러가기</a></p>
    </div>
</div>
</body>
</html>
