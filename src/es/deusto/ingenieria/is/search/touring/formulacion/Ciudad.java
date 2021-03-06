package es.deusto.ingenieria.is.search.touring.formulacion;

import java.util.ArrayList;

public class Ciudad {
	private double x;
	private  double y;
	private String nombre;
	private ArrayList<Ciudad> ciudadesPosibles = new ArrayList<Ciudad>();

	public Ciudad() {}

	public Ciudad(double x, double y, String nombre) {
		super();
		this.x = x;
		this.y = y;
		this.nombre = nombre;
	}
	public double getx() {
		return x;
	}
	public void setx(double x) {
		this.x = x;
	}
	public double gety() {
		return y;
	}
	public void sety(double y) {
		this.y = y;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	/**
	 * toString que muestra los datos de la cicudad
	 */
	public String toString() {
		return "Ciudad " + nombre +" [x=" + x + ", y=" + y + "]\n";
	}

	public ArrayList<Ciudad> getCiudadesPosibles() {
		return ciudadesPosibles;
	}
	public void setCiudadesPosibles(ArrayList<Ciudad> ciudadesPosibles) {
		this.ciudadesPosibles = ciudadesPosibles;
	}
}