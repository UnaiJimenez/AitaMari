<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Eliminar Rescatado</title>
</head>
<body style="background-color: #ececec;">
    <header>
        <div>
            <nav class="navbar navbar-expand-lg bg-body-tertiary p-0">
                <div class="container-fluid" style="background-color: lightgray;">
                    <img src="LogoAitaMari-gris.png" alt="Logo" width="100px" height="80px" class="d-inline-block align-text-top" style="margin-right: 10px; margin-top: 5px; margin-bottom: 5px;">
                    <ul class="navbar-nav">
                      <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="Index" style="margin-right: 20px;"><img src="IconoInicio.png" alt="icono de inicio" width="30px" height="25px"></a>
                      </li>
                    </ul>
                </div>
            </nav>
        </div>
    </header>
    <div style="background-color: #cecece; height: 130px; width: 500px; margin-top: 15%; margin-left: 30%">
    	<p style="padding: 3%">Estas seguro de que quieres borrar este rescatado?</p>
    	<div style="display: flex; justify-content: flex-end;">
			<div style="margin: 2%">
   				<form action="EliminarRescatado" method="post" style="margin: 2%">
    				<input type="hidden" name="id" value="${rescatado.id}"/>
    				<button type="submit" class="btn" style="background-color: blue; color: white; margin: 2%;">Confirmar</button>
    				<input type="hidden" name="Confirmacion" value="eliminar">
				</form>
			</div>
			<div style="margin: 2%">
				<form action="EliminarRescatado" method="post">
    				<input type="hidden" name="id" value="${rescatado.id}"/>
    				<button type="submit" class="btn" style="background-color: grey; color: white; margin: 2%;">Cancelar </button>
   					<input type="hidden" name="Confirmacion" value="cancelar">
				</form>
			</div>
		</div>
	</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
