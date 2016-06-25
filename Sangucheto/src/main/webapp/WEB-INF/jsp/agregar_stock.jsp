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
	<form:form class="form-horizontal" method="POST" action="agregar_stock">

		<div class="form-group">
			<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
			<div class="col-sm-10">
				<input type="email" class="form-control" id="inputEmail3"
					placeholder="Email">
			</div>
		</div>
		<div class="form-group">
			<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
			<div class="col-sm-10">
				<input type="password" class="form-control" id="inputPassword3"
					placeholder="Password">
			</div>
		</div>
		<div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default" name="Enviar">Enviar</button>
			</div>
		</div>
		</form>
		<tr>
			<td><label>Nombre del ingrediente</label></td>
			<td><c:out value="${ingredienteAModificar.getNombre()}" /></td>
		</tr>
		<tr>
			<td><label>Cuánto stock desea agregar?</label></td>
			<td><input type="number" name="cantidad" /></td>
		</tr>
		<tr>
			<td><input type="submit" name="Enviar" /></td>
		</tr>
		</table>
	</form:form>
</body>
</html>