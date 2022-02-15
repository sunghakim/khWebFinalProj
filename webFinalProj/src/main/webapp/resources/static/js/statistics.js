var ctx = document.getElementById('product-chart').getContext('2d');
var chart = new Chart(ctx, {
    //차트설정
    type: 'line',

    //차트데이터
    data: {
        labels: ['Outer', 'Shirts', 'Jeans', 'Accessary'],
        datasets: [{
            label: '상품 통계',
            backgroundColor: 'rgb(240, 97, 80)',
            borderColor: 'rgb(255, 255, 255)',
            data: [0, 10, 5, 2]
        }]
    },
    options: {}
})

var ctx = document.getElementById('income-chart').getContext('2d');
var chart = new Chart(ctx, {
    type: 'line',

    data: {
        labels: [100, 200, 300, 400, 500],
        datasets: [{
            label: '수입',
            backgroundColor: 'rgb(0, 136, 255)',
            borderColor: 'rgb(255, 255, 255)',
            data: [0, 10, 5, 2, 3]
        }]
    },
    options: {}
})

/*$('.list').click(() => {
    $(location).attr('href', 'purchase-list.html');
})
*/

$('.list').click(() => {
    $(location).attr('href', '/Manager_test/SoldHistory');
})


$(document).ready(function () {
    $('.admin-nav-sub').slideToggle();
    $('.admin-nav-sub').addClass('click-bg');
    $('#sub-3').addClass('click-font');

    $('#admin-nav-3 .fas').removeClass('fa-chevron-circle-right');
    $('#admin-nav-3 .fas').addClass('fa-chevron-circle-down');
})