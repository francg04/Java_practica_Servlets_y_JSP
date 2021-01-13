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
<form action="">
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
			<td><label for="txtFecha">Fecha</label></td><td><input type="Date" name="txtFecha"></td>
		</tr>
		<tr>
			<td><label for="txtPrecio">Precio</label></td><td><input type="text" name="txtPrecio"></td>
		</tr>
		<tr>
			<td><label>Importado</label></td><td><label for="Si">Si</label> <input type="radio" id="Si"name="rbtImportado" value="true"> <label for="No">No</label> <input type="radio" id="No" name="rbtImportado" value="false"></td>
		</tr>
		<tr>
			<td><input type="submit" name="enviar" value="Actualizar"></td><td><input type="reset" name="borrar" value="Refrescar"></td>
		</tr>
	</table>
</form>
</body>
</html>