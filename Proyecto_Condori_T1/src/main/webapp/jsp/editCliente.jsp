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
</head>
<div class="container mt-4">
        <h2>Editar Cliente</h2>

        <%
            // Obtener el objeto "subject" de los atributos de la solicitud
            Cliente cliente = (Cliente) request.getAttribute("cliente");
            if (cliente == null) {
        %>
            <div class="alert alert-danger" role="alert">
                No se encontro al cliente para editar.
            </div>
        <%
            } else {
        %>
            <form action="<%= request.getContextPath() %>/ClienteServlet" method="post">
                <input type="hidden" name="type" value="Actualizar">
                <input type="hidden" name="id" value="<%= cliente.getIdCliente() %>">

                <div class="mb-3">
                    <label for="code" class="form-label">Nombres</label>
                    <input type="text" class="form-control" id="nombres" name="nombre" value="<%= cliente.getNombres() %>" required>
                </div>

                <div class="mb-3">
                    <label for="name" class="form-label">Apellidos</label>
                    <input type="text" class="form-control" id="apellidos" name="apellidos" value="<%= cliente.getApellidos() %>" required>
                </div>

                <div class="mb-3">
                    <label for="level" class="form-label">Correo</label>
                    <input type="text" class="form-control" id="correo" name="correo" value="<%= cliente.getCorreo() %>" required>
                </div>

                <div class="mb-3">
                    <label for="teacher" class="form-label">Edad</label>
                    <input type="text" class="form-control" id="edad" name="edad" value="<%= cliente.getEdad() %>" required>
                </div>
                
                <div class="mb-3">
                    <label for="teacher" class="form-label">Salario</label>
                    <input type="text" class="form-control" id="salario" name="salario" value="<%= cliente.getSalario() %>" required>
                </div>

                <button type="submit" class="btn btn-primary">Actualizar</button>
                <a href="<%= request.getContextPath() %>/ClienteServlet?type=Listar" class="btn btn-danger">Cancelar</a>
            </form>
        <%
            }
        %>
    </div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</html>