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
	private List<Producto> productos;
	
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
	/*
	 * ESPAÑA
	ITALIA
	MARRUECOS
	USA
	FRANCIA
	JAPÓN
	CHINA
	SUECIA
	TURQUÍA
	TAIWÁN
	 */

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// Leer el parametro del formulario
		String parametro = request.getParameter("instruccion");
		
		//si no se envia el parametro, listar productos
		if(parametro==null) {
			parametro = "listar";
		}
		// Redirigir el flujo de ejecucion al metodo adecuado
		switch(parametro) {
		case "listar":{
			//Obtener la lista de productos desde el modelo
			obtenerProductos(request, response);
		}break;
		case "insertarBBDD":{
			agregarProducto(request, response);
		}break;
		default:{
			obtenerProductos(request, response);
		}
		}
	}
	private void agregarProducto(HttpServletRequest request, HttpServletResponse response) {
		//Leer la informacion del producto que viene del formulario
		String codigo = request.getParameter("txtCodigo");
		String seccion = request.getParameter("txtSeccion");
		String articulo = request.getParameter("txtArticulo");
		String fecha = request.getParameter("txtFecha");
		String precio = request.getParameter("txtPrecio");
		String importado = request.getParameter("rbtImportado");
		
			
		//Crear un objeto de tipo Producto
		
		//Enviar el objeto al modelo y despues insertar el objeto Producto en la BBDD
		
		//Volver al listado de Productos
	}


	private void obtenerProductos(HttpServletRequest request, HttpServletResponse response)
	{
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
