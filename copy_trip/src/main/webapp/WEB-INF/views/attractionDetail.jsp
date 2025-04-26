<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>명소 상세 정보</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f7f7f7;
            margin: 0;
            padding: 20px;
        }

        .container {
            max-width: 800px;
            margin: 20px auto;
            background: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .title {
            font-size: 28px;
            color: #333;
            margin-bottom: 10px;
        }

        .image {
            max-width: 100%;
            border-radius: 8px;
            margin-bottom: 20px;
        }

        .info {
            font-size: 16px;
            color: #555;
            line-height: 1.6;
        }

        .info p {
            margin: 8px 0;
        }

        .back-link {
            margin-top: 20px;
            display: block;
            text-decoration: none;
            color: #007BFF;
        }

        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="title">${attraction.title}</div>
    <c:if test="${not empty attraction.firstImage1}">
        <img class="image" src="${attraction.firstImage1}" alt="${attraction.title}"/>
    </c:if>
    <div class="info">
        <p><strong>콘텐츠 번호:</strong> ${attraction.contentId}</p>
        <p><strong>콘텐츠 타입:</strong> ${attraction.contentTypeId}</p>
        <p><strong>지역 코드:</strong> ${attraction.areaCode}</p>
        <p><strong>구군 코드:</strong> ${attraction.siGunGuCode}</p>
        <p><strong>전화번호:</strong> ${attraction.tel}</p>
        <p><strong>주소:</strong> ${attraction.addr1} ${attraction.addr2}</p>
        <p><strong>홈페이지:</strong> <a href="${attraction.homepage}" target="_blank">${attraction.homepage}</a></p>
        <p><strong>설명:</strong> ${attraction.overview}</p>
    </div>
    <a class="back-link" href="${pageContext.request.contextPath}/attractions?areaCode=1&contentTypeId=1">목록으로 돌아가기</a>
</div>
</body>
</html>
