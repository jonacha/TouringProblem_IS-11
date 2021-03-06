package es.deusto.ingenieria.is.search.touring.formulacion;

import java.util.ArrayList;
import java.util.Collections;

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
	 * Muestra por pantalla toda la ruta elegida por el algoritmo, pero tambien se guarda en los TXT del Log, si se quiere ver por pantalla dejarlo as�
	 * Si se desea que el TXT ocupe poco se debe comentar todo el if del toString, pero no aparecer�n los datos por pantalla.
	 * @return String
	 */
	public String toString() {
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
	}
	@Override
	/**
	 * @param Object
	 * @return boolean
	 * Primera condici�n compara si el objeto que le pasamos no es nulo y pertenece a un entorno
	 * Segunda condici�n compara si la ciudad actual es la misma en el entorno y el ArrayList de ciudades visitadas tiene el mismo tama�o.
	 * El while es para recorrer todas las ciudades visitadas e ir compar�ndo las del entorno 1 con el entorno 2
	 * Si alguna de estas condiciones no se cumple significa que los entornos no son iguales por lo tanto 
	 * devuelve un FALSE si se cumple las tres Condiciones devuelve TRUE
	 */
	public boolean equals(Object ent) {
		boolean enc = true;
		int i = 0;
		if(ent != null && ent instanceof Entorno&&this.aCiudadesVisitadas!=null&&this.getActual()!=null) {
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
				enc = false; //para la condicion de tama�o de ciudad visitad,y la ciudad actual
			}
		} else {
			enc = false; //para comprobar si es nulo
		}
		return enc;
	}

	/**
	 * Clona toda la imformaci�n del entorno actual y devuelve el nuevo entorno
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

	/**
	 * Se calcula la distancia total mediante la suma de distancias de la ciudad inicio a la primera ciudad visitada y de la primera a la segunda
	 * hasta acabar la lista completa de visistadas y de la �ltima a la final. La f�rmula es distancia = |origenX - DestinoX| + |OrigenY - DestinoY| 
	 * @param estado
	 * @return
	 */
	public double calcularManhattan(State estado){
		double distanciaTotal = 0;
		Entorno entorno = (Entorno) estado;
		double distancia = 0;
		if(entorno.getCiudadesVisitadas().size() > 0){
			distanciaTotal = Math.abs(entorno.getInicio().getx()-entorno.getCiudadesVisitadas().get(0).getx())+Math.abs(entorno.getInicio().gety()-entorno.getCiudadesVisitadas().get(0).gety());
		}
		for(int i = 0; i < entorno.getCiudadesVisitadas().size() - 1; i++){
			distancia = Math.abs(entorno.getCiudadesVisitadas().get(i).getx() - entorno.getCiudadesVisitadas().get(i + 1).getx())+Math.abs(entorno.getCiudadesVisitadas().get(i).gety() - entorno.getCiudadesVisitadas().get(i + 1).gety());
			distanciaTotal = distanciaTotal + distancia;
		}
		if(entorno.getCiudades().size()==entorno.getCiudadesVisitadas().size()){
			distanciaTotal = distanciaTotal + Math.abs(entorno.getCiudadesVisitadas().get(entorno.getCiudadesVisitadas().size() - 1).getx() - entorno.getFin().getx()) + Math.abs(entorno.getCiudadesVisitadas().get(entorno.getCiudadesVisitadas().size() - 1).gety() - entorno.getFin().gety());
		}
		return distanciaTotal;
	}
}