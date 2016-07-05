<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/estilos.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="../css/estilos.css" rel="stylesheet">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<title>Stock actual</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<c:if test="${mensajeError != null}">	  	
				<div class="col-md-4"></div>
 				<div class="col-md-4"><p><h4><c:out value="${mensajeError}"/></h4><p>	</div>
 				<div class="col-md-4"></div>
			</c:if>
		</div>
		<div class="row">
			<br></br>
			<div class="table-responsive">
				<table class="table table-striped">
					<tr>
						<td><strong>Nuestro stock actual</strong></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td>Ingrediente</td>
						<td>Cantidad en stock</td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<c:forEach items="${miStock}" var="ingredienteActual">
						<tr>
							<td>${ingredienteActual.key.getNombre()}</td>
							<td>${ingredienteActual.value}</td>
							<td><a class="btn btn-primary" href="agregar_stock/${ingredienteActual.key.getNombre()}" 	role="button">Agregar cantidad</a></td>
							<td><a class="btn btn-primary" href="restar_stock/${ingredienteActual.key.getNombre()}" 	role="button">Reducir cantidad</a></td>
							<td><a class="btn btn-danger" href="confirmar_eliminar_ingrediente/${ingredienteActual.key.getNombre()}" 	role="button">Eliminar ingrediente</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
			<a type="button" class="btn btn-info" href="nuevo_ingrediente">Agregar ingrediente</a>
		</div>
		<div class="row"></div>
	</div>
</body>
</html>