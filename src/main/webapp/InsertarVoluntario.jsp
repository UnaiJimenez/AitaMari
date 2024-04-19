<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Insertar Voluntario</title>
</head>
<body style="margin-top: 10%; margin-left: 35%;">
    <div class="formulario">
        <form class="row g-3 col-6" action= "InsertarVoluntario" method="post" style="background-color: #bebebe; border-radius: 2%;">
            <div class="col-12">
				<label for="Nombre" class="form-label">Nombre</label>
                <input type="text" class="form-control" name="nombre" placeholder="Nombre">
            </div>
            <div class="col-12">
                <label for="Apellido" class="form-label">Apellido</label>
                <input type="text" class="form-control" name="apellido" placeholder="Apellido">
            </div>
            <div class="col-12">
                <label for="Email" class="form-label">Email</label>
                <input type="text" class="form-control"  name="email" placeholder="Email">
            </div>
            <div class="col-6">
                <label for="Edad" class="form-label">Edad</label>
                <input type="text" class="form-control" id="edad" name="edad" placeholder="Edad">
            </div>
            <div class="col-6">
                <label for="Telefono" class="form-label">Telefono</label>
                <input type="text" class="form-control" id="telefono" name="telefono" placeholder="Telefono">
            </div>
            <div class="col-12"> 
				<input type="submit" value="Insertar" name="Insertar" class="btn" style="background-color: white; margin: 2%;">
            </div>
        </form>
    </div> 
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>