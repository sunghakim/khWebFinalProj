$(document).ready(function() {
    $('.admin-nav-sub').slideToggle();
    $('.admin-nav-sub').addClass('click-bg');
    $('#sub-1').addClass('click-font');

    $('#admin-nav-3 .fas').removeClass('fa-chevron-circle-right');
    $('#admin-nav-3 .fas').addClass('fa-chevron-circle-down');
})

/*$('#ok').click((e) => {
	let submit = $('#product');
	submit.attr('action', '/Manager/Item/Insert').attr('method', 'post').attr('enctype', 'multipart/form-data').attr('accept-charset', 'euc-kr').submit();
})*/

$('#inputShow').click((e) => {
	e.preventDefault();
	let fileInput = $('#file');
	
	fileInput.click();
})

$('#inputDelete').click(() => {
	let fileInput = $('#file');
	
	fileInput.val('');
	/*let read = new FileReader();
	read.onload = e => {
            let preview = document.getElementById("img")
            preview.src = '';
        }
        read.readAsDataURL('');*/
      $('#img').removeAttr('src');
})

function readImage(input) {
    // 인풋 태그에 파일이 있는 경우
    if(input.files && input.files[0]) {
        // 이미지 파일인지 검사 (생략)
        // FileReader 인스턴스 생성
        const reader = new FileReader()
        // 이미지가 로드가 된 경우
        reader.onload = e => {
            const previewImage = document.getElementById("img")
            previewImage.src = e.target.result
        }
        // reader가 이미지 읽도록 하기
        reader.readAsDataURL(input.files[0])
    }
}
// input file에 change 이벤트 부여
const inputImage = document.getElementById("file")
inputImage.addEventListener("change", e => {
    readImage(e.target)
})

$('#no').click((e) => {
	e.preventDefault();
	$(location).attr('href', '/Manager/Item');
})