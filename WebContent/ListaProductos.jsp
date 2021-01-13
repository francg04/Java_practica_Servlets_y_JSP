<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de productos</title>
<link rel="StyleSheet" type="text/css" href="css/estilo_listaProductos.css">
</head>
<%
	//obtiene los productos del controlador (Servlet)
	//List<Producto> productos = (List<Producto>) request.getAttribute("lista_productos");
%>
<body>
	<table>
	<tr>
		<th class="primero">Codigo Articulo</th>
		<th>Seccion</th>
		<th>Nombre Articulo</th>
		<th>Fecha</th>
		<th>Precio</th>
		<th>Importado</th>
		<th>Pais de origen</th>
		<th class="ultimo"><input type="button" value="Insertar Registro" onclick="window.location.href='inserta_producto.jsp'"/></th>
	</tr>
	<c:forEach var="producto" items="${lista_productos}">
	
	<!-- Link para cada producto con su campo clave -->
	
	<c:url var="linkTemp" value="ControladorProductos">
		<c:param name="instruccion" value="cargar"></c:param>
		<c:param name="Cod_Articulo" value="${producto.codigoArt}"></c:param>
	</c:url>
	
		<tr>
			<td> ${producto.codigoArt} </td>
			<td> ${producto.seccion} </td>
			<td> ${producto.nombreArt} </td>
			<td> ${producto.precio} </td>
			<td> ${producto.fecha} </td>
			<td> ${producto.importado} </td>
			<td> ${producto.paisOrigen} </td>
			<td> <a href="${linkTemp}">Actualizar</a> </td>
		</tr>
			
	</c:forEach>
	</table>
	<div id="contenedor_boton">
		
	</div>
</body>
</html>