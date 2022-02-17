/**
 * 
 */$(document).ready(function(){
    $(".star").on("click", function() {
        let count = $(this).index() + 1;
        
       if($("#eval").val() == 1){
            $(this).html("<i class='fa-regular fa-star'></i>");
            count = 0;
        } else {
            $(this).prevAll().html("<i class='fa-solid fa-star'></i>");
            $(this).html("<i class='fa-solid fa-star'></i>");
            $(this).nextAll().html("<i class='fa-regular fa-star'></i>");
        }
        $("#eval").val(count);
    });

    $("#content").on("keyup", function () { 
        let content = $(this).val();
        // 글자수 세기
        if (content.length == 0 || content == '') {
            $("#count").css("color", "#f36f6f");
            $('#count').text('0'); 
        } else {
            $("#count").css("color", "#9ff36f");
            $('#count').text(content.length); 
        } 
        // 글자수 제한
        if (content.length > 150) {
            $(this).val($(this).val().substring(0, 150)); 
            $("#count").css("color", "red");
        }; 
    });
});