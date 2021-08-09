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
</head>
<body onload="displayContent()">
    <div id="content">
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
    </div>
    <script src="${context}/assets/dist/js/main.js"></script>

    <script src="${context}/assets/plugins/bootstrap/js/bootstrap.bundle.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
            crossorigin="anonymous"></script>
</body>
</html>
