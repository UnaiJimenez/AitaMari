<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Insertar Rescatado</title>
<body style="margin-top: 10%; margin-left: 35%;">

    <div class="formulario">
        <form class="row g-3 col-6" action= "InsertarRescatado" method="post" style="background-color: #bebebe; border-radius: 2%;">
            <div class="col-12">
                <label for="Nacionalidad" class="form-label">Nacionalidad</label>
                <input type="text" class="form-control"  name="nacionalidad" placeholder="Nacionalidad">
            </div>
            <div class="col-12">               
				<label for="Nombre" class="form-label">Nombre</label>
                <input type="text" class="form-control" name="nombre" placeholder="Nombre">
            </div>
            <div class="col-12">
                <label for="Sexo" class="form-label">Sexo</label>
                <input type="text" class="form-control" name="sexo" placeholder="Sexo">
            </div>
            <div class="col-12">
                <label for="Edad" class="form-label">Edad</label>
                <input type="text" class="form-control"  name="edad" placeholder="Edad">
            </div>
            <div class="col-12">
                <label for="IdRescate" class="form-label">IdRescate</label>
                <input type="text" class="form-control"  name="idRescate" placeholder="idRescate">
          </div>
            <div class="col-12">
				<input type="submit" value="Insertar" name="Confirmacion" class="btn" style="background-color: white; margin: 2%;">
            </div>
             <div class="col-12">
				<input type="submit" value="AnadirFichaMedica" name="Confirmacion" class="btn" style="background-color: white; margin: 2%;">
            </div>
        </form>
    </div> 
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>