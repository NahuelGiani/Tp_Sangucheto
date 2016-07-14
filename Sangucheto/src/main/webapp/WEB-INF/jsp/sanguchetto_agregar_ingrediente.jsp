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
<title>Aumentar stock</title>
</head>
<body>
	<div class="container">
		<form:form method="GET" action="/confirmar_agregar_ingrediente">

			<div class="form-group">
				<label for="inputEmail3" class="col-sm-3 control-label">Nombre
					del ingrediente:</label>
				<div class="col-sm-9">
					<input type="text" class="form-control" name="nombre" 
						value='${miIngrediente.nombre}' readonly required></input>
				</div>
			</div>
		<br></br>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-3 control-label">Precio</label>
				<div class="col-sm-9">
					<input type="text" class="form-control"
						placeholder='${miIngrediente.precio}$' readonly></input>
				</div>
			</div>
		<br></br>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-3 control-label">Por favor, confirme su ingrediente al sanguchetto</label>
				<button type="submit" class="btn btn-info" name="Confirmar">Enviar</button>
				<a class="btn btn-primary" href="mi_sanguchetto" role="button">Volver</a>
			</div>
		</form:form>
	</div>
</body>
</html>