package com.pildorasinformaticas.producto;

import java.util.Date;

public class Producto
{
	private String codigoArt;
	private String seccion;
	private String nombreArt;
	private double precio;
	private Date fecha;
	private boolean importado;
	private String paisOrigen;
	
	public Producto(String codigoArt, String seccion, String nombreArt, double precio, Date fecha, boolean importado,
			String paisOrigen) {
		super();
		this.codigoArt = codigoArt;
		this.seccion = seccion;
		this.nombreArt = nombreArt;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.paisOrigen = paisOrigen;
	}

	public Producto(String seccion, String nombreArt, double precio, Date fecha, boolean importado, String paisOrigen) {
		super();
		this.seccion = seccion;
		this.nombreArt = nombreArt;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.paisOrigen = paisOrigen;
	}
	
	@Override
	public String toString() {
		return "Producto [codigoArt=" + codigoArt + ", seccion=" + seccion + ", nombreArt=" + nombreArt + ", precio="
				+ precio + ", fecha=" + fecha + ", importado=" + importado + ", paisOrigen=" + paisOrigen + "]";
	}

	public String getCodigoArt() {
		return codigoArt;
	}

	public void setCodigoArt(String codigoArt) {
		this.codigoArt = codigoArt;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	public String getNombreArt() {
		return nombreArt;
	}

	public void setNombreArt(String nombreArt) {
		this.nombreArt = nombreArt;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public boolean getImportado() {
		return importado;
	}

	public void setImportado(boolean importado) {
		this.importado = importado;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}
}
