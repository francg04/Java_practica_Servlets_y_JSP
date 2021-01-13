package com.pildorasinformaticas.producto;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
/**
 * Servlet implementation class ServletPruebas
 */
@WebServlet("/ServletPruebas")
public class ServletPruebas extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // Definir o establecer el DataSource
	/*
	 * Se debe colocar el valor de la propiedad name, que se definio en el archivo context.xml
	 * En este caso era: name="jdbc/Productos"
	 */
	@Resource(name="jdbc/Productos")
	/*
	 * Despues de declarar la directiva Resource, 
	 * debemos crear una variable de tipo DataSource donde almacenaremos
	 * nuestro pool
	 */
	private DataSource miPool;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPruebas() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		// Crear el objeto printWritter
		
		PrintWriter salida = response.getWriter();
		response.setContentType("text/plain");
		
		// Crear conexion con BBDD
		Connection conexion = null;
		Statement consulta = null;
		ResultSet resultado = null;
		try {
			// Creamos la consultaSQL 
			String consulta_obtenerProductos = "SELECT * FROM PRODUCTOS";
			// Tenemos que utilizar el pool para hacer la conexion
			conexion = miPool.getConnection();
			consulta = conexion.createStatement();
			resultado = consulta.executeQuery(consulta_obtenerProductos);
			while (resultado.next())
			{
				String nombre_articulo = resultado.getString(3);
				salida.println(nombre_articulo);
			}
		}catch(Exception e) {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
