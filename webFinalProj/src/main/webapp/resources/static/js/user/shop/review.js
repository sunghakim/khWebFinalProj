$(document).ready(function(){
    let disable = false;
    let modContent;

    $(".review-img").on("click", function() {
        if(disable) { return; }

        let src = $(this).attr('src');
        let review = $(this).parent().siblings(".text-box").find(".review-content p").text();
        
        $("#modal-img").empty();
        $("#modal-content").empty();

        $("#modal-img").append(`
            <img src="` + src + `" alt="">
        `);
        $("#modal-content").append(review);
    });

    $("#modal-img").on("click", "#modal-img img", function() {
        $(".modal").toggle();
        $(".modal-backdrop").remove();
    });

    $("#modal-content").on("click", "#modal-content", function() {
        $(".modal").toggle();
        $(".modal-backdrop").remove();
    });

    $(".mod").on("click", function() {
        if(disable == true) { return; } 

        disable = true;
        $("img").removeAttr("data-bs-toggle");

        let content = $(this).parent().siblings(".review-area").find(".review-content p").text().replace(/\n +/g, '\n').trim();
        let reviewContent = $(this).parent().siblings(".review-area").find(".review-content");
        let reviewArea = $(this).parent().siblings(".review-area");
        let count = content.length;

        modContent = content;
        reviewContent.remove();
        reviewArea.append(`
            <div class="review-content">
                <textarea id="textarea">`+ content +`</textarea>
                <label><span id=count>` + count + `</span>/150</label>
            </div>
        `);

        let reviewButton = $(this).parent();
        reviewButton.next().show();
        reviewButton.hide();
    });

    $(".rtn").on("click", function() {
        if(disable != true) { return; } 

        disable = false;
        $("img").attr("data-bs-toggle", "modal");

        let content = $(this).parent().siblings(".review-area").find(".review-content p").text().replace(/\n +/g, '\n').trim();
        let reviewContent = $(this).parent().siblings(".review-area").find(".review-content");
        let reviewArea = $(this).parent().siblings(".review-area");
        let count = content.length;

        reviewContent.remove();
        reviewArea.append(`
            <div class="review-content">
                <p>`+ modContent +`</p>
            </div>
        `);

        let reviewButton = $(this).parent();
        reviewButton.prev().show();
        reviewButton.hide();
    });

    $(".review-content").on("keyup", "#textarea", function () { 
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