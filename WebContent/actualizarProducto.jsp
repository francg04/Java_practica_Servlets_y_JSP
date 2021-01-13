<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.pildorasinformaticas.producto.Producto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body onLoad="setImportado()">
<h1>Actualizar Producto</h1>
<form action="ControladorProductos" method="get">
<input type="hidden" name="instruccion" value="actualizarBBDD">
<input type="hidden" name="Cod_Art" value="${Cod_Articulo}">
	<table>
	
		<tr>
			<td><label for="txtCodigo">Codigo Articulo</label></td><td><input type="text" name="txtCodigo" value="${Cod_Articulo}" readonly></td>
		</tr>
		<tr>
			<td><label for="txtSeccion">Seccion </label></td><td><input type="text" name="txtSeccion" value="${ProductoAtcualizar.seccion}"></td>
		</tr>
		<tr>
			<td><label for="txtArticulo">Articulo</label></td><td><input type="text" name="txtArticulo" value="${ProductoAtcualizar.nombreArt}"></td>
		</tr>
		<tr>
			<td><label for="txtPrecio">Precio</label></td><td><input type="text" name="txtPrecio" value="${ProductoAtcualizar.precio}"></td>
		</tr>
		<tr>
			<td><label for="txtFecha">Fecha</label></td><td><input type="date" name="txtFecha" value="${ProductoAtcualizar.fecha}"></td>
		</tr>
			<c:if test="${ProductoAtcualizar.importado}">
				<tr>
					<td><label>Importado</label></td><td><label for="Si">Si</label> <input type="radio" id="Si"name="rbtImportado" value="true" checked> <label for="No">No</label> <input type="radio" id="No" name="rbtImportado" value="false"></td>
				</tr>
			</c:if>
			<c:if test="${!ProductoAtcualizar.importado}">
				<tr>
					<td><label>Importado</label></td><td><label for="Si">Si</label> <input type="radio" id="Si"name="rbtImportado" value="true" checked> <label for="No">No</label> <input type="radio" id="No" name="rbtImportado" value="false" checked></td>
				</tr>
			</c:if>
		<tr>
			<td><label for="txtOrigen">Origen</label></td><td><select name="txtOrigen">
		<%! String[][] paises; %>
		<% paises = new String [][] { {"espania","ESPAÑA"},
									  {"italia","ITALIA"},
									  {"marruecos","MARRUECOS"},
									  {"usa","USA"},
									  {"francia","FRANCIA"},
									  {"japon","JAPÓN"},
									  {"china","CHINA"},
									  {"suecia","SUECIA"},
									  {"turquia","TURQUÍA"},
									  {"taiwan","TAIWÁN"}};
												 
		Producto producto = (Producto)request.getAttribute("ProductoAtcualizar");
		
		String origen = producto.getPaisOrigen();
	
		for(int x=0; x<paises.length;x++){
			for(int y=0; y<1;y++){
				if(paises[x][y+1].equals(origen)){
					%><option value='<%=paises[x][y]%>' selected><%=paises[x][y+1] %></option><%
				}
				else{
					%><option value='<%=paises[x][y]%>'><%=paises[x][y+1] %></option><%
				}
			}
		}
		%>
		<!-- 
				<option value="espania">ESPAÑA</option>
				<option value="italia">ITALIA</option>
				<option value="marruecos">MARRUECOS</option>
				<option value="usa">USA</option>
				<option value="francia">FRANCIA</option>
				<option value="japon">JAPÓN</option>
				<option value="china">CHINA</option>
				<option value="suecia">SUECIA</option>
				<option value="turquia">TURQUÍA</option>
				<option value="taiwan">TAIWÁN</option>
		 -->
			</select></td>
		</tr>
		<tr>
			<td><input type="submit" name="Insertar" value="Refrescar"></td><td><input type="reset" name="borrar" value="Refrescar"></td>
		</tr>
	</table>
</form>
</body>
</html>