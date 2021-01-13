<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*, com.pildorasinformaticas.producto.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista de productos</title>
<link rel="StyleSheet" type="text/css" href="css/estilo_listaProductos.css">
</head>
<%
	//obtiene los productos del controlador (Servlet)
	List<Producto> productos = (List<Producto>) request.getAttribute("lista_productos");
%>
<body>
	<table>>
	<tr>
		<th class="primero">Codigo Articulo</th>
		<th>Seccion</th>
		<th>Nombre Articulo</th>
		<th>Fecha</th>
		<th>Precio</th>
		<th>Importado</th>
		<th class="ultimo">Pais de origen</th>
	</tr>
	<%
		for(Producto producto:productos){%>
		<tr>
			<td>
				<%=producto.getCodigoArt() %>
			</td>
			<td>
				<%=producto.getSeccion() %>
			</td>
			<td>
				<%=producto.getNombreArt() %>
			</td>
			<td>
				<%=producto.getFecha() %>
			</td>
			<td>
				<%=producto.getPrecio() %>
			</td>
			<td>
				<%=producto.getImportado() %>
			</td>
			<td>
				<%=producto.getPaisOrigen() %>
			</td>
		</tr>	
		<%} %>
	</table>
</body>
</html>