$(document).ready(function(){  

    $(".plus").on('click', function() {
		let price =  parseInt($(this).parent().prev().find(".item-price").val().replace(/,/g, ''));
        
        // 수량 1개 추가
        let amount = $(this).siblings("h4").text();
        amount++;
        $(this).siblings("h4").text(amount);

		// 같은 아이템 총금액 변경
		let itemPricePos = $(this).parent().prev().find(".price");
		let itemPrice = parseInt(itemPricePos.text().replace(/,/g, ''));
		itemPrice+= price;
		$(this).parent().prev().find(".price").text(itemPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));

		// 전체 값 변경
        let totalPrice = parseInt($("#total").text().replace(/,/g, ''));
        totalPrice += price;
        totalPrice = totalPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        $("#total").text(totalPrice);
    });

    $(".minus").on('click', function() {
		let price =  parseInt($(this).parent().prev().find(".item-price").val().replace(/,/g, ''));
        let amount = $(this).siblings("h4").text();
        if(amount <= 1) { return; }
        amount--;
        $(this).siblings("h4").text(amount);

		// 같은 아이템 총금액 변경
		let itemPricePos = $(this).parent().prev().find(".price");
		let itemPrice = parseInt(itemPricePos.text().replace(/,/g, ''));
		itemPrice-= price;
		$(this).parent().prev().find(".price").text(itemPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ","));

        let totalPrice = parseInt($("#total").text().replace(/,/g, ''));
        totalPrice -= price;
        totalPrice = totalPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        $("#total").text(totalPrice);
    });

    $(".delete").on('click', function() {
		let price =  parseInt($(this).siblings("h4").text().replace(/,/g, ''));
        let amount = $(this).siblings("h4").text();
        let totalPrice = parseInt($("#total").text().replace(/,/g, ''));
        totalPrice = totalPrice - (amount * price);
        totalPrice = totalPrice.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        $("#total").text(totalPrice);

		let itemId = $(this).parentsUntil(".product").find(".item").val();

        $(this).parents("form").remove();
        $("form").load("/mypage/deleteCartItem?item_id=" + itemId);
    });
    
    $("#submit").on("click", function() {
		let list = new Array();
		
		// id 리스트 만듬
		for(var i = 0; i < $("input:checkbox[name=item_id]:checked").length; i++) {
			alert($("input:checkbox[name=item_id]:checked:eq(" + i + ")").val());			
			list.push($("input:checkbox[name=item_id]:checked:eq(" + i + ")").val());
		}
		
		let shopItemsID = new Object();
		shopItemsID.name = list;
		
		let shop = JSON.stringify(list);
        console.log(shop);
        
        $.ajax({
			type: "get",
			async: false,
			url: "/mypage/BuyItem",
			contentType: 'application/json',
			jsonData : shop,
			success: function(date) {
				console.log("성공했다인마");
			}, error:function(data) {
				console.log("왜안돼?????????");
			}
		});
	});
});