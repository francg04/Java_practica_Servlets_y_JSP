<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, com.pildorasinformaticas.producto.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de productos</title>
</head>
<%
	//obtiene los productos del controlador (Servlet)
	List<Producto> productos = (List<Producto>) request.getAttribute("lista_productos");
%>
<body>
	<%= productos %>
</body>
</html>