$(document).ready(function(){
    $(".like-item").on("click", function() {
        $ajax({
            type: "post",
            async: false,
            url: "",
            dataType: "",
            success: function() {

            }
        });
    });

    $(".like-item").on("click", function() {
        // 해당 상세페이지 이동
    });
});