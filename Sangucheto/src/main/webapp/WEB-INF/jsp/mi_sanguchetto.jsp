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
						<td class="active"><strong>Precio por unidad</strong></td>
						<td class="active"></td>
					</tr>
					<c:forEach items="${misIngredientesSanguchetto}" var="ingredienteActual">
						<tr>
							<td>${ingredienteActual.getNombre()}</td>
							<td>${ingredienteActual.getPrecio()}$</td>
							<td></td>
						</tr>
					</c:forEach>
					<tr>
						<td class="active"><strong>Condimento agregado</strong></td>
						<td class="active"><strong>Precio por unidad</strong></td>
						<td class="active"></td>
					</tr>
					<c:forEach items="${misCondimentosSanguchetto}" var="condimentoActual">
						<tr>
							<td>${condimentoActual.getNombre()}</td>
							<td>${condimentoActual.getPrecio()}$</td>
						</tr>
					</c:forEach>
					<tr>
						<td class="info"><strong>TOTAL:</strong></td>
						<td class="info"><strong>${Sanguchetto.getInstance().getPrecio()}</strong></td>
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
						<option value="${miCondimento.getNombre()}">${miCondimento.getNombre()}</option>
					</c:forEach>
				</select>
			</div>
			<div class="col-md-4"><button type="submit" class="btn btn-info">Agregar Condimento</button></div>
			</form>
		</div>
	<br></br>
	<br></br>
		<div class="row">
			<div class="col-md-4"><a class="btn btn-info"    type="button" href="index.jsp">Volver</a></div>
			<div class="col-md-4"><a class="btn btn-danger"  type="button" href="cancelar_sanguchetto">Cancelar sanguchetto</a></div>
			<div class="col-md-4"><a class="btn btn-primary" type="button" href="sanguchetto_final">Confirmar sanguchetto</a></div>
		</div>
		<br></br>
	</div>
</body>
</html>