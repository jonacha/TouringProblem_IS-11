package es.deusto.ingenieria.is.search.touring.formulacion;

import es.deusto.ingenieria.is.search.formulation.Operator;
import es.deusto.ingenieria.is.search.formulation.State;



public class Desplazarse extends Operator {
	private Ciudad origen;
    private Ciudad destino;
	public Desplazarse()
	{
		super("Desplazarse", 1d);
	}
	
	public Desplazarse(Ciudad origen, Ciudad destino) {
		this.origen = origen;
		this.destino = destino;
	}

	public Ciudad getOrigen() {
		return origen;
	}

	public void setOrigen(Ciudad origen) {
		this.origen = origen;
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
	 * Compruba si el estado es aplicable comprobando si la ciudad destino es una ciudad visitadas
	 * Si esta en ciudades visitados devuelve un FALSE sino esta devuelve un TRUE 
	 */
	protected boolean isApplicable(State estado) {
		Entorno entorno = (Entorno) estado;
		//detectar visitadas, al resto puedo moverme
		int i = 0;
		boolean enc = false;
		if(entorno.getCiudadesVisitadas().size() != 0)
		{
			while(!enc && i <= entorno.getCiudadesVisitadas().size())
			{
				if(entorno.getCiudadesVisitadas().get(i).getNombre().equals(this.destino.getNombre()))
				{
					enc = true;
				}
				else
				{
					System.out.println(entorno.getCiudadesVisitadas().get(i).getNombre() + " " + this.destino.getNombre());
					i++;
				}
			}
		}

		if(enc)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	@Override
	/**
	 * toString que muestra la ciudad origen y la ciudad destino
	 */
	public String toString() {
		return "Desplazarse [origen=" + origen + ", destino=" + destino + " Distancia="+this.getCost()+"]";
	}
	
	/**
	 * Calcular la distancia y guardala en coste mediante la formula de calcular la distancia entre dos puntos
	 */
	public void calcularCoste(){
		 
		this.setCost(Math.sqrt((Math.pow(destino.getx() - origen.getx(), 2)) + (Math.pow(destino.gety() - origen.gety(), 2))));
	}
	@Override
	/**
	 * @param Strate
	 * @return State
	 *Añade la nueva ciudad al array de visitadas y le da el nº del orden. Calcula la distancia de la ciudad actual con la ciudad destino
	 * Muestra la ciudad origen y la destino para mostrar el recorrido.
	 */
	protected State effect(State estado) {
		Entorno nuevoEntorno = (Entorno)((Entorno) estado).clone();
	    calcularCoste();
	    System.out.println(this); // muestra la distancia entre la ciudad origen y destino actuales que llevarán a cabo la acción de desplazarse
		this.destino.setOrden(nuevoEntorno.getCiudadesVisitadas().size() + 1);
		nuevoEntorno.getCiudadesVisitadas().add(this.destino);
		System.out.println("Ciudades visitadas: " + nuevoEntorno.getCiudadesVisitadas());
		nuevoEntorno.setDistanciaTotal(nuevoEntorno.getDistanciaTotal() +this.getCost());
		this.origen=(this.destino);
		nuevoEntorno.setActual(this.destino);
	//	nuevoEntorno.getActual().getCiudadesPosibles().remove(nuevoEntorno.getActual());
		this.destino=null;
		return nuevoEntorno;
	}
}