package Clases;

import java.util.Date;

public class Stock {

	private  Date fecha;
	private int cantidad;
	private int IdP;
	
	public Stock() {
		
	}
	
	public Date getFecha() {
		return fecha;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setFecha(Date Fecha) {
		this.fecha = Fecha;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getIdP() {
		return IdP;
	}

	public void setIdP(int idP) {
		IdP = idP;
	}

	@Override
	public String toString() {
		return " Id Producto = " + IdP +" | cantidad= " + cantidad + " | fecha= " + fecha;
	}
	
}
