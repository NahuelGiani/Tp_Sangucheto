<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/estilos.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link rel="shortcut icon" href="<c:url value="/resources/img/favicon.ico" />" />
<title>Stock actual</title>
</head>

<body>
	<div class="container">
		<div class="row">
			<br></br>
			<div class="table-responsive">
				<div class="table-responsive">
  					<table id="tabla_stock" class="table table-hover">
						<tr>
							<td><strong><h2>Nuestro stock actual</h2></strong></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td><strong>Ingrediente</strong></td>
							<td><strong>Cantidad en stock</strong></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
						<c:forEach items="${miStock}" var="ingredienteActual">
							<tr>
								<td>${ingredienteActual.key.getNombre()}</td>
								<td>${ingredienteActual.value}</td>
								<td><a class="btn btn-primary" href="agregar_stock/${ingredienteActual.key.getNombre()}" 	role="button">Agregar cantidad</a></td>
								<td><a class="btn btn-primary" href="restar_stock/${ingredienteActual.key.getNombre()}" 	role="button">Reducir cantidad</a></td>
								<td><a class="btn btn-danger" href="confirmar_eliminar_ingrediente/${ingredienteActual.key.getNombre()}" 	role="button">Eliminar ingrediente</a></td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			<a type="button" class="btn btn-info" href="nuevo_ingrediente">Agregar ingrediente</a>
			<a type="button" class="btn btn-primary" href="../index.jsp">Volver al index</a>
		</div>
		<div class="row"></div>
				<div id="error" class="row">
			<c:if test="${mensajeError != null}">	  	
				<br></br>
				<br></br>
				<div class="col-md-4"></div>
 				<div class="col-md-4"><p><h4><c:out value="${mensajeError}"/></h4><p></div>
 				<div class="col-md-4"></div>
			</c:if>
		</div>
	</div>
</body>
</html>