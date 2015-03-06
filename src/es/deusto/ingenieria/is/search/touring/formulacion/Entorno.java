package es.deusto.ingenieria.is.search.touring.formulacion;

import java.util.ArrayList;

import es.deusto.ingenieria.is.search.formulation.State;

public class Entorno extends State {
	private Ciudad inicio=new Ciudad();
	private Ciudad fin=new Ciudad();
	private  ArrayList <Ciudad>Ciudades=new ArrayList<Ciudad>();

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
		return Ciudades;
	}
	public void setCiudades(ArrayList<Ciudad> ciudades) {
		this.Ciudades =  ciudades;
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
		Ciudades = ciudades;
	}
	@Override
	public String toString() {
		return "Entorno [inicio=" + inicio + ", fin=" + fin + ", Ciudades="
				+ Ciudades + "]";
		//posteriormente adecuaremos el estrinpara que se ordenen segun las ciudades
	}
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}
}
