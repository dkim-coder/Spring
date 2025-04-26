<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>공지사항</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #fff8e1;
        }

        .container {
            max-width: 700px;
            margin: 40px auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
        }

        h1 {
            text-align: center;
            color: #555;
        }

        form {
            margin-bottom: 20px;
        }

        input[type="text"], textarea {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            background: #ffc107;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background: #e0a800;
        }

        .notice-item {
            border-bottom: 1px solid #ddd;
            padding: 10px 0;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>공지사항</h1>
    <form action="${pageContext.request.contextPath}/notices" method="post">
        제목: <input type="text" name="title" required/><br/>
        내용: <textarea name="content" required></textarea><br/>
        <input type="hidden" name="release_date" value="${currentDate}"/>
        <input type="submit" value="공지사항 등록"/>
    </form>
    <div class="notice-list">
        <c:forEach var="notice" items="${noticeList}">
            <div class="notice-item">
                <h3>${notice.title}</h3>
                <p>${notice.content}</p>
                <p><small>발행일: ${notice.releaseDate}</small></p>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
