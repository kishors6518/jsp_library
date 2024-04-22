<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="login.css">
<title>Login</title>
</head>
<body>
<div class="mdiv">
		<div class="sdiv1" align="center">
		<%
		String message = (String) request.getAttribute("message");
		if (message != null) {
		%>
		<script type="text/javascript">
			alert(<%= message%>);
		</script>
		<%
		}
		%><br>
			<img class="img1"
			src="https://cdn-icons-png.freepik.com/512/700/700674.png">
			<h1 align="center">WELCOME</h1>
			<form action="login" method="post" class="frm">
				<label>Email</label><br> <input type="text" name="email"><br>
				<br> <label>Password</label><br> <input type="Password"
					name="pass"><br>
				<button id=b1>Login</button>
				<br>
				<hr width="50px" align="center" style="margin-left: 8%">
				<span style="font-size: 22px;">Don't have
					account<br>
				<a href="signup.jsp" style="font-size: 18px; ">Create
						your account</a>
				</span>
			</form>

		</div>

	</div>

</body>
</html>