package es.deusto.ingenieria.is.search.touring.formulacion;

import es.deusto.ingenieria.is.search.formulation.State;



public class Desplazarse {
	private Distancia distancia;
	
	public Desplazarse(){}
	public Distancia getDistancia() {
		return distancia;
	}
	public void setDistanciaTotal(Distancia distanciaTotal) {
		this.distancia = distanciaTotal;
	}
	protected void MoverCiudad(){
		//seleccionara el camino mas corto actualizando el orden del array list statico
	}

	protected boolean isApplicable(State estado, Ciudad c) {
		Entorno entorno = (Entorno) estado;

		//detectar visitadas, al resto puedo moverme
		int i = 0;
		boolean enc = false;
		while(enc && i < entorno.getCiudadesVisitadas().size())
		{
			if(entorno.getCiudadesVisitadas().get(i).getNombre().equals(c.getNombre()))
			{
				enc = true;
			}
			else
			{
				i++;
			}
		}
		return !enc; // si la ciudad ha sido visitada la acción no es aplicable, si no entonces no es visitada y es aplicable


	}
/*Añade la nueva ciudad al array de visitadas y le da el nº del orden.
 * ¿a parte de eso tendríamos que poner que estamos sobre ella?
 */
	protected State effect(State estado, Ciudad c) {

		Entorno nuevoEntorno = (Entorno)((Entorno) estado).clone();

		c.setOrden(nuevoEntorno.getCiudadesVisitadas().size() + 1);
		nuevoEntorno.getCiudadesVisitadas().add(c);
		nuevoEntorno.setActual(c);
		return nuevoEntorno;
	}
}

