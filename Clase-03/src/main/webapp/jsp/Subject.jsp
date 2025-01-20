<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="entidades.Subject"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
										<img alt="info" src="img/info.svg" width="20" height="20"
										title="Editar"></a>
								<a href="SubjectServlet?type=delete&id=<%=item.getId()%>">
								 <img alt="delete" src="img/tacho.svg" width="20" height="20"
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
</html>
