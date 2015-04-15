package es.deusto.ingenieria.is.search.touring.formulacion;

import es.deusto.ingenieria.is.search.formulation.Operator;
import es.deusto.ingenieria.is.search.formulation.State;

public class Desplazarse extends Operator {
    private Ciudad destino;
    
	public Desplazarse() {
		super("Desplazarse", 1d);
	}
	
	public Desplazarse(Ciudad destino) {
		this.destino = destino;
		setName(destino.getNombre());
	}

	public Ciudad getDestino() {
		return destino;
	}

	public void setDestino(Ciudad destino) {
		this.destino = destino;
	}
	
	@Override
	/**  
	 * @param Strate
	 * @return boolean
	 * Comprueba si el estado es aplicable comprobando si la ciudad destino es una ciudad visitadas
	 * Si está en ciudades visitados devuelve un FALSE sino esta devuelve un TRUE 
	 */
	protected boolean isApplicable(State estado) {
		Entorno entorno = (Entorno) estado;
		//detectar visitadas, al resto puedo moverme
		if(entorno.getCiudadesVisitadas().size() != 0) {
			if(entorno.getCiudadesVisitadas().contains(destino)) {
			return false;
			}
			else{
				return true;
			}
		}
		else {
			return true;
		}
	}

	@Override
	/**
	 * toString que muestra la ciudad destino
	 */
	public String toString() {
		return "Desplazarse [destino= " + destino + " Distancia="+this.getCost()+"]";
	}
	
	/**
	 * Calcular la distancia y guardala en coste mediante la formula de calcular la distancia entre dos puntos
	 */
	public void calcularCoste(State estado) {
	Entorno entorno = (Entorno) estado;
	/*
	 * Importante tener en cuenta en touring problem is final state seleccionar el mismo que seleccionemos
	 * aqui para que de un resultado correcto
	 */
	//distancia euclidea 
		this.setCost(Math.sqrt((Math.pow(destino.getx() - entorno.getActual().getx(), 2)) + (Math.pow(destino.gety() - entorno.getActual().gety(), 2))));
	
	//distancia Manhattan
	
		//this.setCost(Math.abs(destino.getx() - entorno.getActual().getx())+Math.abs(destino.gety() - entorno.getActual().gety()));
	
	//distancia Chebyshev
	//this.setCost(Math.max(Math.abs(destino.getx()-entorno.getActual().getx()) , Math.abs(destino.gety() - entorno.getActual().gety())));
		        }

	@Override
	/**
	 * @param Strate
	 * @return State
	 * Añade la nueva ciudad al array de visitadas.
	 * Comprueba si el desplazamiento es aplicable. En tal caso:
	 * 		Calcula la distancia de la ciudad actual con la ciudad destino
	 * 		Muestra la ciudad origen y la destino para mostrar el recorrido.
	 * 		Suma la distancia total al coste
	 * 		Devuelve el nuevo entorno.
	 * Si no es aplicable devuelve el entorno anterior.
	 */
	protected State effect(State estado) {
		Entorno nuevoEntorno = (Entorno)((Entorno) estado).clone();
		
	    calcularCoste(nuevoEntorno);
	   // muestra la distancia entre la ciudad origen y destino actuales que llevarán a cabo la acción de desplazarse
		nuevoEntorno.getCiudadesVisitadas().add(this.destino);

		if(!this.isApplicable(nuevoEntorno)){
			nuevoEntorno.setDistanciaTotal(nuevoEntorno.getDistanciaTotal() + this.getCost());
			nuevoEntorno.getDistanciaIndividual().add(this.getCost());
			nuevoEntorno.setActual(this.destino);
			return nuevoEntorno;
		}else{
			return estado;
		}
	}
}