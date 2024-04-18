<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="PanelDeControl.css">
    <title>Panel de Control Medicos</title>
</head>
<body>
  <header>
    <div>
        <nav class="navbar navbar-expand-lg bg-body-tertiary p-0">
            <div class="container-fluid" style="background-color: lightgray;">
                <img src="LogoAitaMari-gris.png" alt="Logo" width="100px" height="80px" class="d-inline-block align-text-top" style="margin-right: 10px; margin-top: 5px; margin-bottom: 5px;">
                <ul class="navbar-nav">
                  <li class="nav-item">
                    <a class="nav-link" aria-current="page" style="margin-right: 20px;">Insertar datos - <img src="Insertar.png" alt="insertar" width="40px" height="30px"></a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="PanelDeControl.html" style="margin-right: 20px;"><img src="IconoInicio.png" alt="icono de inicio" width="30px" height="25px"></a>
                  </li>
                </ul>
            </div>
          </nav>
    </div>
</header>
    <div class="navbarLateral">
        <nav class="vertical-nav">
            <ul>
                <li><a href="IndexVoluntarios">Voluntario</a></li>
                <li><a href="IndexMedicos">Medico</a></li>
                <li><a href="PanelDeControl-Ruta.html">Ruta</a></li>
                <li><a href="PanelDeControl-Rescate.html">Rescate</a></li>
                <li><a href="PanelDeControl-Rescatado.html">Rescatado</a></li>
                <li><a href="PanelDeControl-FichaMedica.html">Ficha medica</a></li>
            </ul>
        </nav>
    </div>
    <div style="margin-left: 191px; margin-right: 80px; padding-top: 5px;">
        <table class="table table-striped">
            <thead>
              <tr>
                <th scope="col">Medico</th>
                <th scope="col">Nombre</th>
                <th scope="col">Apellido</th>
                <th scope="col">Especialidad</th>
                <th scope="col"></th>
              </tr>
            </thead>
            <tbody>
              <c:forEach items="${medicos}" var="medico">
			<tr>
				<td>${medico.id}</td>
				<td>${medico.nombre}</td>
				<td>${medico.apellido}</td>
				<td>${medico.especialidad}</td>
				<td>
					<a class="nav-link" aria-current="page" href="ModificarMedicos.jsp"><img src="modificar.png" alt="modificar" height="30px"width="30px"></a>
					<a class="nav-link" aria-current="page"><img src="eliminar.png" alt="eliminar" height="30px" width="30px"></a>
				</td>	
			</tr>
		</c:forEach>
            </tbody>
          </table>
    </div>
</body>
</html>