<%@page import="jsp_library.Library"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="book.css">
<title>Book</title>
</head>
<body>
<div class="mdiv">
		<div class="sdiv" align="center">
			<%
	String message = (String) request.getAttribute("message");
	if (message != null) {
		out.print(message);
	}
	%><br>
	<%
	List<Library> list = (List) request.getAttribute("list");
	%>
	<img class="img1" src="https://totalpng.com//public/uploads/preview/full-hd-shivaji-maharaj-png-hd-download-11707997641uhwmbgq1ah.png"><br>
	<span >Chhatrapati Shivaji Maharaj Library</span><br><br>
	<a href="addbook.jsp"><button id=b1>Add Book</button></a><br><br>
	<table border="2px solid" class="tab"  width="50%">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Author</th>
        <th>Genre</th>
        <th colspan="2">Operation</th>
    </tr>
    <% for (Library library : list) { %>
        <tr>
            <td align="center"><%= library.getId() %></td>
            <td><%= library.getName() %></td>
            <td><%= library.getAuthor() %></td>
            <td><%= library.getGenre()%></td>
            <td align="center"><a href="update?id=<%= library.getId()%>"><button id="b2">Update</button></a></td>
            <td align="center"><a href="delete?id=<%= library.getId()%>"><button id="b3">Delete</button></a></td>
        </tr>
    <% } %>
    </table>
		</div>
	</div>

</body>
</html>