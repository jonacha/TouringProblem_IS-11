package es.deusto.ingenieria.is.search.touring.formulacion;

public class Ciudad {
	private int x;
	private  int y;
	private int orden;
	private String nombre;


	public Ciudad(int x, int y, String nombre) {

		this.x = x;
		this.y = y;
		this.orden = -1;
		this.nombre = nombre;
	}
	public int getx() {
		return x;
	}
	public void setx(int x) {
		this.x = x;
	}
	public int gety() {
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

	public Object clone() 
	{
		Object clon = null;

		try 
		{
			clon = super.clone();
		} 
		catch (CloneNotSupportedException e) 
		{
			System.err.println("% [ERROR] Room.clone(): " + e.getMessage());
		}

		return clon;		
	}
}
