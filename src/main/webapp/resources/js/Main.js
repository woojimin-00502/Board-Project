$(document).ready(function() {
    let img;


    // 검색 아이콘 클릭 시 input 박스 생성 
    $('#search_icon').click(function() {
        var input = $('.searchinput');

        if (input.css('display') === 'none') {
            input.css('display', 'block');
        } else {
            input.css('display', 'none');
        }
    });
    
    // 댓글 영역 추가 
    function commentHandler() {
        var com_wrap = $(this).closest('.board').find('.wrap');
        var add_com = $(this).closest('.board').find('.add_comment');

        if(com_wrap.css('display') === 'none'){
           com_wrap.css('display', 'block');
           add_com.text('댓글접기..');
           console.log('클릭 11');
        } else {
           com_wrap.css('display', 'none');
           add_com.text('댓글달기..');
           console.log('클릭 22');
        }
    }
    $('.add_comment, .comment').click(function(){
        var com_wrap = $(this).closest('.board').find('.wrap');
        var add_com = $(this).closest('.board').find('.add_comment');

        if(com_wrap.css('display') === 'none'){
           com_wrap.css('display', 'block');
           add_com.text('댓글접기..');
           console.log('클릭 11');
        } else {
           com_wrap.css('display', 'none');
           add_com.text('댓글달기..');
           console.log('클릭 22');
        }
    });
    
    // 하트 클릭 시, 빨간색으로 변함
    function heartHandler(){
        if (!$(this).hasClass('liked')) {
            $(this).css('fill', 'red').addClass('liked');
            console.log("red");
        } else {
            $(this).css('fill', '#ddd').removeClass('liked');
            console.log("red2");
        }
    }
    $('.like_icon').click(heartHandler);
    

    // 댓글 달기
    function sendHandler(){
        var text = $('.textInput').val().trim();

        if (text !== '') {
            var listItem = $('<li></li>');
            var divWrapper = $('<div></div>').addClass('first_comment');
            var img = $('<img>').attr({
                src: '',
                alt: '프로필'
            });

            var commentWrap = $('<div></div>').addClass('com_wrap');
            var userId = $('<div></div>').addClass('userId').text('userId');
            var textComment = $('<div></div>').addClass('text_comment').text(text);
            var commentNav = $('<div></div>').addClass('comment_nav');
            var timeComment = $('<div></div>').addClass('time_comment').text('방금 전');
            var addComment = $('<div></div>').addClass('add_Comment').text('답글 달기');

            commentNav.append(timeComment);
            commentNav.append(addComment);

            commentWrap.append(userId);
            commentWrap.append(textComment);
            commentWrap.append(commentNav);

            divWrapper.append(img);
            divWrapper.append(commentWrap);

            listItem.append(divWrapper);
            $(this).closest('.comment_wrap').find('.list').append(listItem);
            $('.textInput').val('');
        }
    }
    $('.send').click(sendHandler);

    




    // 새 게시물 생성 창
    $('.board_icon').click(function(){
        $('#newBoard-Wrap').fadeIn(300);
        console.log('새 게시물 생성 창')
    });

    // 바탕화면 클릭시 메인으로 돌아감
    function backHandler(event){
        if ($(event.target).is('#newBoard-Wrap, #imgBoard-Wrap')) {
            $(this).fadeOut(300); 
            $('#fileInput').val('');
        }
    }
    $('#newBoard-Wrap, #imgBoard-Wrap').click(backHandler);


    // 이미지 업로드 시 다음 창으로 이동
    $('#newBoard-Wrap input[name="files"]').on('change', function(event) {
        var file = event.target.files[0];
        var reader = new FileReader();

        reader.onload = function(e) {
            img = e.target.result;
            $('#upload-img').attr('src', img);
            $('#newBoard-Wrap').hide();
            $('.imgBoard-Wrap').fadeIn(300);
        };

        reader.readAsDataURL(file);
    });


    // 돌아가기 창 클릭 시 이전 창으로 이동 
    $('.backimg').click(function(){
        $('.imgBoard-Wrap').hide();
        $('#fileInput').val('');
        $('#newBoard-Wrap').show();
    })


//========================================================================================


    // 유저 프로필, 아이디, 업로드 사진, 글
    // 공유하기 클릭 시 게시물 업로드 
    $('.share').click(function(){

        // 프로필 생성  - db에서 값 받아오기
        var profile = `
            <div class="profile">
                <img class="id_img" src="" alt="프로필">
                <div class="id_name">
                    ${/* userId 값 */'userid'}
                </div>
                <div class="time">
                    ${/* 몇 분 전 값 */'몇 분 전'}
                </div>
            </div>
        `   

        // 이미지 영역에 업로드한 이미지 표시
        var image = `
            <div class="image">
                <img class="uploaded-image" src="${img}" alt="게시 이미지">
            </div>
        `;

        // nav바 생성 
        var nav = `
            <div class="nav">
                <div class="heart">
                    <div class="like_icon" id="like_icon">
                        <svg xmlns="http://www.w3.org/2000/svg" height="16" width="16" viewBox="0 0 512 512"><path d="M47.6 300.4L228.3 469.1c7.5 7 17.4 10.9 27.7 10.9s20.2-3.9 27.7-10.9L464.4 300.4c30.4-28.3 47.6-68 47.6-109.5v-5.8c0-69.9-50.5-129.5-119.4-141C347 36.5 300.6 51.4 268 84L256 96 244 84c-32.6-32.6-79-47.5-124.6-39.9C50.5 55.6 0 115.2 0 185.1v5.8c0 41.5 17.2 81.2 47.6 109.5z"></path></svg>
                    </div>
                    <div class="heart_num">
                        <!-- 좋아요 갯수 -->
                        좋아요 2개
                    </div>
                </div>
                <div class="comment" id="comment_icon">
                    <img src="" alt="댓글">
                    <div class="comment_num">
                        <!--댓글 수-->
                        2개의 댓글
                    </div>
                </div>
                <div class="add_comment" id="comment">
                    <!--댓글 달기.. / 댓글 접기..-->
                    댓글달기..
                </div>
            </div>
        ` 

        // 댓글 형태 
        var comment_list = `
            <li>
                <div class="first_comment">
                    <img src="" alt="프로필">
                    <div class="com_wrap">
                        <div class="userId">userId</div>
                        <div class="text_comment">
                            <!--댓글 내용 (input에서 보낸 텍스트)-->
                            asdasd
                        </div>
                        <div class="comment_nav">
                            <div class="time_comment">
                                <!--몇 분 전 -->
                                2분 전 
                            </div>
                            <div class="add_Comment">
                                <!--댓글달기 / 댓글접기-->
                                댓글달기
                            </div>
                        </div>
                    </div>
                </div>
            </li>
        `

        
        // 댓글 영역 생성 
        var wrap = `
            <div class="wrap" id="wrap" style="display: none;">
                <div class="comment_wrap">
                    <ul class="list" id="list">
                        ${comment_list}
                    </ul>
                </div>
                <div class="text_area">
                    <input type="text" id="textInput">
                    <img src="" class="send" alt="보내기" >
                </div>
            </div>
        `
        
          // data-num (게시물 고유번호)
        var maxDataNum = 0;
        $('#body_list li').each(function() {
            var num = parseInt($(this).attr('data-num'));
            if (num > maxDataNum) {
                maxDataNum = num;
            }
        });
        let data_num = maxDataNum + 1;
        
        
        // 보드 리스트에 넣어주기
        var board_list = `
            <li data-num="${data_num}">
                <div class="board">
                    <!-- 추가할 li 내용 -->
                    ${profile}
                    ${image}
                    ${nav}
                    ${wrap}
                </div>
            </li>
        `;

        // 보드 리스트 출력 
        $('.imgBoard-Wrap').fadeOut(300);
        $('#body_list').append(board_list);
        $('#fileInput').val('');

        $('.add_comment, .comment').off();
        $('.add_comment, .comment').click(commentHandler);

        $('.send').off();
        $('.send').click(sendHandler);

        $('.like_icon').off();
        $('.like_icon').click(heartHandler);

        console.log('업로드');
    })
});