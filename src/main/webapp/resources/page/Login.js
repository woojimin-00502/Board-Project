function f_loginCheck() {
  $("#btnLogin").click(function() {
    var userid = $("#userid").val();
    var passwd = $("#passwd").val();
    if (userid == "") {
      alert("아이디를 입력하세요");
      $("#userid").focus(); // 입력포커스 이동
      return; // 함수 종료
    }
    if (passwd == "") {
      alert("비밀번호를 입력하세요");
      $("#passwd").focus();
      return;
    }
    // 폼 내부의 데이터를 전송할 주소
    document.forms["login-form"].action = "4.jsp";
    document.forms["login-form"].submit(); // 제출
  });
};
