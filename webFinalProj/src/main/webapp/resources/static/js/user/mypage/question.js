$(document).ready(function(){
    $(".here").attr('disabled', false);
    $(".here").css('color', 'white');
    $(".here").css('background-color', 'rgb(231, 76, 60)');
    
    $("#question").on("click", function() {
		location.href = '/mypage/checkQuestionList';	
	});
	
	$("#report").on("click", function() {
		location.href = '/mypage/checkReport';	
	});
	
	$("#addQuestion").on("click", function() {
		location.href = '/mypage/addQuestion';
	});
	
    $("a[href='#']:eq(0)").on("click", function() {
		history.back();
	});
});