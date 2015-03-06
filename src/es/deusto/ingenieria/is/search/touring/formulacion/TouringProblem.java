package es.deusto.ingenieria.is.search.touring.formulacion;

import es.deusto.ingenieria.is.search.formulation.Problem;
import es.deusto.ingenieria.is.search.formulation.State;

public class TouringProblem extends Problem{

	@Override
	public State gatherInitialPercepts() {
		EntornoXMLReader entornoXMLReader = new EntornoXMLReader("data/InitialState.xml");
		return entornoXMLReader.getState();
		
	}
	
}
