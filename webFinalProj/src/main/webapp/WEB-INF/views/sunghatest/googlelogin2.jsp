<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://apis.google.com/js/platform.js?onload=init" async defer></script>
<meta name="google-signin-client_id" content="494231445138-2h489p3ollojmgeb6531mas1508c9eb0.apps.googleusercontent.com">
<script>
	function init() {
	  gapi.load('auth2', function() {
	    /* Ready. Make a call to gapi.auth2.init or some other API */
	  });
	}
	function onSignIn(googleUser) {
	  var profile = googleUser.getBasicProfile();
	  var id_token = googleUser.getAuthResponse().id_token;
	  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	  console.log('Name: ' + profile.getName());
	  console.log('Image URL: ' + profile.getImageUrl());
	  console.log('Email: ' + profile.getEmail()); // This is null if the 'email' scope is not present.
	  console.log('ID_token: ' + id_token);
	  
	  var xhr = new XMLHttpRequest();
	  xhr.open('POST', 'http://localhost/google/auth');
	  xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	  xhr.onload = function() {
	    console.log('Signed in as: ' + xhr.responseText);
	  };
	  xhr.send('idtoken=' + id_token);
	}
	function signOut() {
		var auth2 = gapi.auth2.getAuthInstance();
	    auth2.signOut().then(function () {
	      console.log('User signed out.');
	    });
	}
</script>
<title>googlelogin2</title>
</head>
<body>
	<div class="g-signin2" data-onsuccess="onSignIn"></div>
	<a href="#" onclick="signOut();">구글 로그아웃2</a>
	${GoogleAuth.isSignedIn.get()}
</body>
</html>