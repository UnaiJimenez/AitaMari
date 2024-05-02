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
<link rel="stylesheet" href="PanelDeControl.css">
<title>Detalles Ruta</title>
</head>
<body>
	<header>
		<div>
			<nav class="navbar navbar-expand-lg bg-body-tertiary p-0">
				<div class="container-fluid" style="background-color: lightgray;">
					<a class="nav-link" aria-current="page" href="Index"
						style="margin-right: 20px;"> <img src="LogoAitaMari-gris.png"
						alt="Logo" width="100px" height="80px"
						class="d-inline-block align-text-top"></a>
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="InsertarRuta" style="margin-right: 10px;">Insertar
								Rutas - <img src="Insertar.png" alt="insertar" width="30px"
								height="30px">
						</a></li>
					</ul>
				</div>
			</nav>
		</div>
	</header>
	<div style="margin-left: 191px; margin-right: 80px; padding-top: 5px;">
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Ruta</th>
					<th scope="col">fechaSalida</th>
					<th scope="col">fechaLlegada</th>
					<th scope="col">origen</th>
					<th scope="col">destino</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				
					<tr>
						<td id="${ruta.id}">${ruta.id}</td>
						<td>${ruta.fechaSalida}</td>
						<td>${ruta.fechaLlegada}</td>
						<td>${ruta.origen}</td>
						<td>${ruta.destino}</td>
					</tr>			
			</tbody>
		</table>
	</div>
	
	<!-- mostrar Voluntarios -->
	<div style="margin-left: 191px; margin-right: 80px; padding-top: 5px;">
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Voluntario</th>
					<th scope="col">Nombre</th>
					<th scope="col">Apellido</th>
					<th scope="col">Edad</th>
					<th scope="col">Email</th>
					<th scope="col">Telefono</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ruta.voluntarios}" var="voluntario">
					<tr>
						<td>${voluntario.id}</td>
						<td>${voluntario.nombre}</td>
						<td>${voluntario.apellido}</td>
						<td>${voluntario.edad}</td>
						<td>${voluntario.email}</td>
						<td>${voluntario.telefono}</td>
						<td style="display: flex;">
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
		<!-- mostrar Medicos -->
	<div style="margin-left: 191px; margin-right: 80px; padding-top: 5px;">
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Medico</th>
					<th scope="col">Nombre</th>
					<th scope="col">Apellido</th>
					<th scope="col">Especialidad</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ruta.medicos}" var="medico">
					<tr>
						<td>${medico.id}</td>
						<td>${medico.nombre}</td>
						<td>${medico.apellido}</td>
						<td>${medico.especialidad}</td>
						<td style="display: flex;"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>
