<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Modificar</title>
<body style="margin-top: 10%; margin-left: 35%;">
    <div class="formulario">
        <form class="row g-3 col-6" action= "ModificarVoluntario" style="background-color: #bebebe; border-radius: 2%;">
            <div class="col-12">
                <label for="Nombre" class="form-label">Nombre</label>
                <input type="Nombre" class="form-control" id="Nombre" name="Nombre" placeholder="Nombre" value="${voluntario.nombre} }">
            </div>
            <div class="col-12">
                <label for="Apellido" class="form-label">Apellido</label>
                <input type="Apellido" class="form-control" id="Apellido" name="Apellido" placeholder="Apellido" value="${voluntario.apellido} }">
            </div>
            <div class="col-12">
                <label for="Email" class="form-label">Email</label>
                <input type="Email" class="form-control" id="Email" name="Email" placeholder="Email" value="${voluntario.email} }">
            </div>
            <div class="col-6">
                <label for="Edad" class="form-label">Edad</label>
                <input type="Edad" class="form-control" id="Edad" name="Edad" placeholder="Edad" value="${voluntario.edad} }">
            </div>
            <div class="col-6">
                <label for="Telefono" class="form-label">Telefono</label>
                <input type="Telefono" class="form-control" id="Telefono" name="Telefono" placeholder="Telefono" value="${voluntario.telefono} }">
            </div>
            <div class="col-12">
                <a href="PanelDeControl-Voluntario.html"><button type="button" class="btn" style="background-color: white; margin: 2%;"><b>Modificar</b></button></a>
            </div>
        </form>
    </div> 
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>