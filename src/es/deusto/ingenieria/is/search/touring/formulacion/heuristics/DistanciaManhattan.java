package es.deusto.ingenieria.is.search.touring.formulacion.heuristics;

import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.heuristic.EvaluationFunction;
import es.deusto.ingenieria.is.search.touring.formulacion.Entorno;

public class DistanciaManhattan extends EvaluationFunction{

	@Override
	public double calculateG(Node arg0) {
		// TODO Auto-generated method stub
Entorno entorno = (Entorno) arg0.getState(); 
		return entorno.calcularManhatan(entorno);
	}

	@Override
	public double calculateH(Node arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}
