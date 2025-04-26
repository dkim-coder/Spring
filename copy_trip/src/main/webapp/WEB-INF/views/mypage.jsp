<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>마이페이지</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f9f9f9;
        }

        .container {
            max-width: 600px;
            margin: 50px auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #444;
        }

        .profile {
            margin: 20px 0;
        }

        .profile img {
            max-width: 100px;
            border-radius: 50%;
        }

        .profile p {
            font-size: 16px;
        }

        form {
            margin-top: 20px;
        }

        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        input[type="submit"] {
            padding: 10px 20px;
            background: #007BFF;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background: #0056b3;
        }

        a {
            color: #007BFF;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>마이페이지</h1>
    <div class="profile">
        <p>ID: ${user.id}</p>
        <p>이름: ${user.user_name}</p>
        <p>이메일: ${user.email}</p>
        <p>닉네임: ${user.nickname}</p>
        <c:if test="${not empty user.image}">
            <img src="${user.image}" alt="프로필 이미지"/>
        </c:if>
    </div>
    <h2>닉네임 수정</h2>
    <form action="${pageContext.request.contextPath}/users/${user.no}/nickname" method="post">
        <input type="hidden" name="_method" value="PUT"/>
        새 닉네임: <input type="text" name="nickname" required/>
        <input type="submit" value="수정"/>
    </form>
    <h2>회원 탈퇴</h2>
    <form action="/users/${user.no}" method="post">
        <input type="hidden" name="_method" value="DELETE"/>
        <input type="submit" value="회원 탈퇴"/>
    </form>
    <p><a href="index.jsp">메인 페이지로 이동</a></p>
</div>
</body>
</html>
