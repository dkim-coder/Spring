<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>SSAFY 영화 관리</title>
    <style>
        label {
            display: inline-block;
            width: 80px;
        }

        textarea {
            width: 100%;
        }
    </style>
</head>
<body>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

<h1>SSAFY 영화 관리</h1>
<form method="post" action="${root }/movie/regist">
    <fieldset>
        <legend>영화 입력</legend>
        <label for="title">제목</label>
        <input type="text" id="title" name="title"><br>
        <label for="director">감독</label>
        <input type="text" id="director" name="director"><br>
        <label for="genre">장르</label>
        <input type="text" id="genre" name="genre"><br>
        <label for="runningTime">상영 시간</label>
        <input type="number" id="runningTime" name="runningTime"><br>
        <br>
        <input type="submit" value="등록">
        <input type="reset" value="초기화">
</form>
</body>
</html>