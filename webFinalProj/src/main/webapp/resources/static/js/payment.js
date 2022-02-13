$(document).ready(function(){
    $("#coupon-Btn").on("click", function() {
        $("#coupon-List").toggle();
    });

    $(".couponList-btn").on("click", function() {
        $("#delBtn").remove();
        $("#coupon-List").hide();
        $("#coupon-Name").text($(this).prev().text());
        $(".coupon-label").append("<button type=button id='delBtn'><i class='fa-solid fa-xmark'></i></button>");
        $("#coupon-id").val('클릭한 상품 id');

        let price = $("#before").text().replace(/,/g, "");
        let sale = "30%";
        sale = sale.replace(/[^\d]/, '');
        sale = sale / 100;
        sale = Math.round(price * sale);
        price = price - sale;

        sale = sale.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
        price = price.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");

        $("#sale").text(sale);
        $("#total").text(price);
    });
    
    $(".coupon-label").on('click', '#delBtn', function() {
        $("#coupon-Name").text("선택한 쿠폰이 없습니다");
        $("#sale").text(0);
        $("#delBtn").remove();
    });

});