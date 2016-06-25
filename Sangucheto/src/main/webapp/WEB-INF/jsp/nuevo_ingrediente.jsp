
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/estilos.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>Prueba SPRING MVC - Agregar usuario</title>
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
						placeholder="Nombre">
				</div>
			</div>
		<br></br>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-3 control-label">Precio</label>
				<div class="col-sm-9">
					<input type="number" class="form-control" name="precio"
						placeholder="Precio">
				</div>
			</div>
		<br></br>
			<div class="form-group">
				<label class="col-sm-3 control-label">Tipo:</label>
				<label class="radio-inline"> <input type="radio"
					name="inlineRadioOptions" id="inlineRadio1" value="INGREDIENTE">
					Ingrediente
				</label> <label class="radio-inline"> <input type="radio"
					name="inlineRadioOptions" id="inlineRadio2" value="CONDIMENTO">
					Condimento
				</label>
			</div>

			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-10">
					<button type="submit" class="btn btn-default" name="Enviar">Enviar</button>
				</div>
			</div>
	</div>
	</form:form>
	</div>
</body>
</html>