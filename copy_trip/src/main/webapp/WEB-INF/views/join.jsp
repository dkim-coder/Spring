<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원 가입</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f7f7f7;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 400px;
            margin: 80px auto;
            background: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        form input[type="text"],
        form input[type="password"],
        form input[type="email"] {
            width: 100%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        form input[type="submit"] {
            width: 100%;
            padding: 10px;
            background: #28a745;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }

        form input[type="submit"]:hover {
            background: #218838;
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
<div class="container">
    <h1>회원 가입</h1>
    <form id="joinForm" action="${pageContext.request.contextPath}/users" method="post">
        <input type="text" name="id" placeholder="아이디" required/>
        <input type="password" name="password" placeholder="비밀번호" required/>
        <input type="text" name="user_name" placeholder="이름" required/>
        <input type="email" name="email" placeholder="이메일" required/>
        <input type="text" name="nickname" placeholder="닉네임" required/>
        <input type="submit" value="회원가입"/>
    </form>
    <div class="link">
        <p>이미 계정이 있으신가요? <a href="${pageContext.request.contextPath}/login.jsp">로그인 하러가기</a></p>
    </div>
</div>
<script>
    document.getElementById('joinForm').addEventListener('submit', function (e) {
        e.preventDefault(); // 기본 폼 제출 방지
        const form = e.target;
        const formData = new FormData(form);
        const data = {};
        formData.forEach((value, key) => {
            data[key] = value;
        });
        console.log(data);
        fetch(form.action, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json;charset=UTF-8'
            },
            body: JSON.stringify(data)
        })
            .then(response => {
                if (!response.ok) {
                    return response.text().then(text => {
                        throw new Error(text);
                    });
                }
                return response.json();
            })
            .then(result => {
                alert("회원가입 성공! 회원번호: " + result);
                window.location.href = "${pageContext.request.contextPath}/login.jsp";
            })
            .catch(error => {
                alert("회원가입 실패: " + error.message);

            });
    });
</script>
</body>
</html>
