<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String msj = (String) request.getAttribute("msj");
		String msj2 = (String) request.getAttribute("msj2");
		String msj3 = (String) request.getAttribute("msj3");
	%>
	<h2 align="center">
		Mensaje : <%=msj%>
	</h2>
	<h3 align="center">
		Rol : <%=msj2 %>
	</h3>
	<h3 align="center">
		Rol : <%=msj3 %>
	</h3>
</body>
</html>