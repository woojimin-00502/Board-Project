var code2 = ""; // code2 변수를 함수 외부에서 선언

function phoneClick() {

ph1 = $('input[name="ph1"]').val();
if($.trim(ph1).length == 0){
alert('전화번호를 입력해 주세요.');
$('input[name="ph1"]').focus();
return false;
}
else{
    alert('인증번호 발송이 완료되었습니다.\n휴대폰에서 인증번호 확인을 해주십시오.');
    var phone = $("#ph_1").val();
    $.ajax({
        type: "POST",
        url: "<%=request.getContextPath()%>/member/membersns.do",
        data: { phone: phone },
        cache: false,
        success: function (data) {
        if (data == "error") {
            alert("휴대폰 번호가 올바르지 않습니다.");
        }else {
            alert("휴대폰 전송이  됨.");
            code2 = data;
        }
    	}
    });
    }
    }


// 휴대폰 인증번호 대조
function phoneClick2() {
	security = $('input[name="ph2"]').val();
	if($.trim(security).length == 0){
		alert('인증번호를 입력해 주세요');
		$('input[name="security"]').focus();
		return false;
	}


else{
    if ($("#ph2").val() == code2) { // id를 "ph2"로 수정
    	alert('인증성공');}
    else {alert('인증실패');}
   	}
   	}