<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
   <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
   <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js"></script>
</head>
<body>
	<div class="container d-flex justify-content-center align-items-center vh-100">
       <div class="card shadow-sm p-4" style="width: 350px;">
           <h3 class="text-center mb-4">Iniciar Sesi�n</h3>
           <form action="<%= request.getContextPath() %>/LoginServelet" name="registration" id="loginForm" method="GET">
               <div class="mb-3">
                   <label for="email" class="form-label">Correo</label>
                   <input type="email" id="email" name="email" class="form-control" placeholder="Correo">
                   <div class="invalid-feedback">Ingrese su correo</div>
               </div>

               <div class="mb-3">
                   <label for="password" class="form-label">Clave</label>
                   <input type="password" id="password" name="password" class="form-control" placeholder="Contrase�a">
                   <div class="invalid-feedback">Ingrese su contrase�a</div>
               </div>
               <button type="submit" class="btn btn-primary w-100">Iniciar Sesi�n</button>
           </form>
       </div>
	</div>

	<script type="text/javascript">	
	$(function() {
	   // Configurar la validaci�n
	   $("form[name='registration']").validate({
	       rules: {
	           email: {
	               required: true,
	               email: true
	           },
	           password: {
	               required: true,
	               minlength: 8
	           }
	       },
	
	       messages: {
	           email: "Ingrese su correo",
	           password: {
	               required: "Ingrese su contrase�a",
	               minlength: "Tu contrase�a debe tener al menos 8 caracteres"
	           }
	       },
	
	       errorClass: "text-danger",
	       errorElement: "span",
	       
	       highlight: function(element) {
	    	   
	           $(element).addClass("is-invalid");
	       },
	
	       unhighlight: function(element) {
	
	           $(element).removeClass("is-invalid");
	       },
	
	       // Si el formulario pasa las validaciones
	       submitHandler: function(form) {
	
	           alert("Formulario v�lido, listo para enviar.");
	           form.submit();
	       }
	   });
	
	   // Validar din�micamente al borrar texto
	   $("#email, #password").on("keyup blur", function () {
		   
	       $(this).valid(); // Revalida el campo al escribir o salir del foco
	   });
	});
	</script>
</body>
</html>