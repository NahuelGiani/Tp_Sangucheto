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
						<td class="active"><strong><h3>Agregando ingredientes a MiSanguchetto</h3></strong></td>
						<td class="active"></td>
						<td class="active"></td>
					</tr>
					<tr>
						<td class="active"><strong>Ingrediente agregado</strong></td>
						<td class="active"><strong>Precio</strong></td>
						<td class="active"></td>
					</tr>
					<c:forEach items="${misIngredientesSanguchetto}" var="ingredienteActual">
						<tr>
							<td>${ingredienteActual.key.getNombre()}</td>
							<td>${ingredienteActual.key.getPrecio()}$</td>
							<td><a class="btn btn-danger"
								href="confirmar_eliminar_ingrediente/${ingredienteActual.key.getNombre()}"
								role="button">Eliminar ingrediente</a></td>
						</tr>
					</c:forEach>
					<tr>
						<td class="active"><strong>Condimento agregado</strong></td>
						<td class="active"><strong>Precio</strong></td>
						<td class="active"></td>
					</tr>
					<c:forEach items="${misCondimentosSanguchetto}" var="condimentoActual">
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
			<div class="col-md-4"><p>Ingredientes a agregar:</p></div>
			<div class="col-md-4">
			<form class="form-inline" action="agregar_ingrediente_sanguchetto" method="POST">
				<select class="form-control" name="ingrediente_elegido">
					<c:forEach items="${misIngredientesStock}" var="miIngrediente">
						<option value="${miIngrediente.getNombre()}">${miIngrediente.getNombre()}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-md-4"><button type="submit" class="btn btn-info">Agregar ingrediente</button></div>
			</form>
		</div>
	<br></br>
		<div class="row">
			<div class="col-md-4"><p>Condimentos a agregar:</p></div>
			<div class="col-md-4">
			<form class="form-inline" action="agregar_condimento_sanguchetto" method="POST">
				<select class="form-control" name="condimento_elegido">
					<c:forEach items="${misCondimentosStock}" var="miCondimento">
						<option value="${miCondiment.key.getNombre()}">
							${miCondimento.getNombre()}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-md-4"><button type="submit" class="btn btn-info">Agregar Condimento</button></div>
			</form>
		</div>
	<br></br>
	<br></br>
		<div class="row">
			<div class="col-md-4"><a class="btn btn-info" href="index.jsp" role="button">Volver</a></div>
			<div class="col-md-4"><button type="button" class="btn btn-danger">Cancelar sanguchetto</button></div>
			<div class="col-md-4"><button type="button" class="btn btn-primary">Confirmar sanguchetto</button></div>
		</div>
	</div>
</body>
</html>