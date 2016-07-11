<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/estilos.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link rel="shortcut icon" href="<c:url value="/resources/img/favicon.ico" />" />
<title>Creando nuevo ingrediente</title>
</head>
<body>
	<div class="container">
		<form:form method="POST" modelAttribute="ingrediente"
			action="agregar_ingrediente">

			<div class="form-group">
				<label for="inputEmail3" class="col-sm-3 control-label">Nombre
					del ingrediente:</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" name="nombre"
						placeholder="Nombre" required>
				</div>
			</div>
		<br></br>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-3 control-label">Precio</label>
				<div class="col-sm-9">
					<input type="number" class="form-control" name="precio"
						placeholder="Precio" required>
				</div>
			</div>
		<br></br>
			<div class="form-group">
				<label class="col-sm-3 control-label">Tipo:</label>
				<label class="radio-inline"> <input type="radio"
					name="inlineRadioOptions" id="inlineRadio1" value="INGREDIENTE" required>
					Ingrediente
				</label> <label class="radio-inline"> <input type="radio"
					name="inlineRadioOptions" id="inlineRadio2" value="CONDIMENTO" required>
					Condimento
				</label>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-10">
					<button type="submit" class="btn btn-info" name="Enviar">Enviar</button>
					<a class="btn btn-primary" href="../stock/stock_actual" role="button">Volver</a>
				</div>
			</div>
		</div>
		</form:form>
	</div>
</body>
</html>