<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="login.css">
<title>addBook</title>
</head>
<body>
<div class="mdiv">
		<div class="sdiv2" align="center">
			<img class="img2" src="https://www.pngfind.com/pngs/m/102-1021249_open-book-png-open-book-in-png-transparent.png">
			<h1 align="center">Add Book</h1>
			<form action="addbook" method="post" class="frm">
				<label>Id</label><br> <input type="number" name="id"><br>
				<br> <label>BookName</label><br> <input type="text"
					name="name"><br>
				<br> <label>Author</label><br> <input type="text"
					name="author"><br>
				<br> <label>Genre</label><br> <input type="text"
					name="genre"><br>
				<br>
				<button id=b1>AddBook</button>
			</form>
		</div>
	</div>

</body>
</html>