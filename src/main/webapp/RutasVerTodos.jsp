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
<title>Panel de Control Rutas</title>
</head>
<body>
	<header>
		<div>
			<nav class="navbar navbar-expand-lg bg-body-tertiary p-0">
				<div class="container-fluid" style="background-color: lightgray;">
				<a class="nav-link" aria-current="page" href="Index" style="margin-right: 20px;"> <img src="LogoAitaMari-gris.png" alt="Logo" width="100px" height="80px" class="d-inline-block align-text-top"></a>
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" aria-current="page" href="InsertarRuta" 
							style="margin-right: 10px;">Insertar Rutas - <img
								src="Insertar.png" alt="insertar" width="30px" height="30px"></a>
						</li>
					</ul>
				</div>
			</nav> 
		</div>
	</header>
	<div class="navbarLateral">
		<nav class="vertical-nav">
			<ul> 
				<li><a href="IndexVoluntario">Voluntario</a></li>
				<li><a href="IndexMedico">Medico</a></li>
				<li><a href="IndexRuta">Ruta</a></li>
				<li><a href="IndexRescate">Rescate</a></li>
				<li><a href="IndexRescatado">Rescatado</a></li>
				<li><a href="IndexFichaMedica">Ficha medica</a></li>
			</ul>
		</nav>
	</div>
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
			<c:forEach items="${rutas}" var="ruta">
			<tr>
				<td id="${ruta.id}">${ruta.id}</td>
				<td>${ruta.fechaSalida}</td>
				<td>${ruta.fechaLlegada}</td>
				<td>${ruta.origen}</td>
				<td>${ruta.destino}</td>
				<td style="display: flex;">
					<a class="nav-link" aria-current="page" href="ModificarRuta?id=${ruta.id}"><img src="modificar.png" alt="modificar" height="30px"width="30px"></a>
					<a class="nav-link" aria-current="page" href="EliminarRuta?id=${ruta.id}"><img src="eliminar.png" alt="eliminar" height="30px" width="30px"></a>
					<a class="nav-link" aria-current="page" href="RutaVerDetalles?id=${ruta.id}"><img src="Ojo.png" alt="verDetalles" height="30px" width="40px"></a>
				</td>	
			</tr>
		</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>