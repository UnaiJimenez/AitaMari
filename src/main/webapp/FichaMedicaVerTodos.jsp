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
<title>Panel de Control Ficha Medica</title>
</head>
<body>
	<header>
		<div>
			<nav class="navbar navbar-expand-lg bg-body-tertiary p-0">
				<div class="container-fluid" style="background-color: lightgray;">
				<a class="nav-link" aria-current="page" href="Index" style="margin-right: 2%;"> <img class="logoAitaMari" src="LogoAitaMari-gris.png" alt="Logo" class="d-inline-block align-text-top"></a>
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" aria-current="page" href="InsertarFichaMedica">Insertar Fichas Medicas - <img
								class="fotoInsertar" src="Insertar.png" alt="insertar"></a>
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
		<div class="table-responsive">
			<table class="table-sm table-striped" style="width: -webkit-fill-available">
			<thead>
				<tr>
					<th scope="col">Ficha Medica</th>
					<th scope="col">Constantes Vitales</th>
					<th scope="col">Alergias</th>
					<th scope="col">Tipo de Sangre</th>
					<th scope="col">Id Rescatado</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${fichasmedicas}" var="fichaMedica">
			<tr>
				<td id="${fichaMedica.id}">${fichaMedica.id}</td>
				<td>${fichaMedica.constantesVitales}</td>
				<td>${fichaMedica.alergias}</td>
				<td>${fichaMedica.tipoSangre}</td>
				<td>${fichaMedica.idRescatado}</td>
				<td style="display: flex;">
					<a class="nav-link" aria-current="page" href="ModificarFichaMedica?id=${fichaMedica.id}"><img src="modificar.png" alt="modificar" height="30px"width="30px"></a>
					<a class="nav-link" aria-current="page" href="EliminarFichaMedica?id=${fichaMedica.id}"><img src="eliminar.png" alt="eliminar" height="30px" width="30px"></a>
				</td>	
			</tr>
		</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>