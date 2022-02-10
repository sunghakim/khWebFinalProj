<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://developers.kakao.com/sdk/js/kakao.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	Kakao.init('7d314791f1c38113b612f034c9d3f42f');
	console.log(Kakao.isInitialized());
</script>
<meta charset="UTF-8">
<title>카카오 로그인</title>
</head>
<body>
	<a id="custom-login-btn" href="javascript:loginWithKakao()">
  <img
    src="//k.kakaocdn.net/14/dn/btroDszwNrM/I6efHub1SN5KCJqLm1Ovx1/o.jpg"
    width="222"
    alt="카카오 로그인 버튼"
  />
</a>
<script type="text/javascript">
  function loginWithKakao() {
	  Kakao.Auth.login({
		  success: function(response) {
			  Kakao.API.request({
				    url: '/v2/user/me',
				    data: {
				    	property_keys: ["id", "kakao_account.email", "properties.nickname"]
				    },
				    success: function(response) {
				    	var data = {id: response.id, email: response.kakao_account.email, nickname: response.properties.nickname};
				  	  	$.ajax({
				  	  		type: "POST",
				  	  		url: "/kakaologin/doing",
				  	  		data: data,
				  	  		dataType: "json",
				  	  		success: function(result) {
				  	  			console.log(result);
				  	  			console.log("finish");
				  	  			console.log(location.hostname);
				  	  			const res = $.trim(result.res);
				  	  			if(res.includes("redirect:")) {
				  	  				const splits = res.substring(9);
				  	  				window.location.replace(splits);
				  	  			}
				  	  			else{
				  	  				const splits = res.substring(11);
					  	  			window.location.href="../" + splits;
				  	  			}
				  	  		},
				  	  		error: function(request, error) {
				  	  			console.log("에러");
				  	  			console.log("code: " + request.status + "\n message" + request.responseText + "\n error: " + error);
				  	  		},
				  	  	});
				    },
				    fail: function(error) {
				    	console.log(error);
				    	console.log("fail");
				    },
				});
		  },
		  fail: function(error) {
		    console.log(error);
		  },
		});
  }
</script>
<hr>
<button type="button" onclick="logout()">로그아웃</button>
<script>
	function logout() {
		if (!Kakao.Auth.getAccessToken()) {
			  console.log('Not logged in.');
			  return;
			}
			Kakao.Auth.logout(function() {
				location.href="http://localhost:8080/main";
			});
	}
</script>
<hr>
<button type="button" class="api-btn" onclick="unlinkApp()">앱 탈퇴하기</button>

<script type="text/javascript">
  function unlinkApp() {
    Kakao.API.request({
      url: '/v1/user/unlink',
      success: function(response) {
    	  console.log(response);
        alert('success: ' + JSON.stringify(response))
      },
      fail: function(error) {
    	  console.log(error);
        alert('fail: ' + JSON.stringify(error))
      },
    })
  }
</script>

</body>
</html>