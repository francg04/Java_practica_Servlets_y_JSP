package com.pildorasinformaticas.producto;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.swing.JOptionPane;

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
		case "cargar":{
			try {
				actualizarProductos(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}break;
		default:{
			obtenerProductos(request, response);
		}
		}
	}
	private void actualizarProductos(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// Leer el parametro Cod_Articulo que viene de la pagina JSP
		String cod_articulo = request.getParameter("Cod_Articulo");
		
		// Enviar Cod_Articulo al Modelo
		Producto producto = modelo_productos.obtenerProducto(cod_articulo);
		
		// Colocar atributo correspondiente al Cod_Articulo
		
		request.setAttribute("CODIGO_ARTICULO", producto);
		
		// Enviar Producto al formulario de actualizar (jsp)
		
		RequestDispatcher mensajero = request.getRequestDispatcher("/actualizarProducto.jsp");
		mensajero.forward(request, response);
	}
	private void agregarProducto(HttpServletRequest request, HttpServletResponse response) {
		//Leer la informacion del producto que viene del formulario
		String codigo = request.getParameter("txtCodigo");
		String seccion = request.getParameter("txtSeccion");
		String articulo = request.getParameter("txtArticulo");
		double precio = Double.parseDouble(request.getParameter("txtPrecio"));
		//-INICIO carga Fecha
		SimpleDateFormat formato_fecha = new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = null;
		
		try {
			fecha = formato_fecha.parse(request.getParameter("txtFecha"));
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		//-FIN carga fecha
		boolean importado = Boolean.parseBoolean(request.getParameter("rbtImportado"));
		String origen = request.getParameter("txtOrigen");
		
		String pais = cargarPais(origen);
		/*//PRUEBAS
		System.out.println("DATOS: ");
		System.out.println("Pais de origen: "+origen);
		System.out.println("Importado: "+importado);
		System.out.println("Importado: "+fecha);
		*/
		/*
		 * IMPORTANTE: Hay que tener en cuenta que la informacion que DEVUELVE
		 * el metodo getParameter() SIEMPRE es de TIPO STRING
		 */
		
			
		//Crear un objeto de tipo Producto
		
		Producto producto = new Producto(codigo, seccion, articulo, precio, fecha, importado, pais);
		
		//Enviar el objeto al modelo y despues insertar el objeto Producto en la BBDD
		modelo_productos.agregarProducto(producto);
		
		//Volver al listado de Productos
		obtenerProductos(request, response);
	}
	private String cargarPais(String pais)
	{
		String resultado = "";
		switch(pais) {
		case "espania":{
			resultado="ESPAÑA";
		}break;
		case "italia":{
			resultado="ITALIA";
		}break;
		case "marruecos":{
			resultado="MARRUECOS";
		}break;
		case "usa":{
			resultado="USA";
		}break;
		case "francia":{
			resultado="FRANCIA";
		}break;
		case "japon":{
			resultado="JAPÓN";
		}break;
		case "china":{
			resultado="CHINA";
		}break;
		case "suecia":{
			resultado="SUECIA";
		}break;
		case "turquia":{
			resultado="TURQUÍA";
		}break;
		case "taiwan":{
			resultado="TAIWÁN";
		}break;
		}
		return resultado;
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
