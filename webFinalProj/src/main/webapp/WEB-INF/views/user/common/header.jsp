<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<link rel="stylesheet" href="/resources/static/css/common.css">
<link rel="stylesheet" href="/resources/static/css/index.css">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<script src="https://use.fontawesome.com/releases/v6.0.0/js/all.js"></script>
<script type="text/javascript" src="/resources/static/js/jquery-3.6.0.min.js"></script>

<script src="https://accounts.google.com/gsi/client" async defer></script>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script>
    Kakao.init('7d314791f1c38113b612f034c9d3f42f');
    console.log(Kakao.isInitialized());
    
    document.domain = "localhost";
 
    /** API 서비스 제공항목 확대 (2017.02) **/
	function jusoCallBack(roadFullAddr,zipNo){
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
		console.log(roadFullAddr);
		document.form.roadFullAddr.value = roadFullAddr;
		document.form.zipNo.value = zipNo;
	}
</script>