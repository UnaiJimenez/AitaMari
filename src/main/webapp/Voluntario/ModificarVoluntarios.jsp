<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Modificar Voluntario</title>
<body style="background-color: #ececec;">
  <header>
        <div>
            <nav class="navbar navbar-expand-lg bg-body-tertiary p-0">
                <div class="container-fluid" style="background-color: lightgray;">
                    <img src="Fotos/LogoAitaMari-gris.png" alt="Logo" width="100px" height="80px" class="d-inline-block align-text-top" style="margin-right: 10px; margin-top: 5px; margin-bottom: 5px;">
                    <ul class="navbar-nav">
                      <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="IndexVoluntario" style="margin-right: 20px;"><img src="Fotos/IconoInicio.png" alt="icono de inicio" width="30px" height="25px"></a>
                      </li>
                    </ul> 
                </div>
              </nav>
        </div>
    </header>
   <div class="formulario" style="margin-top: 5%; margin-left: 35%;">
        <form class="row g-3 col-6" action= "ModificarVoluntario" method="post" style="background-color: #bebebe; border-radius: 2%;">
            <div class="col-12">
                <label for="Nombre" class="form-label"></label>
                <input type="hidden" name="id" value="${voluntario.id}"/>
                
						 <label for="Nombre" class="form-label">Nombre</label>
                <input type="text" class="form-control" name="nombre" placeholder="Nombre" value="${voluntario.nombre}">
            </div>
            <div class="col-12">
                <label for="Apellido" class="form-label">Apellido</label>
                <input type="text" class="form-control" name="apellido" placeholder="Apellido" value="${voluntario.apellido}">
            </div>
            <div class="col-12">
                <label for="Email" class="form-label">Email</label>
                <input type="text" class="form-control"  name="email" placeholder="Email" value="${voluntario.email}">
            </div>
            <div class="col-6">
                <label for="Edad" class="form-label">Edad</label>
                <input type="text" class="form-control" id="edad" name="edad" placeholder="Edad" value="${voluntario.edad}">
            </div>
            <div class="col-6">
                <label for="Telefono" class="form-label">Telefono</label>
                <input type="text" class="form-control" id="telefono" name="telefono" placeholder="Telefono" value="${voluntario.telefono}">
            </div>
			<div style="display: flex; justify-content: flex-end;">
			<div style="margin: 2%">
   				<form action="ModificarVoluntario" method="post" style="margin: 2%">
    				<input type="hidden" name="id" value="${voluntario.id}"/>
    				<button type="submit" class="btn" style="background-color: blue; color: white; margin: 2%;">Confirmar</button>
    				<input type="hidden" name="Confirmacion" value="modificar">
				</form>
			</div>
			<div style="margin: 2%">
				<form action="ModificarVoluntario" method="post">
    				<input type="hidden" name="id" value="${voluntario.id}"/>
    				<button type="submit" class="btn" style="background-color: grey; color: white; margin: 2%;">Cancelar </button>
   					<input type="hidden" name="Confirmacion" value="cancelar">
				</form>
			</div>
		</div>
        </form>
    </div> 
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>