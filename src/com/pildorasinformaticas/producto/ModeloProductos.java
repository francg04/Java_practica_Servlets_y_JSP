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
			String cod_art = resultado.getString("C�DIGOART�CULO");
			String seccion = resultado.getString("SECCI�N");
			String nom_art = resultado.getString("NOMBREART�CULO");
			double precio = resultado.getDouble("PRECIO");
			Date fecha = resultado.getDate("FECHA");
			boolean importado = resultado.getBoolean("IMPORTADO");
			String pais_orig = resultado.getString("PA�SDEORIGEN");
			
			Producto producto = new Producto(cod_art, seccion, nom_art, precio, fecha, importado, pais_orig);
			
			productos.add(producto);
			*/
			productos.add(new Producto(resultado.getString("C�DIGOART�CULO"),
									   resultado.getString("SECCI�N"),
									   resultado.getString("NOMBREART�CULO"),
									   resultado.getDouble("PRECIO"),
									   resultado.getDate("FECHA"),
									   resultado.getBoolean("IMPORTADO"),
									   resultado.getString("PA�SDEORIGEN")));
		}
		return productos;
	}
}
