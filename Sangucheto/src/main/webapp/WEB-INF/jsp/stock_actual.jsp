<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/estilos.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>Stock actual</title>
</head>
<body>

	<div class="container">
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<td><strong>Productos actuales en stock</strong></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>Ingrediente</td>
					<td>Cantidad</td>
					<td>Aumentar stock</td>
					<td>Eliminar stock</td>
				</tr>
				<c:forEach items="${miStock}" var="ingredienteActual">
					<tr>
						<td>${ingredienteActual.key.getNombre()}</td>
						<td>${ingredienteActual.value}</td>
						<td><a class="btn btn-default" href="agregar_stock/${ingredienteActual}" role="button">+</a></td>
						<td><a class="btn btn-default" href="eliminar_stock/${ingredienteActual}" role="button">-</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<a type="button" class="btn btn-primary" href="nuevo_ingrediente">Agregar ingrediente</a>
	</div>

</body>
</html>