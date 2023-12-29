function member(){

if($('input[name="id"]').val().length == 0){
alert('아이디를 입력해 주세요.');
$('input[name="id"]').focus();
return false;
}

ph1 = $('input[name="ph1"]').val();
if($.trim(ph1).length == 0){
alert('전화번호를 입력해 주세요.');
$('input[name="ph1"]').focus();
return false;
}

if($('input[name="pw"]').val().length == 0){
alert('비밀번호를 입력해 주세요.');
$('input[name="pw"]').focus();
return false;
}

if ($('input[name="repw"]').val() !== $('input[name="pw"]').val()) {
  alert('입력하신 비밀번호와 다릅니다.');
  $('input[name="repw"]').focus();
  return false;
}

if($('input[name="name"]').val().length == 0){
alert('이름을 입력해 주세요.')
$('input[name="name"]').focus();
return false;
}

if($('input[name="year"]').val().length == 0){
alert('년도를 입력해 주세요.');
$('input[name="year"]').focus();
return false;
}

if($('input[name="day"]').val().length == 0){
alert('일을 입력해 주세요.');
$('input[name="day"]').focus();
return false;
}

if($('input[type="radio"]').is(':checked') == false){
alert('성별을 선택해 주세요.');
return false;
}

ph1 = $('input[name="ph1"]').val();
if($.trim(ph1).length == 0){
alert('전화번호를 입력해 주세요.');
$('input[name="ph1"]').focus();
return false;
}
}