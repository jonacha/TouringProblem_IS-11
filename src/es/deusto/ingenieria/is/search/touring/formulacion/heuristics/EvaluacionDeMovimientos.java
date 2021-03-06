package es.deusto.ingenieria.is.search.touring.formulacion.heuristics;
import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.heuristic.EvaluationFunction;
import es.deusto.ingenieria.is.search.touring.formulacion.Desplazarse;
import es.deusto.ingenieria.is.search.touring.formulacion.Entorno;
public class EvaluacionDeMovimientos extends EvaluationFunction {

	/**
	 * Devuelve la distancia total en cada movimiento
	 * @return
	 */
	@Override
	public double calculateG(Node node) {
		// TODO Auto-generated method stub
		Entorno entorno = (Entorno) node.getState(); 

		return entorno.getDistanciaTotal();
	}

	/** 
	 * Se calcula la distancia de la ciudad actual a la ciudad final de forma directa.
	 * Por lo tanto sabemos que siempre la heuristica siempre va a ser verdadera y correcta.
	 * @return
	 * 
	 */
	@Override
	public double calculateH(Node node) {
		Entorno entorno = (Entorno) node.getState(); 

		double distanciafin = 0;
		Desplazarse d = new Desplazarse(entorno.getFin());
		d.calcularCoste(entorno);
		distanciafin = d.getCost();
		return distanciafin-1;
	}

}