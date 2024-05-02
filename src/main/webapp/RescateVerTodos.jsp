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
<title>Panel de Control Rescates</title>
</head>
<body>
	<header>
		<div>
			<nav class="navbar navbar-expand-lg bg-body-tertiary p-0">
				<div class="container-fluid" style="background-color: lightgray;">
				<a class="nav-link" aria-current="page" href="PanelDeControl.jsp" style="margin-right: 2%;"> <img class="logoAitaMari" src="LogoAitaMari-gris.png" alt="Logo" class="d-inline-block align-text-top"></a>
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" aria-current="page" href="InsertarRescate">Insertar Rescates - <img
								src="Insertar.png" alt="insertar" class="fotoInsertar"></a>
						</li>
					</ul>
				</div>
			</nav> 
		</div>
	</header>
	<div class="navbarLateral">
		<nav class="vertical-nav">
			<ul> 
				<li><a href="IndexVoluntarios">Voluntario</a></li>
				<li><a href="IndexMedicos">Medico</a></li>
				<li><a href="PanelDeControl-Ruta.html">Ruta</a></li>
				<li><a href="IndexRescates">Rescate</a></li>
				<li><a href="PanelDeControl-Rescatado.html">Rescatado</a></li>
				<li><a href="PanelDeControl-FichaMedica.html">Ficha medica</a></li>
			</ul>
		</nav>
	</div>
	<div class="table-responsive">
		<table class="table-sm table-striped" style="width: -webkit-fill-available">
			<thead>
				<tr>
					<th scope="col">Rescate</th>
					<th scope="col">Fecha</th>
					<th scope="col">Posicion</th>
					<th scope="col">idRuta</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${rescates}" var="rescate">
			<tr>
				<td id="${rescate.id}">${rescate.id}</td>
				<td>${rescate.fecha}</td>
				<td>${rescate.posicion}</td>
				<td>${rescate.idRuta}</td>
				<td style="display: flex;">
					<a class="nav-link" aria-current="page" href="ModificarRescate?id=${rescate.id}"><img src="modificar.png" alt="modificar" height="30px"width="30px"></a>
					<a class="nav-link" aria-current="page" href="EliminarRescate?id=${rescate.id}"><img src="eliminar.png" alt="eliminar" height="30px" width="30px"></a>
				</td>	
			</tr>
		</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>