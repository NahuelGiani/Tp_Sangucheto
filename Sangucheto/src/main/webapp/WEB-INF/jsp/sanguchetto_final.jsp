<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/estilos.css" />"
	rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<link rel="shortcut icon"
	href="<c:url value="/resources/img/favicon.ico" />" />
<title>Arme su sanguchetto!</title>
</head>

<body>
	<div class="container" id="contenedor">
		<div class="table-responsive">
			<div class="table-responsive">
				<table id="tabla_stock" class="table table-hover">
					<tr>
						<td class="active"><strong><h3>Mi Sanguchetto!</h3></strong></td>
						<td class="active"></td>
						<td class="active"></td>
					</tr>
					<tr>
						<td class="active"><strong>Ingredientes</strong></td>
						<td class="active"><strong>Precio</strong></td>
					</tr>
					<c:forEach items="${misIngredientesSanguchetto}" var="ingredienteActual">
						<tr>
							<td>${ingredienteActual.getNombre()}</td>
							<td>${ingredienteActual.getPrecio()}$</td>
						</tr>
					</c:forEach>
					<tr>
						<td class="active"><strong>Condimentos</strong></td>
						<td class="active"><strong>Precio</strong></td>
					</tr>
					<c:forEach items="${misCondimentosSanguchetto}" var="condimentoActual">
						<tr>
							<td>${condimentoActual.getNombre()}</td>
							<td>${condimentoActual.getPrecio()}$</td>
						</tr>
					</c:forEach>
					<tr>
						<td class="info"><strong>TOTAL:</strong></td>
						<td class="info"><strong></strong></td>
					</tr>
				</table>
					<a class="btn btn-primary" href="../sanguchetto/mi_sanguchetto" role="button">Volver</a>				
			</div>
		</div>
	</div>
</body>
</html>