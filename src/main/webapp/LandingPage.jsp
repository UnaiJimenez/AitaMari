<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AitaMari</title>
    <link rel="stylesheet" href="LandingPage.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
    <header>
        <nav class="navbar bg-body-tertiary p-0">
            <div class="container-fluid" style="background-color: #d5e1ff;">
              <a class="navbar-brand" href="#">
                <img src="LogoAitaMari-azul.png" alt="logo aitamari" height="100px" width="80px" class="logo">
              </a>
            </div>
          </nav>
    </header>
    <div class="cuerpo">
        <div class="informacion">
            <div class="slogan">
                <p>Tu voluntad 
                    fabrica sonrisas</p>
            </div>
        </div>
        <div class="formulario">
            <form class="row g-3 col-6" action= "InsertarVoluntarioLandingPage" method="post" style="background-color: #d5e1ff; border-radius: 2%; margin-bottom: 10%;">
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
    <footer>
        <h2>Contáctanos</h2>
        <div class="imgContactos1">
            <img src="telefono.png" alt="telefono" class="telefono">
            <img src="direccion.png" alt="direccion" class="direccion">
            <img src="correo.png" alt="correo electronico" class="correo">
        </div>
        <div class="contactos1">
            <p>Teléfono: +34 678 628 921</p>
            <p>Dirección: Calle Jose Antonio, Hondarribia, España</p>
            <p>Correo electrónico: AitaMari@gmail.com</p>
        </div>
        <div class="imgContactos2">
            <img src="instagram.jpg" alt="instagram" class="instagram">
            <img src="twitter.png" alt="twitter" class="twitter">
            <img src="facebook.png" alt="facebook" class="facebook">
        </div>
        <div class="contactos2">
            <p>Instagram: AitaMari.oficial</p>
            <p>Twitter: AitaMarii</p>
            <p>Facebook: Aita_Mari</p>
        </div>
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>