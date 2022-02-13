$(document).ready(function(){
    if($(".here").text() == "BEST"){
        $("#best").show();
    } else {
        $("#best").hide();
    }
    
    $(".button").on("click", function() {
        if($(this).is(".here") === true) {
            alert("여기임");
        } else {
            $(".here").removeClass("here");
            $(this).addClass("here");

            if($(".here").text() == "BEST"){
                $("#best").show();
                $("#listContext").hide();
            } else {
                $("#best").hide();
                $("#listContext").show();
            }
        }
    });

    $(".best-btn").on("click", function() {
        
    });


});