<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="entidades.Subject"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

	<div class="col-lg-4">
		<h3>Registrar Cursos</h3>
		<form action="<%=request.getContextPath()%>/SubjectServlet"
			method="post">
			<div class="form-group">
				<label>Codigo</label> <input class="form-control" type="text"
					name="txtCode">
			</div>
			<div class="form-group">
				<label>Nombre</label> <input class="form-control" type="text"
					name="txtName">
			</div>
			<div class="form-group">
				<label>Nivel</label> <input class="form-control" type="text"
					name="txtLevel">
			</div>
			<div class="form-group">
				<label>Profesor</label> <input class="form-control" type="text"
					name="txtTeacher">
			</div>
			<input type="submit" name="type" class="btn btn-primary"
				value="Grabar"> 
			<input
				type="submit" name="type" class="btn btn-primary" value="Listar">
		</form>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-6 col-sm-4">
				<div class="col-6 col-sm-7">
					<h3>Cursos Disponibles</h3>
					<table class="table">
						<thead>
							<tr>
								<th>Id</th>
								<th>Codigo</th>
								<th>Nombre</th>
								<th>Nivel</th>
								<th>Profesor</th>
								<th>Acciones</th>
							</tr>
						</thead>
						<tbody>
							<%
							List<Subject> listSubject = (List<Subject>) request.getAttribute("data");
							if (listSubject != null) {
								for (Subject item : listSubject) {
							%>
							<tr>
								<td><%=item.getId()%></td>
								<td><%=item.getCode()%></td>
								<td><%=item.getName()%></td>
								<td><%=item.getLevel()%></td>
								<td><%=item.getTeacher()%></td>
								<td>
								<a href="SubjectServlet?type=info&id=<%=item.getId()%>">
										<img alt="info" src="img/info.png" width="20" height="20"
										title="Editar" ></a>
								<a href="SubjectServlet?type=delete&id=<%=item.getId()%>">
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