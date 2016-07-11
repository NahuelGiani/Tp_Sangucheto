<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="<c:url value="/resources/css/estilos.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/links_index.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
<link rel="shortcut icon" href="<c:url value="/resources/img/favicon.ico" />" />
<title>Bienvenido a MiSanguchetto.com</title>
</head>
<body>

	<div id="contenedor" class="container">
		<div class="row">
			<div class="col-md-3"></div>
	  		<div class="col-md-6">
	  			<br></br>
	  			<h2>Bienvenido a SuSanguchetto.com!</h2>
			</div>
	 		<div class="col-md-3"></div>
		</div>
	<br></br>
	<br></br>
		<div class="row">
			<div class="col-md-1"></div>
			<div id="link_sangucheto" class="col-md-5">
				<a href="mi_sanguchetto">
					<h3>Cree su sanguchetto ahora mismo!</h3>
					<br></br>
					<div id="imagen1"><img src="<c:url value="/resources/img/sanguchetto.jpg"/>"/></img></div>
				</a>
			</div>
			<div class="col-md-5">
				<a href="stock/stock_actual">
					<h3>Modifique el catalogo y stock (Admin)</h3>
					<br></br>
					<div id="imagen2"><img src="<c:url value="/resources/img/stock.jpg"/>"/></img></div>
				</a>
			</div>
			<div class="col-md-1"></div>
		</div>
		
	</div>

</body>
</html>