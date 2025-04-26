<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시판</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f2f2f2;
        }

        .container {
            max-width: 800px;
            margin: 20px auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
        }

        h1 {
            color: #333;
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
            background: #007BFF;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background: #0056b3;
        }

        .board-item {
            border-bottom: 1px solid #ddd;
            padding: 10px 0;
        }

        .board-item h3 {
            margin: 0;
        }

        .board-item p {
            margin: 5px 0;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>게시판</h1>
    <form action="${pageContext.request.contextPath}/boards" method="post">
        제목: <input type="text" name="title" required/><br/>
        내용: <textarea name="content" required></textarea><br/>
        <input type="hidden" name="userNo" value="${userNo}"/>
        <input type="submit" value="게시글 등록"/>
    </form>
    <div class="board-list">
        <c:forEach var="board" items="${boardList}">
            <div class="board-item">
                <h3>${board.title}</h3>
                <p>${board.content}</p>
                <p><small>작성자: ${board.userNo} / 날짜: ${board.relaseDate}</small></p>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
