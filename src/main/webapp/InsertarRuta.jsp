<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>Insertar Ruta</title>
<body style="margin-top: 10%; margin-left: 35%;">

	<div class="formulario">
		<form class="row g-3 col-6" action="InsertarRuta" method="post"
			style="background-color: #bebebe; border-radius: 2%;">
			<div class="col-12">

				<label for="fechaSalida" class="form-label">fechaSalida</label> <input
					type="text" class="form-control" name="fechaSalida" placeholder="yyyy-MM-dd">
			</div>
			<div class="col-12">
				<label for="fechaLlegada" class="form-label">fechaLlegada</label> <input
					type="text" class="form-control" name="fechaLlegada"
					placeholder="yyyy-MM-dd">
			</div>
			<div class="col-12">
				<label for="origen" class="form-label">origen</label> <input
					type="text" class="form-control" name="origen"
					placeholder="Origen">
			</div>
			<div class="col-12">
				<label for="destino" class="form-label">destino</label> <input
					type="text" class="form-control" name="destino"
					placeholder="Destino">
			</div>
			<div class="col-12">
				<input type="submit" value="Insertar" name="Insertar" class="btn"
					style="background-color: white; margin: 2%;">
			</div>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>