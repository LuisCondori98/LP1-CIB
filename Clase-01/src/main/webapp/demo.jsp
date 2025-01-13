<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

</head>
<body>
	<form action="RegistrarCursoServlet" method="post">

        <label for="codigo">C�digo:</label>

        <input type="text" id="codigo" name="codigo" required>

        <br><br>



        <label for="nombre">Nombre:</label>

        <input type="text" id="nombre" name="nombre" required>

        <br><br>



        <label for="nivel">Nivel:</label>

        <input type="text" id="nivel" name="nivel" required>

        <br><br>



        <label for="profesor">Profesor:</label>

        <input type="text" id="profesor" name="profesor" required>

        <br><br>



        <input type="submit" value="Enviar Datos">

    </form>
    
<h1>Registrar Cursos</h1>

    <form action="RegistrarCursoServlet" method="post">

        <label for="codigo">C�digo</label>

        <input type="text" id="codigo" name="codigo" required>



        <label for="nombre">Nombre</label>

        <input type="text" id="nombre" name="nombre" required>



        <label for="nivel">Nivel</label>

        <input type="text" id="nivel" name="nivel" required>



        <label for="profesor">Profesor</label>

        <input type="text" id="profesor" name="profesor" required>



        <input type="submit" value="Enviar Datos">

    </form>
	<h1>Cursos Disponibles</h1>

    <table class="table table-success table-striped">

        <thead>

            <tr >

                <th>Id</th>

                <th>C�digo</th>

                <th>Nombre</th>

                <th>Nivel</th>

                <th>Profesor</th>

                <th>Acciones</th>

            </tr>
        </thead>

        <tbody>

            <tr>

                <td>1</td>

                <td>2414</td>

                <td>Seguridad de Aplicaciones</td>

                <td>Intermedio</td>

                <td>Jose Gomez</td>

                <td class="acciones">

                    <button class="btn btn-primary">Editar</button>

                    <button class="btn btn-danger">Eliminar</button>

                </td>

            </tr>

            <tr>

                <td>2</td>

                <td>1956</td>

                <td>Desarrollo de Aplicaciones M�viles I</td>

                <td>Avanzado</td>

                <td>Diana Vera</td>

                <td class="acciones">

                    <button class="btn btn-primary">Editar</button>

                    <button class="btn btn-danger">Eliminar</button>

                </td>

            </tr>

            <tr>

                <td>3</td>

                <td>7878</td>

                <td>Programaci�n Orientada a Objetos I</td>

                <td>Intermedio</td>

                <td>Julio Sanchez</td>

                <td class="acciones">

                    <button class="btn btn-primary">Editar</button>

                    <button class="btn btn-danger">Eliminar</button>

                </td>

            </tr>

        </tbody>

    </table>
</body>
</html>