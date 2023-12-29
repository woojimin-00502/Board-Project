<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입 폼</title>
    <link rel="stylesheet" href="${path}/resources/signUpCss3.css">
    
    <script src="/resources/jquery-3.7.1.js"></script>
    <script src="/resources/page/2.js"></script>
    <script src="/resources/page/phone.js"></script>
    
    
    
</head>
<body>
    
    <div class="member">
        <!-- 1. 로고 -->
        <h1>Project_Board</h1>

        <!-- 2. 필드 -->
        <div class="field">
            <b>아이디</b>
            <span><input type="text" name="id"></span>
        </div>
        <div class="field">
            <b>비밀번호</b>
            <input class="userpw" type="password" name="pw">
        </div>
        <div class="field">
            <b>비밀번호 재확인</b>
            <input class="userpw-confirm" type="password" name="repw">
        </div>
        <div class="field">
            <b>이름</b>
            <input type="text" name="name">
        </div>

        <!-- 3. 필드(생년월일) -->
        <div class="field birth">
            <b>생년월일</b>
            <div>
                <input type="number" placeholder="년(4자)" name="year">                
                <select>
                    <option value="">1월</option>
                    <option value="">2월</option>
                    <option value="">3월</option>
                    <option value="">4월</option>
                    <option value="">5월</option>
                    <option value="">6월</option>
                    <option value="">7월</option>
                    <option value="">8월</option>
                    <option value="">9월</option>
                    <option value="">10월</option>
                    <option value="">11월</option>
                    <option value="">12월</option>
                </select>
                <input type="number" placeholder="일" name="day">
            </div>
        </div>
		
        <!-- 4. 필드(성별) -->
        <div class="field gender">
            <b>성별</b>
            <div>
                <label><input type="radio" name="gender">남자</label>
                <label><input type="radio" name="gender">여자</label>
                <label><input type="radio" name="gender">선택안함</label>
            </div>
        </div>

        <!-- 5. 이메일_전화번호 -->
        <div class="field">
            <b>본인 확인 이메일<small>(선택)</small></b>
            <input type="email" placeholder="선택입력">
            <select>
            <option value=""></option>
            <option value="">@projectboard.com</option>
            <option value="">@gmail.com</option>
            <option value="">@naver.com</option>
            <option value="">@hanmail.net</option>
            </select>
        </div>
        
        <div class="field tel-number">
            <b>휴대전화</b>
            <select>
                <option value="">대한민국 +82</option>
            </select>
            <div>
                <input type="tel" placeholder="전화번호 입력" name="ph1" id="ph_1">
                <input type="button" value="인증번호 받기" id="phoneChk" onclick="phoneClick()">
            </div>
            <div>
            <input type="number" placeholder="인증번호를 입력하세요" id="ph2">
            <input type="button" value="인증확인" id="phoneChk2" onclick="phoneClick2()">
            </div>
        </div>

        <!-- 6. 가입하기 버튼 -->
        <input type="submit" value="가입하기" onclick="member()"  style="cursor:pointer">

    </div>
        <!-- 7. 푸터 -->
        <div class="member-footer">
			<div class="footer-wrap"> 
                <a href="#none">이용약관</a>
                <a href="#none">개인정보처리방침</a>
                <a href="#none">책임의 한계와 법적고지</a>
                <a href="#none">회원정보 고객센터</a>
			</div>

                <a href="#none">Project_Board</a>
        </div>
</body>
</html>