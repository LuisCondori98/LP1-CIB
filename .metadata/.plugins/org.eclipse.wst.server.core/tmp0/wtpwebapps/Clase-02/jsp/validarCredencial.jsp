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
		String mensaje = "";
		String Rol = request.getParameter("cboRol");
		String credencial = request.getParameter("txtCredencial");
		mensaje = "Datos validados";
		request.setAttribute("msj", mensaje);
		request.setAttribute("msj2", Rol);
		request.setAttribute("msj3", credencial);
		pageContext.forward("respuestaCredencial.jsp");
	%>
</body>
</html>