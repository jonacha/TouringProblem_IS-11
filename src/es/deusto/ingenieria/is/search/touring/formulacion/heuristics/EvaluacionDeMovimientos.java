package es.deusto.ingenieria.is.search.touring.formulacion.heuristics;
import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.heuristic.EvaluationFunction;
import es.deusto.ingenieria.is.search.touring.formulacion.Entorno;
public class EvaluacionDeMovimientos extends EvaluationFunction {

	@Override
	public double calculateG(Node node) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public double calculateH(Node node) {
		Entorno environment = (Entorno) node.getState();		
		return environment.getDistanciaTotal();
		
	}

}
