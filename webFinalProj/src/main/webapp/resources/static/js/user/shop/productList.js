$(document).ready(function(){
    if($(".here").text() == "BEST"){
        $("#best").show();
    } else {
        $("#best").hide();
    }

    $(".button").on("click", function() {
        if($(this).is(".here") === true) {
            $(".here").removeClass("here");
            $("#best").hide();
            $("#listContext").show();
        } else {
			$(this).addClass("here");
            $("#best").show();
            $("#listContext").hide();
		}        
    });

	$(".product-item").on("click", function() {
		let item_id = $(this).find("input").val();
		location.href = "/itemDetail/main?item_id=" + item_id;
	});
});