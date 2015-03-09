package es.deusto.ingenieria.is.search.touring.formulacion;

import java.util.ArrayList;

import es.deusto.ingenieria.is.search.formulation.State;

public class Entorno extends State implements Cloneable{
	private Ciudad inicio=new Ciudad();
	private Ciudad fin=new Ciudad();
	private Ciudad actual = new Ciudad();
	
	private  ArrayList <Ciudad>aCiudades=new ArrayList<Ciudad>();
	private ArrayList<Ciudad> aCiudadesVisitadas = new ArrayList<Ciudad>();

	public Ciudad getInicio() {
		return inicio;
	}
	public void setInicio(Ciudad inicio) {
		this.inicio = inicio;
	}
	public Ciudad getFin() {
		return fin;
	}
	public ArrayList<Ciudad> getCiudades() {
		return aCiudades;
	}
	public void setCiudades(ArrayList<Ciudad> ciudades) {
		this.aCiudades =  ciudades;
	}
	public void setFin(Ciudad fin) {
		this.fin = fin;
	}
	public Entorno(){

	}
	
	public Entorno(Ciudad inicio, Ciudad fin, ArrayList<Ciudad> ciudades) {
		super();
		this.inicio = inicio;
		this.fin = fin;
		aCiudades = ciudades;
	}
	@Override
	public String toString() {
		return "Entorno [inicio=" + inicio + ", fin=" + fin + ", Ciudades="
				+ aCiudades + "]";
		//posteriormente adecuaremos el estrinpara que se ordenen segun las ciudades
	}
	@Override
	public boolean equals(Object ent) 
	{
		boolean enc = false;
		int i = 0;
		if(ent != null && ent instanceof Entorno)
		{
			Entorno e = (Entorno) ent;
			if(e.getActual().getNombre().equals(this.actual.getNombre())
					&&e.getActual().getx()==this.actual.getx()&&e.getActual().gety()==this.actual.gety() 
					&&  e.getCiudadesVisitadas().size()==this.aCiudadesVisitadas.size()){
				while(enc && i < e.getCiudadesVisitadas().size())
				{
					if(e.getCiudadesVisitadas().get(i).getNombre().equals(this.aCiudadesVisitadas.get(i).getNombre())
							&&e.getCiudadesVisitadas().get(i).getx()==this.aCiudades.get(i).getx()
							&&e.getCiudadesVisitadas().get(i).gety()==this.aCiudades.get(i).gety()
							&&e.getCiudadesVisitadas().get(i).getOrden()==this.aCiudades.get(i).getOrden())
					{
						i++;
					}
					else
					{
						enc=true;
					}

				}
			}
		}
		return enc;
	}
	public ArrayList<Ciudad> getCiudadesVisitadas() {
		return aCiudadesVisitadas;
	}
	public void setCiudadesVisitadas(ArrayList<Ciudad> aCiudadesVisitadas) {
		this.aCiudadesVisitadas = aCiudadesVisitadas;
	}
	
	//clona el entorno actual
	@SuppressWarnings("unchecked")
	public Object clone()
	{
		Entorno clon = null;
		
		try {
			clon = (Entorno) super.clone();
			clon.aCiudades = (ArrayList<Ciudad>) this.aCiudades.clone();
			clon.aCiudadesVisitadas = (ArrayList<Ciudad>) this.aCiudadesVisitadas.clone();
			clon.inicio = (Ciudad) this.inicio.clone();
			clon.actual = (Ciudad) this.actual.clone();
			clon.fin = (Ciudad) this.fin.clone();
		} catch (CloneNotSupportedException e) {
			System.err.println("% [ERROR] Environment.clone(): " + e.getMessage());
		}
		
		return clon;
	}
	public Ciudad getActual() {
		return actual;
	}
	public void setActual(Ciudad actual) {
		this.actual = actual;
	} 
}
