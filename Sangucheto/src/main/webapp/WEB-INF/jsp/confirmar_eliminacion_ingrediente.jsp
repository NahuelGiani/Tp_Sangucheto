
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="../css/estilos.css" rel="stylesheet">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<title>Aumentar stock</title>
</head>
<body>
	<div class="container">
		<form:form method="GET" action="../eliminar_ingrediente">

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
					<input type="text" class="form-control"
						placeholder='${miStock.obtenerStockDisponible(miIngrediente)}' readonly></input>
				</div>
			</div>
		<br></br>
			<div class="form-group">
				<div class="col-sm-offset-3 col-sm-10">
					<p>Esta seguro que desea eliminar el ingrediente? (no podrá recuperarse)</p>
					<button type="submit" class="btn btn-danger" name="Enviar">Eliminar</button>
					<a class="btn btn-primary" href="../stock_actual" role="button">Cancelar y volver</a>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>
