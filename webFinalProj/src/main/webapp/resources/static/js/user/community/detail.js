$(document).ready(function(){
    let disable = false;
    let modContent;

    $("#cmt-unfold").on("click", function() {
        if($("#cmt-unfold").text() == "댓글 펼치기"){
            $("#detail").hide();
            $("#comments").show();
            $(this).text("댓글 접기");
        } else {
            $("#detail").show();
            $("#comments").hide();
            $(this).text("댓글 펼치기");
        }
    });

    $("#mod").on("click", function() {

    });

    $("list").on("click", function() {

    });

    $(".cmt-mod").on("click", function() {
        if(disable == true) { return; } 

        disable = true;

        let content = $(this).parent().siblings("#cmt").text().replace(/\n +/g, '\n').trim();
        let cmt = $(this).parent().siblings("#cmt");
        let cmtParent = cmt.parent();
        // let count = content.length;

        modContent = content;
        cmt.remove();
        cmtParent.prepend(`
            <div id="cmt">
              <textarea placeholder="내용을 입력해주세요" required>`+ content +`</textarea>
            </div>
        `);

        let Button = $(this).parent();
        Button.next().show();
        Button.hide();
    });

    $(".rtn").on("click", function() {
        if(disable != true) { return; } 

        disable = false;

        let cmt = $(this).parent().siblings("#cmt");
        let cmtParent = cmt.parent();

        cmt.remove();
        cmtParent.prepend(`
            <div id="cmt">`+ modContent +`</div>
        `);

        let Button = $(this).parent();
        Button.prev().show();
        Button.hide();
    });

    $(".cmt-box").on("keyup", "#cmt", function () { 
        let content = $(this).val();
        // 글자수 세기
        if (content.length == 0 || content == '') {
            $("#count").css("color", "red");
            $('#count').text('0'); 
        } else {
            $("#count").css("color", "rgb(113, 192, 113)");
            $('#count').text(content.length); 
        } 
        // 글자수 제한
        if (content.length > 150) {
            $(this).val($(this).val().substring(0, 150)); 
            $("#count").css("color", "red");
        }; 
    });

});