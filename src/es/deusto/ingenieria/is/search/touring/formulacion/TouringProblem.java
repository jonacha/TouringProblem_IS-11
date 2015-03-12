package es.deusto.ingenieria.is.search.touring.formulacion;

import es.deusto.ingenieria.is.search.formulation.Problem;
import es.deusto.ingenieria.is.search.formulation.State;

public class TouringProblem extends Problem
{

	public TouringProblem() 
	{
		super();
		this.createOperators();
	}
	
	@Override
	/**
	 * Lectura del archivo XMLReader y creaccion del entorno
	 *@return State
	 */
	public State gatherInitialPercepts() {
		EntornoXMLReader entornoXMLReader = new EntornoXMLReader("data/InitialState.xml");
		return entornoXMLReader.getState();
		
	}
	@Override
	/**
	 * Comprueva si el estado es final comparando el tamaño del ArrayList de visitas y el ArrayList de todas
	 * las ciudades a visitar
	 * @param State
	 * @return boolean
	 */
	public boolean isFinalState(State estado)
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
	
	private void createOperators() {
		this.addOperator(new Desplazarse());
	}
	
}
