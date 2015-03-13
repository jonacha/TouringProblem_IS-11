package es.deusto.ingenieria.is.search.touring.formulacion;

import es.deusto.ingenieria.is.search.formulation.Problem;
import es.deusto.ingenieria.is.search.formulation.State;

public class TouringProblem extends Problem
{

	private Entorno entorno;
	public TouringProblem() 
	{
		super();
		gatherInitialPercepts();
		this.createOperators();
	}
	
	@Override
	/**
	 * Lectura del archivo XMLReader y creacion del entorno
	 *@return State
	 */
	public State gatherInitialPercepts() {
		EntornoXMLReader entornoXMLReader = new EntornoXMLReader("data/InitialState.xml");
		this.entorno = (Entorno) entornoXMLReader.getState();
		return entorno;
		
	}
	@Override
	/**
	 * Comprueba si el estado es final comparando el tamaño del ArrayList de visitas y el ArrayList de todas
	 * las ciudades a visitar.
	 * @param State
	 * @return boolean
	 */
	public  boolean isFinalState(State estado)
	{
		Entorno nuevoEntorno = (Entorno)((Entorno) estado);
		if(nuevoEntorno.getCiudades().size() == nuevoEntorno.getCiudadesVisitadas().size())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Crea un operador por cada ciudad existente en el entorno de acuerdo a la ciudad actual
	 */
	private void createOperators() 
	{
		for(int i = 0; i < entorno.getCiudades().size(); i++ )
		{
			this.addOperator(new Desplazarse(entorno.getCiudades().get(i)));
		}	
	}
}
