<%-- 
    Document   : index
    Created on : Jun 28, 2021, 9:50:49 AM
    Author     : heaty566
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
	</head>
	<body>
		<form action="RegisterController" method="POST" id="form">
			<input type="text" />
			<div class="g-recaptcha" data-sitekey="your_key"></div>
			<div id="error"></div>
			<input type="submit" value="Submit" />
		</form>

		<script src="https://www.google.com/recaptcha/api.js" async defer></script>
		<script>
			window.onload = function (){
				let isValid = false;
				const form = document.getElementById("form");
				const error = document.getElementById("error");
				
				form.addEventListener("submit", function (event){
					event.preventDefault();
					const response = grecaptcha.getResponse();
					if (response){
						form.submit();
					} else {
						error.innerHTML = "Please check";
					}
				});
			}
		</script>
	</body>
</html>
