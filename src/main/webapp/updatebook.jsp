<%@page import="jsp_library.Library"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="login.css">
<title>Update Book</title>
</head>
<body>
<div class="mdiv">
		<div class="sdiv2" align="center">
			<%
			Library library = (Library) request.getAttribute("emp");
			%>
			<img class="img2"
				src="https://www.pngfind.com/pngs/m/102-1021249_open-book-png-open-book-in-png-transparent.png">
			<h1 align="center">Book Information</h1>
			<form action="update" method="post" class="frm">
				<label>Id</label><br> <input type="hidden" name="id"
					value=<%=library.getId()%>><br>
				<br> <label>Book Name</label><br> <input type="text"
					name="name" value=<%=library.getName()%>><br>
				<br> <label>Author</label><br> <input type="text"
					name="author" value=<%=library.getAuthor()%>><br>
				<br> <label>Genre</label><br> <input type="text"
					name="genre" value=<%=library.getGenre()%>><br>
				<br>
				<button id=b1>Update</button>
			</form>
		</div>
	</div>

</body>
</html>