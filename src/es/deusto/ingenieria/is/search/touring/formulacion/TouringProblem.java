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
	public State gatherInitialPercepts() {
		EntornoXMLReader entornoXMLReader = new EntornoXMLReader("data/InitialState.xml");
		return entornoXMLReader.getState();
		
	}
	
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
