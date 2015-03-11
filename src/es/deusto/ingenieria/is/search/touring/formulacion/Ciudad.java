package es.deusto.ingenieria.is.search.touring.formulacion;

import java.util.ArrayList;

public class Ciudad {
	private double x;
	private  double y;
	private int orden = -1;
	private String nombre;
    private ArrayList<Ciudad> ciudadesPosibles = new ArrayList<Ciudad>();



	public Ciudad(double x, double y, String nombre) {
		super();
		this.x = x;
		this.y = y;
		this.nombre = nombre;
	}
	public double getx() {
		return x;
	}
	public void setx(int x) {
		this.x = x;
	}
	public double gety() {
		return y;
	}
	public void sety(int y) {
		this.y = y;
	}
	public int getOrden() {
		return orden;
	}
	public void setOrden(int o) {
		this.orden = o;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override

	public String toString() {
		return "Ciudad " + nombre +" [x=" + x + ", y=" + y + "]\n";
	}
	public Ciudad() {}

	@SuppressWarnings("unchecked")
	public Object clone() 
	{
		Ciudad clon = null;

		try 
		{
			clon = (Ciudad) super.clone();
			clon.ciudadesPosibles = (ArrayList<Ciudad>) this.ciudadesPosibles.clone();
		} 
		catch (CloneNotSupportedException e) 
		{
			System.err.println("% [ERROR] Ciudad.clone(): " + e.getMessage());
		}

		return clon;		
	}
	public ArrayList<Ciudad> getCiudadesPosibles() {
		return ciudadesPosibles;
	}
	public void setCiudadesPosibles(ArrayList<Ciudad> ciudadesPosibles) {
		this.ciudadesPosibles = ciudadesPosibles;
	}
}
