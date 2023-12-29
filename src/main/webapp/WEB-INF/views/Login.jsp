<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" >
<title>Insert title here</title>
<link href="${path}/resources/NewFile.css?after" rel="stylesheet">

<script src="/resources/jquery-3.7.1.js"></script>
<script src="${path}/resources/page/Login.js"></script>
</head>
<body>

<div id="center">
    <div class="login-wrapper">
        <h2>Project_Board</h2>
        <form method="post" id="login-form">
            <input type="text" name="userid" placeholder="Email" id="userid">
            <input type="password" name="passwd" placeholder="Password" id="passwd">
            <label for="remember-check">
                <input type="checkbox" id="remember-check" name="save_id">&nbsp 아이디 저장하기
            </label>
            <label for="pwremember-check"> &nbsp&nbsp&nbsp
           		<input type="checkbox" id="pwremember-check"> &nbsp 비밀번호 저장하기
            </label>
             <input type="submit" value="Login" style="cursor:pointer" id="btnLogin" onclick="f_loginCheck()">
             <hr>
			<div class="newcustomer"><a href="Resist.jsp">회원가입</a></div>
        </form>
    </div>
 </div>
</body>
</html>