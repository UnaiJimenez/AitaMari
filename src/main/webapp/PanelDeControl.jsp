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
<title>Panel de Control</title>
</head>
<body>
	<header>
		<div class="container-xlg barraHorizontal">
			<div class="row">
				<nav
					class="navbar navbar-expand-lg bg-body-tertiary col fixed-top contenidoBarraHorizontal">
					<div class="container-fluid" style="background-color: lightgray;">
						<a class="nav-link" aria-current="page" href="Index"><img
							src="LogoAitaMari-gris.png" alt="Logo"
							class="d-inline-block align-text-top logoAitaMari"></a>
						<ul class="navbar-nav contenidoBarraHorizontalDerecha">
							<li><a class="nav-link" aria-current="page"
								href="InsertarVoluntarioLandingPage" style="margin-right: 10px;">Landing
									Page</a></li>
						</ul>
					</div>
				</nav>
			</div>
		</div>
	</header>
	<div class="container-fluid">
		<div class="row">
			<div
				class="col-md-2 wrapper d-flex align-items-stretch d-none d-md-block sticky-left contenidoPrincipal">
				<nav id="sidebar" class="barraLateral">
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
			<div class="col-md-9 tabla">
				<h1>Bienvenido al panel de control de AitaMari</h1>
				<img src="LogoAitaMari-blanco.png" alt="logo aitamari"
					class="logoGrande">
			</div>
		</div>
	</div>
</body>
</html>