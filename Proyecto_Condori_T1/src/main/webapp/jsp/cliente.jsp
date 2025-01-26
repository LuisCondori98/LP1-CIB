<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entidades.Cliente"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>Insert title here</title>
<style type="text/css">
.edad {
 width: 16%;
}
</style>
</head>
<body>
	<form action="<%=request.getContextPath()%>/ClienteServlet" method="POST" class="form-control form-control-lg d-flex flex-column gap-2 justify-content-center align-items-center width-75">
		<h2>Crear cliente</h2>
		<input type="text" name="nombres" placeholder="Ingrese Nombres" minlength="3" maxlength="40" required />
		<input type="text" name="apellidos" placeholder="Ingrese Apellidos" minlength="3" maxlength="40" required />
		<input type="email" name="correo" placeholder="Ingrese Correo" required />
		<input type="number" name="edad" class="edad" placeholder="Ingrese Edad" min="18" max="65" required />
		<input type="number" name="salario" placeholder="Ingrese Salario" required />
		<input type="submit" value="Crear" class="btn btn-primary" name="type" />
	</form>
	<form action="<%=request.getContextPath()%>/ClienteServlet" class="d-flex justify-content-center">
		<input type="submit" value="Listar" class="btn btn-success" name="type" />
	</form>
	<div class="container">
		<div class="row">
			<div class="col-6 col-sm-4">
				<div class="col-6 col-sm-7">
					<h3>Cursos Disponibles</h3>
					<table class="table">
						<thead>
							<tr>
								<th>Id</th>
								<th>Nombres</th>
								<th>Apellidos</th>
								<th>Correo</th>
								<th>Edad</th>
								<th>Salario</th>
							</tr>
						</thead>
						<tbody>
							<%
							List<Cliente> listaCliente = (List<Cliente>) request.getAttribute("data");
							if (listaCliente != null) {
								for (Cliente cli : listaCliente) {
							%>
							<tr>
								<td><%=cli.getIdCliente()%></td>
								<td><%=cli.getNombres()%></td>
								<td><%=cli.getApellidos()%></td>
								<td><%=cli.getCorreo()%></td>
								<td><%=cli.getEdad()%></td>
								<td><%=cli.getSalario()%></td>
								<td class="d-flex m-3">
									<a href="ClienteServlet?type=Info&id=<%=cli.getIdCliente()%>">
											<img alt="info" src="img/info.png" width="20" height="20"
											title="Editar"></a>
									<a href="ClienteServlet?type=Borrar&id=<%=cli.getIdCliente()%>">
									 <img alt="delete" src="img/tacho.png" width="20" height="20"
										title="Eliminar"></a>
								</td>
							</tr>
							<%
							}
							}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>