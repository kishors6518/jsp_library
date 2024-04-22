<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="login.css">
<title>Signup</title>
</head>
<body>
<div class="mdiv">
		<div class="sdiv2" align="center">
			<%
			String msg2 = (String) request.getAttribute("message");
			if (msg2 != null) {
			%>
			<script type="text/javascript">
				alert(<%=msg2%>);
			</script>
			<%
			}
			%><br>
			<img class="img2"
				src="https://cdn-icons-png.freepik.com/512/700/700674.png">
			<h1 align="center">SignUp Form</h1>
			<form action="signup" method="post" class="frm">
				<label>ID</label><br> <input type="number" name="id"><br>
				<br> <label>Name</label><br> <input type="text"
					name="name"><br> <br> <label>Phone</label><br>
				<input type="tel" name="phone"><br> <br> <label>Email</label><br>
				<input type="text" name="email"><br> <br> <label>Password</label><br>
				<input type="text" name="pass"><br> <br>
				<button id=b1>Register</button>

			</form>
		</div>
	</div>

</body>
</html>