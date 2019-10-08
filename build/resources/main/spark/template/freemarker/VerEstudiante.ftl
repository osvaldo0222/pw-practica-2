<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="shortcut icon" type="image/x-icon" href="/imagenes/student.ico" />
        <title>Ver Estudiante</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="/">
                <img src="/imagenes/student.ico" alt="Logo" width="70" height="40">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="/">Listado <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/formEst">Agregar</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container" style="margin-top: 15px;">
            <div class="card">
                <div class="card-header">
                    <h3>Ver Estudiante</h3>
                </div>
                <div class="card-body">
                    <p class="card-text"><h4><strong>Matr&iacute;cula:</strong></h4>   ${estudiante.matricula?string["0"]}</p>
                    <p class="card-text"><h4><strong>Nombre:</strong></h4>   ${estudiante.nombre}</p>
                    <p class="card-text"><h4><strong>Apellido:</strong></h4>   ${estudiante.apellido}</p>
                    <p class="card-text"><h4><strong>Tel&eacute;fono:</strong></h4>   ${estudiante.telefono}</p>
                    <a href="/formEst/${estudiante.matricula?string["0"]}" class="btn btn-primary">Editar</a>
                    <a href="/eliminarEst/${estudiante.matricula?string["0"]}" class="btn btn-danger">Eliminar</a>
                </div>
            </div>
        </div>

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>