package es.deusto.ingenieria.is.search.touring;
import es.deusto.ingenieria.is.search.algorithms.blind.BreadthFS;
import es.deusto.ingenieria.is.search.algorithms.blind.DepthFS;
import es.deusto.ingenieria.is.search.algorithms.heuristic.BestFS;
import es.deusto.ingenieria.is.search.touring.formulacion.TouringProblem;
import es.deusto.ingenieria.is.search.touring.formulacion.heuristics.EvaluacionDeMovimientos;

public class MainProgram {

	public static void main(String[] args) {
		try {
			TouringProblem problem = new TouringProblem();			
			problem.addInitialState(problem.gatherInitialPercepts());
			
			System.out.println("Depth First");
			problem.solve(DepthFS.getInstance());
			System.out.println("Breadth First");
			problem.solve(BreadthFS.getInstance());
			System.out.println("Best First");
			problem.solve(new BestFS(new EvaluacionDeMovimientos()));
	
//			problem.solve(BestFS.getInstance());
			
			
			
		} catch (Exception ex) {
			System.err.println("% [Main Program] Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}
