<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/estilos.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link rel="shortcut icon" href="<c:url value="/resources/img/favicon.ico" />" />
<title>Restar stock</title>
</head>
<body>
	<div class="container">
		<form:form method="GET" action="../restando_stock">

			<div class="form-group">
				<label for="inputEmail3" class="col-sm-3 control-label">Nombre
					del ingrediente:</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" name="nombre" 
						value='${miIngrediente.nombre}' readonly></input>
				</div>
			</div>
		<br></br>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-3 control-label">Stock actual</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" name="stock_actual" 
						value='${miStock.obtenerStockDisponible(miIngrediente)}' readonly></input>
				</div>
			</div>
		<br></br>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-3 control-label">Cuánto
					stock desea restar?</label>
				<div class="col-sm-9">
					<input type="number" name="stock_a_restar" required />
				</div>
			</div>
		<br></br>
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-10">
					<button type="submit" class="btn btn-info" name="Enviar">Enviar</button>
					<a class="btn btn-primary" href="../stock_actual" role="button">Volver</a>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>