<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">

<title>Modificar Ruta</title>
<body style="background-color: #ececec;">
	<header>
		<div>
			<nav class="navbar navbar-expand-lg bg-body-tertiary p-0">
				<div class="container-fluid" style="background-color: lightgray;">
					<img src="Fotos/LogoAitaMari-gris.png" alt="Logo" width="100px"
						height="80px" class="d-inline-block align-text-top"
						style="margin-right: 10px; margin-top: 5px; margin-bottom: 5px;">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link" aria-current="page"
							href="IndexRuta" style="margin-right: 20px;"><img
								src="Fotos/IconoInicio.png" alt="icono de inicio" width="30px"
								height="25px"></a></li>
					</ul>
				</div>
			</nav>
		</div>
	</header>
	<div class="formulario" style="margin-top: 5%; margin-left: 35%;">
		<form class="row g-3 col-6" action="ModificarRuta" method="post"
			style="background-color: #bebebe; border-radius: 2%;">
			<div class="col-12">
				<label for="Nombre" class="form-label"></label> <input type="hidden"
					name="id" value="${ruta.id}" /> <label for="FechaSalida"
					class="form-label">Fecha de salida</label> <input type="text"
					class="form-control" name="fechaSalida" placeholder="yyyy-MM-dd"
					value="${ruta.fechaSalida}">
			</div>
			<div class="col-12">
				<label for="FechaLlegada" class="form-label">Fecha de
					llegada</label> <input type="text" class="form-control" name="fechaLlegada"
					placeholder="yyyy-MM-dd" value="${ruta.fechaLlegada}">
			</div>
			<div class="col-12">
				<label for="Origen" class="form-label">Origen</label> <input
					type="text" class="form-control" name="origen" placeholder="origen"
					value="${ruta.origen}">
			</div>
			<div class="col-12">
				<label for="Destino" class="form-label">Destino</label> <input
					type="text" class="form-control" name="destino"
					placeholder="destino" value="${ruta.destino}">
			</div>
			<div style="display: flex; justify-content: space-around;">
				<div>
					<p>
						<b>Voluntarios</b>
					</p>
					<c:forEach items="${voluntarios}" var="voluntario">
			 	${voluntario.nombre}
				<input type="checkbox" name="idVoluntarios[]"
							value="${voluntario.id}"
							<c:forEach items="${ruta.voluntarios}" var="voluntarioRuta">
                <c:if test="${voluntario.id == voluntarioRuta.id}">
                   checked
                </c:if>
           		</c:forEach>>
						<br>
					</c:forEach>
				</div>
				<div>
					<p>
						<b>Medicos</b>
					</p>
					<c:forEach items="${medicos}" var="medico">
			 ${medico.nombre}
				<input type="checkbox" name="idMedicos[]" value="${medico.id}"
							<c:forEach items="${ruta.medicos}" var="medicoRuta">
               <c:if test="${medico.id == medicoRuta.id}">
                   checked
               </c:if>
           </c:forEach>>
						<br>
					</c:forEach>
				</div>
			</div>
			<div style="display: flex; justify-content: flex-end;">
				<div style="margin: 2%">
					<form action="ModificarRuta" method="post" style="margin: 2%">
						<input type="hidden" name="id" value="${ruta.id}" />
						<button type="submit" class="btn"
							style="background-color: blue; color: white; margin: 2%;">Confirmar</button>
						<input type="hidden" name="Confirmacion" value="modificar">
					</form>
				</div>
				<div style="margin: 2%">
					<form action="ModificarRuta" method="post">
						<input type="hidden" name="id" value="${ruta.id}" />
						<button type="submit" class="btn"
							style="background-color: grey; color: white; margin: 2%;">Cancelar
						</button>
						<input type="hidden" name="Confirmacion" value="cancelar">
					</form>
				</div>
			</div>
			<script
				src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
				crossorigin="anonymous"></script>
</body>
</html>