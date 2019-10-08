<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="shortcut icon" type="image/x-icon" href="/imagenes/student.ico" />
        <title><#if (estudiante.matricula)??>Editar<#else>Registrar</#if> Estudiante</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <a class="navbar-brand" href="/">
                <img src="/imagenes/student.ico" alt="Logo" width="60" height="40">
            </a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="/">Listado <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item active">
                        <a class="nav-link" href="/formEst">Agregar</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container" style="margin-top: 15px;">
            <div class="card">
                <div class="card-header">
                    <h3><#if (estudiante.matricula)??>Editar<#else>Registrar</#if> Estudiante</h3>
                </div>
                <div class="card-body">

                    <#if (exito)??>
                        <div class="alert alert-success" role="alert">
                            ${exito}
                        </div>
                    <#elseif (existe)??>
                        <div class="alert alert-warning" role="alert">
                            ${existe}
                        </div>
                    <#elseif (error)??>
                        <div class="alert alert-danger" role="alert">
                            ${error}
                        </div>
                    <#elseif (errorEdit)??>
                        <div class="alert alert-danger" role="alert">
                            ${errorEdit}
                        </div>
                    </#if>

                    <form action="/<#if (estudiante.matricula)??>editarEst/${estudiante.matricula?string["0"]}<#else>agregarEst</#if>" method="post">
                        <div class="form-group">
                            <label for="matricula">Matr&iacute;cula:</label>
                            <input type="number" class="form-control" name="matricula" id="matricula" placeholder="Matr&iacute;cula" value="<#if (estudiante.matricula)??>${estudiante.matricula?string["0"]}</#if>" required>
                        </div>
                        <div class="form-group">
                            <label for="nombre">Nombre:</label>
                            <input type="text" class="form-control" name="nombre" id="nombre" placeholder="Nombre" value="<#if (estudiante.nombre)??>${estudiante.nombre}</#if>" required>
                        </div>
                        <div class="form-group">
                            <label for="apellido">Apellido:</label>
                            <input type="text" class="form-control" name="apellido" id="apellido" placeholder="Apellido" value="<#if (estudiante.apellido)??>${estudiante.apellido}</#if>" required>
                        </div>
                        <div class="form-group">
                            <label for="telefono">Tel&eacute;fono:</label>
                            <input type="tel" class="form-control" name="telefono" id="telefono" placeholder="Tel&eacute;fono" value="<#if (estudiante.telefono)??>${estudiante.telefono}</#if>">
                        </div>
                        <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal">Guardar</button>

                        <!-- Modal -->
                        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalCenterTitle">Guardar Cambios</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <h5 class="h5">¿Esta seguro que desea guardar los cambios?</h5>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                                        <button type="submit" class="btn btn-primary">Guardar</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>