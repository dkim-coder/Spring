<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>댓글</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f5f5f5;
        }

        .container {
            max-width: 600px;
            margin: 30px auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
        }

        h1 {
            text-align: center;
            color: #333;
        }

        form {
            margin-bottom: 20px;
        }

        textarea {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            background: #dc3545;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background: #c82333;
        }

        .comment-item {
            border-bottom: 1px solid #ddd;
            padding: 10px 0;
        }

        .comment-item p {
            margin: 5px 0;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>댓글</h1>
    <form action="${pageContext.request.contextPath}/comments" method="post">
        댓글 내용: <textarea name="content" required></textarea><br/>
        <input type="hidden" name="boardNo" value="${boardNo}"/>
        <input type="hidden" name="userNo" value="${userNo}"/>
        <input type="submit" value="댓글 등록"/>
    </form>
    <div class="comment-list">
        <c:forEach var="comment" items="${commentList}">
            <div class="comment-item">
                <p>${comment.content}</p>
                <p><small>작성자: ${comment.userNo} / 작성일: ${comment.releaseDate}</small></p>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
