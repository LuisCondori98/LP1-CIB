<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/ClienteServlet" class="d-flex flex-column w-100 gap-3 p-3 align-items-center">
		<h3>Formulario Clientes</h3>
		<input type="text" name="nombres" placeholder="Ingrese Nombres" />
		<input type="text" name="direccion" placeholder="Ingrese Direccion" />
		<input type="number" name="edad" placeholder="Ingrese Edad" />
		<input type="submit" value="Crear" class="btn btn-success" />
	</form>
	<div class="col-6 col-sm-4">
		<table>
			<tr>
				<th>Id</th>
				<th>Nombres</th>
				<th>Direccion</th>
				<th>Edad</th>
			</tr>
			<tr>
				<td><%=  %></td>
			</tr>
		</table>
	</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous">
</script>
</html>