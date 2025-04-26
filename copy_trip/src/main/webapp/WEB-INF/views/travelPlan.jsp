<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>여행 계획</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f0f8ff;
        }

        .container {
            max-width: 600px;
            margin: 40px auto;
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

        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            background: #17a2b8;
            color: #fff;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background: #138496;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>나만의 여행 계획</h1>
    <form action="${pageContext.request.contextPath}/travelPlans" method="post">
        여행 경로 및 일정 (예: "100,101,102"):<br/>
        <input type="text" name="plans" required/><br/>
        <input type="hidden" name="userNo" value="${userNo}"/>
        <input type="submit" value="여행 계획 등록"/>
    </form>
    <c:if test="${not empty travelPlan}">
        <h2>등록된 여행 계획</h2>
        <p>${travelPlan.plans}</p>
    </c:if>
</div>
</body>
</html>
