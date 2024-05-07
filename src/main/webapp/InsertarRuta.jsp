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
<body style="background-color: #ececec;">
  <header>
        <div>
            <nav class="navbar navbar-expand-lg bg-body-tertiary p-0">
                <div class="container-fluid" style="background-color: lightgray;">
                    <img src="LogoAitaMari-gris.png" alt="Logo" width="100px" height="80px" class="d-inline-block align-text-top" style="margin-right: 10px; margin-top: 5px; margin-bottom: 5px;">
                    <ul class="navbar-nav">
                      <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="PanelDeControl.jsp" style="margin-right: 20px;"><img src="IconoInicio.png" alt="icono de inicio" width="30px" height="25px"></a>
                      </li>
                    </ul> 
                </div>
              </nav>
        </div>
    </header>
   <div class="formulario" style="margin-top: 5%; margin-left: 35%;">
		<form class="row g-3 col-6" action="InsertarRuta" method="post"
			style="background-color: #bebebe; border-radius: 2%;">
			<div class="col-12">

				<label for="fechaSalida" class="form-label">Fecha Salida</label> <input
					type="text" class="form-control" name="fechaSalida" placeholder="yyyy-MM-dd">
			</div>
			<div class="col-12">
				<label for="fechaLlegada" class="form-label">Fecha Llegada</label> <input
					type="text" class="form-control" name="fechaLlegada"
					placeholder="yyyy-MM-dd">
			</div>
			<div class="col-12">
				<label for="origen" class="form-label">Origen</label> <input
					type="text" class="form-control" name="origen"
					placeholder="Origen">
			</div>
			<div class="col-12">
				<label for="destino" class="form-label">Destino</label> <input
					type="text" class="form-control" name="destino"
					placeholder="Destino">
			</div>
			<div style="display: flex; justify-content: flex-end;">
				<div style="margin: 2%">
   					<form action="InsertarRuta" method="post" style="margin: 2%">
    					<input type="hidden" name="id" value="${ruta.id}"/>
    					<button type="submit" class="btn" style="background-color: blue; color: white; margin: 2%;">Confirmar</button>
    					<input type="hidden" name="Confirmacion" value="insertar">
					</form>
				</div>
				<div style="margin: 2%">
					<form action="InsertarRuta" method="post">
    					<input type="hidden" name="id" value="${ruta.id}"/>
    					<button type="submit" class="btn" style="background-color: grey; color: white; margin: 2%;">Cancelar </button>
   						<input type="hidden" name="Confirmacion" value="cancelar">
					</form>
				</div>
			</div>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>