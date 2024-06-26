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
		<div class="container-xlg" style="width: -webkit-fill-available; position: fixed;">
			<div class="row">
				<nav class="navbar navbar-expand-lg bg-body-tertiary col fixed-top" style="padding: 0%; z-index: 1000;">
				<div class="container-fluid" style="background-color: lightgray;">
					<a class="nav-link" aria-current="page" href="Index" style="margin-left: 1%;"> <img class="logoAitaMari" src="Fotos/LogoAitaMari-gris.png" alt="Logo" class="d-inline-block align-text-top"></a>
					<div>
						<ul class="navbar-nav" style="display: flex; flex-direction: row;">
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
            			<li><a href="IndexHistorico">Historico</a></li>
					</ul>
				</nav>
			</div>
			<div class="col-md-9" style="margin-top: 100px; margin-left: 30px">
				<table class="table table-responsive">
					<thead>		
						<tr>
							<th scope="col">Historico</th>
							<th scope="col">A�o</th>
							<th scope="col">Mes</th>
							<th scope="col">Rescatados</th>
							<th scope="col">Ruta</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${historicos}" var="historico">
							<tr>
								<td></td>
								<td>${historico.ano}</td>
								<td>${historico.mes}</td>
								<td>${historico.totalRescatados}</td>
								<td>${historico.ruta.id} - ${historico.ruta.origen} - ${historico.ruta.destino}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>