<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script>
document.domain = "localhost";
	function goPopup(){
		window.name = "jusoPopup";
		// 호출된 페이지(jusoPopup.jsp)에서 실제 주소검색URL(https://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	    var pop = window.open("/jusoPopup","pop","width=570,height=420, scrollbars=yes, resizable=yes");   
	}
	/** API 서비스 제공항목 확대 (2017.02) **/
	function jusoCallBack(roadFullAddr,zipNo){
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
		document.form.roadFullAddr.value = roadFullAddr;
		document.form.zipNo.value = zipNo;
	}
</script>
<title>join</title>
</head>
<body>
	${error_msg}

	<form action="/join" name="form" id="form" method="post">
		<div>
			id : <input type="text" name="account_id" value="${accountVo.account_id}">
		</div>
		<div>
			password : <input type="password" id="PW" name="password" value="${accountVo.password}">
		</div>
		<div>
			user_type(0:관리자, 1:회원) : <input type="number" name="user_type" value="${accountVo.user_type}">
		</div>
		
		<div>
			name : <input type="text" name="name" value="${accountVo.name}">
		</div>
		<div>
			phone : <input type="text" name="phone" value="${accountVo.phone}">
		</div>
		<div>
			email : <input type="email" name="email" value="${accountVo.email}">
		</div>
		<div>
			<table>
			<colgroup>
				<col style="width:20%"><col>
			</colgroup>
			<tbody>
				<tr>
					<th>우편번호</th>
					<td>
						<input type="hidden" id="confmKey" name="confmKey" value=""  >
						<input type="text" id="zipNo" name="zipNo" readonly style="width:100px">
						<input type="button"  value="주소검색" onclick="goPopup();">
					</td>
				</tr>
				<tr>
					<th>도로명주소</th>
					<td><input type="text" id="roadFullAddr" name="address" style="width:85%" value="${accountVo.address}"></td>
				</tr>
			</tbody>
		</table>
		</div>
		<div>
			nickname : <input type="text" name="nickname" value="${accountVo.nickname}">
		</div>
		<div>
			<button type="submit">전송</button>
		</div>
	</form>
</body>
</html>