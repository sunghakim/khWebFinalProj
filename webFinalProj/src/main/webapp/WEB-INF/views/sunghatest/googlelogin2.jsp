<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://accounts.google.com/gsi/client" async defer></script>
<title>googlelogin2</title>
</head>
<body>
	<div id="g_id_onload"
         data-client_id="494231445138-2h489p3ollojmgeb6531mas1508c9eb0.apps.googleusercontent.com"
         data-auto_prompt="false"
         data-auto_select="false"
         data-login_uri="http://localhost:8080/google/auth">
      </div>
      <div class="g_id_signin"
         data-type="standard"
         data-size="large"
         data-theme="outline"
         data-text="sign_in_with"
         data-shape="rectangular"
         data-logo_alignment="left">
      </div>
      ${login_result}
      id : ${id}
      <button type="button" class="g_id_signout" id="signout_button">google logout</button>
      <script>
      const button = document.getElementById("signout_button");
      button.onclick = () => {
        google.accounts.id.disableAutoSelect();
        console.log("logout success");
        
      }
      </script>
</body>
</html>