<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="PanelDeControl.css">
    <title>Panel de Control</title>
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
                <li><a href="PanelDeControl-Voluntario.html">Voluntario</a></li>
                <li><a href="PanelDeControl-Medico.html">Medico</a></li>
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
                <th scope="col">Voluntario</th>
                <th scope="col">Nombre</th>
                <th scope="col">Apellido</th>
                <th scope="col">Edad</th>
                <th scope="col">Email</th>
                <th scope="col">Telefono</th>
                <th scope="col"></th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row">1</th>
                <td>Iker</td>
                <td>Lourido</td>
                <td>18</td>
                <td>ikerlourido10@gmail.com</td>
                <td>612 345 567</td>
                <td>
                  <button type="button" class="btn"><img src="modificar.png" alt="modificar" height="30px" width="30px"></button>
                  <button type="button" class="btn"><img src="eliminar.png" alt="eliminar" height="30px" width="30px"></button>
                </td>
              </tr>
              <tr>
                <th scope="row">2</th>
                <td>Unai</td>
                <td>Jimenez</td>
                <td>18</td>
                <td>unaijimenez427@gmail.com</td>
                <td>689 012 345</td>
                <td>
                  <button type="button" class="btn"><img src="modificar.png" alt="modificar" height="30px" width="30px"></button>
                  <button type="button" class="btn"><img src="eliminar.png" alt="eliminar" height="30px" width="30px"></button>
                </td>
              </tr>
            </tbody>
          </table>
    </div>
</body>
</html>