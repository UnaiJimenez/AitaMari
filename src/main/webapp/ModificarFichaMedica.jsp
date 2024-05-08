<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <title>Modificar Ficha Medica</title>
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
        <form class="row g-3 col-6" action= "ModificarFichaMedica" method="post" style="background-color: #bebebe; border-radius: 2%;">
            <div class="col-12">
                <label for="Nombre" class="form-label"></label>
                <input type="hidden" name="id" value="${fichaMedica.id}"/>
                
				<label for="ConstantesVitales" class="form-label">Contantes Vitales</label>
                <input type="text" class="form-control" name="constantesVitales" placeholder="Constantes Vitales" value="${fichaMedica.constantesVitales}">
            </div>
            <div class="col-12">
                <label for="Alergias" class="form-label">Alergias</label>
                <input type="text" class="form-control" name="alergias" placeholder="Alergias" value="${fichaMedica.alergias}">
            </div>
            <div class="col-12">
                <label for="TipoDeSangre" class="form-label">Tipo de Sangre</label>
                <input type="text" class="form-control"  name="tipoSangre" placeholder="Tipo de Sangre" value="${fichaMedica.tipoSangre}">
            </div>
            <div class="col-12" style="margin-top: 5%">
				<select class="form-select" aria-label="idRescatado" name="idRescatado" value="${fichaMedica.rescatado.nombre}">
					<c:forEach items="${rescatados}" var="rescatado">
						<option value="${rescatado.id}">${rescatado.nombre}</option>
					</c:forEach>
				</select>
			</div>
            <div class="col-12">
					<input type="submit" value="Modificar" name="Modificar" class="btn" style="background-color: white; margin: 2%;">
            </div>
        </form>
    </div> 
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>