<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: natha
  Date: 06/08/2021
  Time: 08:33 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}"></c:set>

<html>
<head>
    <link href="${context}/assets/plugins/bootstrap/css/bootstrap.css" rel="stylesheet">
    <title>Games</title>
    <link rel="stylesheet" href="${context}/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
</head>
<body onload="displayContent()">
    <div id="content">
        <br>
        <button type="button" class="btn btn-outline-success btn-sm"  data-bs-toggle="modal" data-bs-target="#create"> Crear</button>
        <br>
        <table>
            <table class="table">
                <thead class="table-dark">
                <th>Nombre</th>
                <th>Fecha de estreno</th>
                <th>Imagen</th>
                <th>Categoría</th>
                <th>Status</th>
                </thead>
                <tbody id="body">
                </tbody>
        </table>
            <div class="modal fade" id="create" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="exampleModalLabel">Agregar videojuego</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                <label>Nombre del videojuego: </label>
                                <input class="form-control" type="text" name="name"  id="nameGame">
                                <br>
                                <label>Imagen:</label>
                                <input class="form-control" type="file" name="image"  id="img">
                                <br>
                                <label>Fecha de lanzamiento:</label>
                                <input class="form-control" type="date" name="datePremiere"  id="datePremiere">
                                <br>
                                <label>Categoría:</label>
                                <select class="form-select" name="type" id="category" >
                                    <option value="0">Seleccione una categoría...</option>
                                    <option value="1">Estrategia</option>
                                    <option value="2">Deportivos</option>
                                    <option value="3">Aventura</option>
                                </select>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"><i class="fas fa-times"></i> Cerrar</button>
                                <button type="button" class="btn btn-success" onclick="createGame();"><i class="fas fa-plus"></i> Agregar</button>
                            </div>
                    </div>
                </div>
            </div>
    </div>
    <script src="${context}/assets/dist/js/main.js"></script>

    <script src="${context}/assets/plugins/bootstrap/js/bootstrap.bundle.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
            crossorigin="anonymous"></script>

</body>
</html>
