<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<title>Detalles Rescate</title>
</head>
<body style="background-color: #ececec;">
  <header>
        <div>
            <nav class="navbar navbar-expand-lg bg-body-tertiary p-0">
                <div class="container-fluid" style="background-color: lightgray;">
                    <img src="LogoAitaMari-gris.png" alt="Logo" width="100px" height="80px" class="d-inline-block align-text-top" style="margin-right: 10px; margin-top: 5px; margin-bottom: 5px;">
                    <ul class="navbar-nav">
                      <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="IndexRescate" style="margin-right: 20px;"><img src="IconoInicio.png" alt="icono de inicio" width="30px" height="25px"></a>
                      </li>
                    </ul>
                </div> 
              </nav>
        </div>
    </header>
	<div style="margin-left: 130px; margin-right: 130px; padding-top: 20px;">
		<h1>Rescate</h1>
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Rescate</th>
					<th scope="col">fechaHora</th>
					<th scope="col">posicion</th>
					<th scope="col">ruta</th>
				</tr>
			</thead>
			<tbody>
				
					<tr>
						<td id="${rescate.id}">${rescate.id}</td>
						<td>${rescate.fechaHora}</td>
						<td>${rescate.posicion}</td>
						<td>${rescate.ruta}</td>
					</tr>			
			</tbody>
		</table>
	</div>
	
	<!-- mostrar rescatados -->
	<div style="margin-left: 130px; margin-right: 130px; padding-top: 20px;">
		<h1>Informacion de los Rescatados</h1>
		<table class="table table-striped" style="width: ">
			<thead>
				<tr>
					<th scope="col">Rescatado</th>
					<th scope="col">Nacionalidad</th>
					<th scope="col">Sexo</th>
					<th scope="col">Edad</th>
					<th scope="col">Id Rescate</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ruta.voluntarios}" var="voluntario">
					<tr>
						<td>${rescatado.id}</td>
						<td>${rescatado.nacionalidad}</td>
						<td>${rescatado.sexo}</td>
						<td>${rescatado.edad}</td>
						<td>${rescatado.idRescate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>