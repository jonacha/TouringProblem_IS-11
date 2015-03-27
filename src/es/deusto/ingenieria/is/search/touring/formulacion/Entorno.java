package es.deusto.ingenieria.is.search.touring.formulacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import es.deusto.ingenieria.is.search.formulation.State;

public class Entorno extends State implements Cloneable {
	private Ciudad inicio = new Ciudad();
	private Ciudad fin = new Ciudad();
	private Ciudad actual = new Ciudad();
	private ArrayList<Double> distanciaIndividual = new ArrayList<Double>();
	private double distanciaTotal = 0;

	private  ArrayList <Ciudad>aCiudades=new ArrayList<Ciudad>();
	private ArrayList<Ciudad> aCiudadesVisitadas = new ArrayList<Ciudad>();

	public Entorno(){}

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
		Collections.shuffle(ciudades);
		this.aCiudades =  ciudades;
	}
	public void setFin(Ciudad fin) {
		this.fin = fin;
	}

	public ArrayList<Ciudad> getCiudadesVisitadas() {
		return aCiudadesVisitadas;
	}
	public void setCiudadesVisitadas(ArrayList<Ciudad> aCiudadesVisitadas) {
		this.aCiudadesVisitadas = aCiudadesVisitadas;
	}
	public Ciudad getActual() {
		return actual;
	}
	public void setActual(Ciudad actual) {
		this.actual = actual;
	}

	public double getDistanciaTotal() {
		return distanciaTotal;
	}

	public void setDistanciaTotal(double distanciaTotal) {
		this.distanciaTotal = distanciaTotal;
	} 
	
	public ArrayList<Double> getDistanciaIndividual() {
		return distanciaIndividual;
	}

	public void setDistanciaIndividual(ArrayList<Double> distanciaIndividual) {
		this.distanciaIndividual = distanciaIndividual;
	}
	
	@Override
	/**
	 * @return String
	 */
	public String toString() {
//		String devuelto="Entorno [inicio=" + inicio + ", fin=" + fin+"\nCiudades=" + aCiudadesVisitadas+" ]+\n";
        String devuelto=actual.getNombre();
		if(aCiudadesVisitadas.size()==aCiudades.size()){
			 devuelto="";
			devuelto = devuelto+inicio.getNombre()+" hasta "+aCiudadesVisitadas.get(0).getNombre() + " Distancia: " + distanciaIndividual.get(0) + "\n";
			for(int i = 1; i < aCiudadesVisitadas.size(); i++) {
				devuelto = devuelto + aCiudadesVisitadas.get(i-1).getNombre() + " hasta "+ aCiudadesVisitadas.get(i).getNombre() + " Distancia: " + distanciaIndividual.get(i) + "\n";	
			}
			devuelto= devuelto + aCiudadesVisitadas.get(aCiudadesVisitadas.size() - 1).getNombre()+" Hasta "+ fin.getNombre() + " Distancia: " + distanciaIndividual.get(distanciaIndividual.size() - 1) +"\nDistancia Total: " + distanciaTotal+"\n";
		}
		return devuelto;
		//return "Entorno [inicio=" + inicio + ", fin=" + fin + ", \nCiudades=" + aCiudadesVisitadas + "Con coste total: " + distanciaTotal + "]";
	}
	@Override
	/**
	 * @param Object
	 * @return boolean
	 * Primera condición compara si el objeto que le pasamos no es nulo y pertenece a un entorno
	 * Segunda condición compara si la ciudad actual es la misma en el entorno y el ArrayList de ciudades visitadas tiene el mismo tamaño
	 * El while es para recorrer todas las ciudades visitadas e ir comparándo las del entorno 1 con el entorno 2
	 * Si alguna de estas condiciones no se cumple significa que los entornos no son iguales por lo tanto 
	 * devuelve un FALSE si se cumple las tres Condiciones devuelve TRUE
	 */
	public boolean equals(Object ent) {
		boolean enc = true;
		int i = 0;
		if(ent != null && ent instanceof Entorno) {
			Entorno e = (Entorno) ent;
			if(e.getActual().getNombre().equals(this.actual.getNombre()) && e.getCiudadesVisitadas().size()==this.aCiudadesVisitadas.size()) {
				while(enc && i < e.getCiudadesVisitadas().size()) {
					if(e.getCiudadesVisitadas().get(i).getNombre().equals(this.aCiudadesVisitadas.get(i).getNombre())) {
						i++;
					} else{
						enc=false; //para la condicion del array si no se cumple se combierte en false
					}
				}
			}else {
				enc=false; //para la condicion de tamaño de ciudad visitad,y la ciudad actual
			}
		} else {
			enc=false; //para comprobar si es nulo
		}
		return enc;
	}

	/**
	 * Clona toda la imformación del entorno actual y devuelve el nuevo entorno
	 * @return Object
	 */
	@SuppressWarnings("unchecked")
	public Object clone() {
		Entorno clon = null;

		try {
			clon = (Entorno) super.clone();
			clon.actual = this. actual;
			clon.distanciaIndividual = (ArrayList<Double>) this.distanciaIndividual.clone();
			clon.aCiudades = (ArrayList<Ciudad>) this.aCiudades.clone();
			clon.aCiudadesVisitadas = (ArrayList<Ciudad>) this.aCiudadesVisitadas.clone();
		} catch (CloneNotSupportedException e) {
			System.err.println("% [ERROR] Entorno.clone(): " + e.getMessage());
		}

		return clon;
	}
}