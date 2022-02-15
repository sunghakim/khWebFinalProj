$(document).ready(function(){
	let price =  parseInt($(".item-price").text().replace(/,/g, ''));
    if($(".here").text() == "구매하기"){
        $("#buy").show();
    } else {
        $("#buy").hide();
    }
    
    $(".detail-tab").on("click", function() {
		let itemID = $("#item_id").val();
        $(".here").removeAttr('disabled');
        $(".here").removeClass("here");
        $(this).addClass("here");
        $(this).attr('disabled', 'disabled');

        if($(".here").text() == "구매하기"){
            $("#buy").show();
            $("#container").empty();
        } else if($(".here").text() == "상세보기") {
            $("#buy").hide();
            $("#container").load("/itemDetail/content?item_id=" + itemID);
        } else if($(".here").text() == "후기") {
            $("#buy").hide();
            $("#container").load("/itemDetail/review?item_id=" + itemID);
        } else if($(".here").text() == "문의하기") {
            $("#buy").hide();
            $("#container").load("/itemDetail/checkQuestionList?item_id=" + itemID + "$page=1");
        }
    });

    // 옵션 사이즈 선택해야 색상 선택 가능
    $("#option-size").change(function() {
        let val = $("#option-size option:selected").val();
        let size = $("#option-size option:selected").text();
        
        if(val != ""){
			let items = $(".oc-" + size);
			$(".oc-" + size).removeAttr("hidden");
            $("#option-color").removeAttr("disabled");
        }
    });

    $("#option-color").change(function() {
        let val = $("#option-color option:selected").val();
        
        if(val != ""){
            let size = $("#option-size option:selected").text();
            let color = $("#option-color option:selected").text();
            let opt = size + ' / ' + color;

            let dupl = $(".item-option > label:contains('" + opt + "')");
            if(dupl.length != 0){
                let amount = dupl.parent().siblings(".count").find("h5").text();
                amount++;
                dupl.parent().siblings(".count").find("h5").text(amount);
            } else {
                let item = `
                    <form action="">
                                <div class="item">
                                    <div class="item-option"><label>` + opt + `</label></div>
                                    <div class="count">
                                        <button id="plus" type="button"><i class="fa-solid fa-plus"></i></button>
                                        <h5>1</h5>
                                        <button id="minus" type="button"><i class="fa-solid fa-minus"></i></button>
                                        <button id="delete" type="button"><i id="xmark" class="fa-solid fa-xmark"></i></button>
                                    </div>
                                    <input type="text" name="size" value="` + size + `" hidden/>
                                    <input type="text" name="color" value="` + color + `" hidden/>
                                    <input type="text" name="amount" value="1" hidden/>
                                </div>
                            </form>
                `
    
                $(".item-box").append(item);
            }

            let totalPrice = parseInt($("#total").text().replace(/,/g, ''));
            totalPrice += price;
            totalPrice = totalPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
            $("#total").text(totalPrice);

            $("#option-size option").removeAttr("selected");
            $("#option-size option:eq(0)").prop("selected", "true");
            $("#option-color option:eq(0)").prop("selected", "true");
    		$("#option-color option").attr("hidden", "true");
            $("#option-color").attr("disabled", "true");
        }
    });

    $(".item-box").on('click', '#plus', function() {
        let amount = $(this).siblings("h5").text();
        amount++;
        $(this).siblings("h5").text(amount);

        let totalPrice = parseInt($("#total").text().replace(/,/g, ''));
        totalPrice += price;
        totalPrice = totalPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        $("#total").text(totalPrice);
    });

    $(".item-box").on('click', '#minus', function() {
        let amount = $(this).siblings("h5").text();
        if(amount <= 1) { return; }
        amount--;
        $(this).siblings("h5").text(amount);

        let totalPrice = parseInt($("#total").text().replace(/,/g, ''));
        totalPrice -= price;
        totalPrice = totalPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        $("#total").text(totalPrice);
    });

    $(".item-box").on('click', '#delete', function() {
        let amount = $(this).siblings("h5").text();
        let totalPrice = parseInt($("#total").text().replace(/,/g, ''));
        totalPrice = totalPrice - (amount * price);
        totalPrice = totalPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        $("#total").text(totalPrice);

        $(this).parents("form").remove();
    });
});