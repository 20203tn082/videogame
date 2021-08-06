<%--
  Created by IntelliJ IDEA.
  User: natha
  Date: 06/08/2021
  Time: 09:37 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Inicio de sesión</title>
    <link rel="stylesheet" href="${context}/assets/plugins/bootstrap/css/bootstrap.min.css">
</head>
<body>
<h1>Iniciar sesión</h1>
<form action="${context}/login" method="POST">
    <label>Correo electrónico:</label>
    <input class="form-control" type="email" name="email" />
    <br>
    <label>Contraseña:</label>
    <input class="form-control" type="password" name="password"/>
    <br>
    <button type="submit" class="btn btn-primary">Acceder</button>
</form>
<script src="${context}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</body>
</html>
