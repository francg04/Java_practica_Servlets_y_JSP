<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Insertar Registro</h1>
<form action="ControladorProductos" method="get">
<input type="hidden" name="instruccion" value="insertarBBDD">
	<table>
		<tr>
			<td><label for="txtCodigo">Codigo Articulo</label></td><td><input type="text" name="txtCodigo"></td>
		</tr>
		<tr>
			<td><label for="txtSeccion">Seccion</label></td><td><input type="text" name="txtSeccion"></td>
		</tr>
		<tr>
			<td><label for="txtArticulo">Articulo</label></td><td><input type="text" name="txtArticulo"></td>
		</tr>
		<tr>
			<td><label for="txtPrecio">Precio</label></td><td><input type="text" name="txtPrecio"></td>
		</tr>
		<tr>
			<td><label for="txtFecha">Fecha</label></td><td><input type="date" name="txtFecha"></td>
		</tr>
		<tr>
			<td><label>Importado</label></td><td><label for="Si">Si</label> <input type="radio" id="Si"name="rbtImportado" value="true"> <label for="No">No</label> <input type="radio" id="No" name="rbtImportado" value="false"></td>
		</tr>
		<tr>
			<td><label for="txtOrigen">Origen</label></td><td><select name="txtOrigen">
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
			
			</select></td>
		</tr>
		<tr>
			<td><input type="submit" name="Insertar" value="Refrescar"></td><td><input type="reset" name="borrar" value="Refrescar"></td>
		</tr>
	</table>
</form>
</body>
</html>