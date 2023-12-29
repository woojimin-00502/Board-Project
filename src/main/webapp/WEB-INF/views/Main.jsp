<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MainPage</title>
<link href="${path}/resources/css/Main.css?after" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>
<body>
    <div class="main">
        <div class="header">
            <div class="logo">
                <h2>Project_Board</h2>
            </div>

            <div class="user">
                <div class="ID">
                    userID
                </div>
                <div class="logout">
                    <a href="로그인페이지">로그아웃</a>
                </div>
            </div>
        </div>

        <div class="banner">
            <a href="">Banner</a>
        </div>

        <div class="menu">
            <div class="icon">
                <div class="home_icon">
                    <a href="#"><img src="${path}/resources/images/free-icon-home-3648601.png" alt="홈"></a>
                </div>
                <div class="board_icon">
                    <img src="${path}/resources/images/free-icon-board-8224872.png" alt="게시물 작성">
                </div>
                <div class="mypage_icon">
                    <a href="마이페이지이동"><img src="${path}/resources/images/free-icon-user-5264565.png" alt="마이페이지"></a>
                </div>
            </div>
            <div class="search">
                <div class="search_icon">
                    <input type="text" class="searchinput" id="searchinput" style="display: none;">
                    <img src="${path}/resources/images/free-icon-search-interface-symbol-54481.png" alt="검색" id="search_icon">
                </div>
            </div>
        </div>

        <div class="body">
         
         
           <ul id="body_list"> 
               <li data-num="">
                   <div class="board">
         
                       <div class="profile">
                           <img class="id_img" src="${path}/resources/images/man.png" alt="프로필">
                           <div class="id_name">
                               <!-- userId -->    
                           </div>
                           <div class="time">
                               <!-- 몇 분 전-->
                           </div>
                       </div>
   
   
                       <div class="image">
                           <img class="image" src="" alt="게시 이미지">
                       </div>
   
                       <div class="nav">
                           <div class="heart">
                               <div class="like_icon" id="like_icon">
                                   <svg xmlns="http://www.w3.org/2000/svg" height="16" width="16" viewBox="0 0 512 512"><path d="M47.6 300.4L228.3 469.1c7.5 7 17.4 10.9 27.7 10.9s20.2-3.9 27.7-10.9L464.4 300.4c30.4-28.3 47.6-68 47.6-109.5v-5.8c0-69.9-50.5-129.5-119.4-141C347 36.5 300.6 51.4 268 84L256 96 244 84c-32.6-32.6-79-47.5-124.6-39.9C50.5 55.6 0 115.2 0 185.1v5.8c0 41.5 17.2 81.2 47.6 109.5z"></path></svg>
                               </div>
                               <div class="heart_num">
                                   <!-- 좋아요 갯수 -->
                               </div>
                           </div>
                           <div class="comment" id="comment_icon">
                               <img src="${path}/resources/images/free-icon-chat-8316205.png" alt="댓글">
                               <div class="comment_num">
                                   <!--댓글 수-->
                               </div>
                           </div>
                           <div class="add_comment">
                               <!--댓글 달기.. / 댓글 접기..-->
                               댓글달기..
                           </div>
                       </div>
   
   
                       <div class="wrap" id="wrap" style="display: none;">
                           <div class="comment_wrap">
                               <ul class="list" id="list">
                                   <li>
                                       <div class="first_comment">
                                           <img src="${path}/resources/images/man.png" alt="프로필">
                                           <div class="com_wrap">
                                               <div class="userId">userId</div>
                                               <div class="text_comment">
                                                   <!--댓글 내용 (input에서 보낸 텍스트)-->
                                               </div>
                                               <div class="comment_nav">
                                                   <div class="time_comment">
                                                       <!--몇 분 전 -->
                                                   </div>
                                                   <div class="add_Comment">
                                                       <!--댓글달기 / 댓글접기-->
                                                   </div>
                                               </div>
                                           </div>
                                       </div>
                                   </li>
                               </ul>
                           </div>
                           <div class="text_area">
                               <input type="text" id="textInput">
                               <img src="${path}/resources/images/free-icon-send-12629514.png" alt="보내기" class="send" id="send">
                           </div>
                       </div>
                   </div>
               </li>
           </ul>
       </div>
    </div>

    <script src="${path}/resources/js/Main.js"></script>

        <form action="main" method="post" enctype="multipart/form-data">
           <div class="newBoard-Wrap" id="newBoard-Wrap">
               <div class="newBoard">
                   <h5>새 게시물 생성</h5>
                  
                       <input type="file" name="files" accept="image/*" id="fileInput"> <br>
                   
                   <img src="${path}/resources/images/free-icon-photo-3942077.png" alt="새 게시물 생성">
               </div>
           </div>
   
           <div class="imgBoard-Wrap" id="imgBoard-Wrap">
               <div class="imgBoard">
                   <div class="imgBoard-head">
                       <h5>새 게시물 생성</h5>
                       <img src="${path}/resources/images/free-icon-go-back-10824111.png" alt="back" class="backimg">
                       <input type="submit" class="share" alt="공유하기" value="공유하기">
                   </div>
                   <img src="" alt="" id="upload-img">
   
                   <input type="text" name="fileContent" id="addtext"><br>
   
               </div>
           </div>
        </form>
</body>
</html>