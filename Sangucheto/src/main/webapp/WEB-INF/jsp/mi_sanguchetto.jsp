<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
						<td class="active"><strong><h3>Agregando ingredientes a Mi
									Sanguchetto</h3></strong></td>
						<td class="active"></td>
						<td class="active"></td>
					</tr>
					<tr>
						<td class="active"><strong>Ingrediente agregado</strong></td>
						<td class="active"><strong>Precio</strong></td>
						<td class="active"></td>
					</tr>
					<c:forEach items="${miStock}" var="ingredienteActual">
						<tr>
							<td>${ingredienteActual.key.getNombre()}</td>
							<td>${ingredienteActual.key.getPrecio()}$</td>
							<td><a class="btn btn-danger"
								href="confirmar_eliminar_ingrediente/${ingredienteActual.key.getNombre()}"
								role="button">Eliminar ingrediente</a></td>
						</tr>
					</c:forEach>
					<tr>
						<td class="info"><strong>TOTAL:</strong></td>
						<td class="info"><strong></strong></td>
						<td class="info"></td>
					</tr>
				</table>
			</div>
		</div>
	<br></br>
		<div class="row">
			<div class="col-md-4"><p>Ingredientes a agregar</p></div>
			<div class="col-md-4">Condimentos a agregar</div>
			<div class="col-md-4"></div>
		</div>
		<div class="row">
		<form class="form-inline" action="#">
			<div class="col-md-4">
				<select class="form-control">
					<c:forEach items="${misIngredientes}" var="miIngrediente">
						<option value="${miIngrediente.getNombre()}">${miIngrediente.getNombre()}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-md-4">
				<select class="form-control">
					<c:forEach items="${misCondimentos}" var="miCondimento">
						<option value="${miCondiment.key.getNombre()}">
							${miCondimento.getNombre()}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-md-4">	
				<button type="button" class="btn btn-danger">Cancelar sanguchetto</button>
			</div>
		</form>
		</div>
	<br></br>
		<div class="row">
			<div class="col-md-4"><button type="button" class="btn btn-info">Agregar ingrediente</button></div>
			<div class="col-md-4"><button type="button" class="btn btn-info">Agregar condimento</button></div>
			<div class="col-md-4"><button type="submit" class="btn btn-primary">Confirmar sanguchetto</button></div>
		</div>
	</div>
</body>
</html>