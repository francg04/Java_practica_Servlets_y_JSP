package com.pildorasinformaticas.producto;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ControladorProductos
 */
@WebServlet("/ControladorProductos")
public class ControladorProductos extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private ModeloProductos modelo_productos;
	
	@Resource(name="jdbc/Productos")
	private DataSource origen_Datos;
	
	/*
	 * Sobreescribimos el metodo init() el cual sera DESDE el cual arranca
	 * nuestra aplicacion.
	 */
	@Override
	public void init() throws ServletException
	{
		super.init();
		try {
			modelo_productos = new ModeloProductos(origen_Datos);
		}
		catch(Exception e) {
			throw new ServletException(e);
		}
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//Obtener la lista de productos desde el modelo
		List<Producto> productos;
		try {
			productos = modelo_productos.getProductos();
		// Agregar lista de productos al request
			request.setAttribute("lista_productos", productos);
		//Enviar ese request a la pagina JSP
			
			RequestDispatcher mensajero = request.getRequestDispatcher("/ListaProductos.jsp");
			
			mensajero.forward(request, response);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
