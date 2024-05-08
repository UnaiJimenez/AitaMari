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
<title>Panel de Control Voluntarios</title>
</head>
<body>
	<header>
		<div class="container-xlg" style="width: -webkit-fill-available; position: fixed;">
			<div class="row">
				<nav class="navbar navbar-expand-lg bg-body-tertiary col fixed-top" style="padding: 0%; z-index: 1000;">
				<div class="container-fluid" style="background-color: lightgray;">
					<a class="nav-link" aria-current="page" href="Index" style="margin-left: 1%;"> <img class="logoAitaMari" src="LogoAitaMari-gris.png" alt="Logo" class="d-inline-block align-text-top"></a>
					<div>
						<ul class="navbar-nav" style="display: flex; flex-direction: row;">
							<li class="nav-item" style="padding-top: 5px;"><a class="nav-link" aria-current="page" href="InsertarVoluntario">Insertar Voluntarios - <img class="fotoInsertar" src="Insertar.png" alt="insertar"></a></li>
							<div class="collapse" id="navbarToggleExternalContent">
								<div class="bg p-4">
									<h5 class="text-body-emphasis h4">Collapsed content</h5>
									<span class="text-body-secondary">Toggleable via the navbar brand.</span>
								</div>
							</div>
								<nav class="navbar navbar bg">
									<div class="container-fluid">
										<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarToggleExternalContent aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
											<span class="navbar-toggler-icon"></span>
										</button>
									</div>
								</nav>
							</ul>
						</div>
					</div>
				</nav>
			</div>
		</div>
	</header>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2 wrapper d-flex align-items-stretch d-none d-md-block" style="padding-left: 0%; padding-right: 0%">
				<nav id="sidebar" style="-bs-navbar-padding-x: 0%; padding-left: 0%;">
					<ul class="list-unstyled components mb-3">
						<li><a href="IndexVoluntario">Voluntario</a></li>
						<li><a href="IndexMedico">Medico</a></li>
						<li><a href="IndexRuta">Ruta</a></li>
						<li><a href="IndexRescate">Rescate</a></li>
						<li><a href="IndexRescatado">Rescatado</a></li>
						<li><a href="IndexFichaMedica">Ficha medica</a></li>
					</ul>
				</nav>
			</div>
			<div class="col-md-9" style="margin-top: 100px; margin-left: 30px">
				<table class="table table-responsive">
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
						<c:forEach items="${voluntarios}" var="voluntario">
							<tr>
								<td id="${voluntario.id}">${voluntario.id}</td>
								<td>${voluntario.nombre}</td>
								<td>${voluntario.apellido}</td>
								<td>${voluntario.edad}</td>
								<td>${voluntario.email}</td>
								<td>${voluntario.telefono}</td>
								<td style="display: flex;"><a class="nav-link" aria-current="page" href="ModificarVoluntario?id=${voluntario.id}"><img src="modificar.png" alt="modificar" height="30px" width="30px"></a>
									<a class="nav-link" aria-current="page" href="EliminarVoluntario?id=${voluntario.id}"><img src="eliminar.png" alt="eliminar" height="30px" width="30px"></a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
