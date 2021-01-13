package com.pildorasinformaticas.producto;

import java.sql.*;
import java.util.*;
import java.util.Date;

import javax.sql.DataSource;

public class ModeloProductos
{
	private DataSource origenDatos;
	
	public ModeloProductos(DataSource orgienDatos)
	{
		this.origenDatos = orgienDatos;
	}
	
	public List<Producto> getProductos() throws Exception{
		List<Producto> productos = new ArrayList<>();
		
		Connection conexion = null;
		Statement consulta = null;
		ResultSet resultado = null;
		
		//------------establecer la conexion--------------
		conexion=origenDatos.getConnection();
		
		//------------crear sentencia sql y statement-----
		String consultaSQL = "SELECT * FROM PRODUCTOS";
		consulta = conexion.createStatement();
		
		//------------ejecutar sql------------------------
		resultado = consulta.executeQuery(consultaSQL);
		//------------recorrer el ResultSet obtenido------
		while(resultado.next()) {
			/*
			String cod_art = resultado.getString("CÓDIGOARTÍCULO");
			String seccion = resultado.getString("SECCIÓN");
			String nom_art = resultado.getString("NOMBREARTÍCULO");
			double precio = resultado.getDouble("PRECIO");
			Date fecha = resultado.getDate("FECHA");
			boolean importado = resultado.getBoolean("IMPORTADO");
			String pais_orig = resultado.getString("PAÍSDEORIGEN");
			
			Producto producto = new Producto(cod_art, seccion, nom_art, precio, fecha, importado, pais_orig);
			
			productos.add(producto);
			*/
			productos.add(new Producto(resultado.getString("CÓDIGOARTÍCULO"),
									   resultado.getString("SECCIÓN"),
									   resultado.getString("NOMBREARTÍCULO"),
									   resultado.getDouble("PRECIO"),
									   resultado.getDate("FECHA"),
									   resultado.getBoolean("IMPORTADO"),
									   resultado.getString("PAÍSDEORIGEN")));
		}
		return productos;
	}
	public void agregarProducto(Producto producto){
		Connection conexion = null;
		PreparedStatement consulta = null;
		
		// obtener la conexion
		try {
		conexion = origenDatos.getConnection();
			
		// crear la instruccion sql que inserte el producto
		String sql = "INSERT INTO productos (CÓDIGOARTÍCULO,SECCIÓN,NOMBREARTÍCULO,PRECIO,FECHA,IMPORTADO,PAÍSDEORIGEN) "+ 
					"VALUES (?, ?, ?, ?, ?, ?, ?)";
		consulta = conexion.prepareStatement(sql);

		
		// establecer los parametros para el producto
		
		consulta.setString(1, producto.getCodigoArt());
		consulta.setString(2, producto.getSeccion());
		consulta.setString(3, producto.getNombreArt());
		consulta.setDouble(4, producto.getPrecio());
		java.util.Date fecha = producto.getFecha();
		java.sql.Date fecha_sql = new java.sql.Date(fecha.getTime());
		consulta.setDate(5, fecha_sql);
		consulta.setBoolean(6, producto.getImportado());
		consulta.setString(7, producto.getPaisOrigen());
		// ejecutar la instruccion SQL
		
		consulta.execute();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	public Producto obtenerProducto(String cod_articulo) throws Exception {
		Producto producto = null;
		Connection conexion = null;
		PreparedStatement consulta = null;
		ResultSet resultado = null;
		
		// Establecer la conexion con la BBDD
		
		try {
			conexion = origenDatos.getConnection();
			
			// Crear SQL que busque el producto
			String sql = "SELECT * FROM Productos WHERE CÓDIGOARTÍCULO=?";
			
			// Crear la consulta preparada
			consulta = conexion.prepareStatement(sql);
			
			// Establecer los parametros
			consulta.setString(1, cod_articulo);
			
			// Ejecutar la consulta
			 resultado = consulta.executeQuery();
			
			// Obtener los datos de respuesta
			 if(resultado.next()) {
				 producto = new Producto(resultado.getString("SECCIÓN"),
						   				 resultado.getString("NOMBREARTÍCULO"),
						   				 resultado.getDouble("PRECIO"),
						   				 resultado.getDate("FECHA"),
						   				 resultado.getBoolean("IMPORTADO"),
						   				 resultado.getString("PAÍSDEORIGEN"));
			 }else {
				 throw new Exception("No hemos encontrado el producto con codigo articulo = "+cod_articulo);
			 }
			 
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return producto;
	}
}
