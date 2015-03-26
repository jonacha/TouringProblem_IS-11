package es.deusto.ingenieria.is.search.touring;
import es.deusto.ingenieria.is.search.algorithms.blind.BreadthFSwithLog;
import es.deusto.ingenieria.is.search.algorithms.blind.DepthFSwithLog;
import es.deusto.ingenieria.is.search.algorithms.heuristic.BestFSwithLog;
import es.deusto.ingenieria.is.search.touring.formulacion.TouringProblem;
import es.deusto.ingenieria.is.search.touring.formulacion.heuristics.EvaluacionDeMovimientos;

public class MainProgram {

	public static void main(String[] args) {
		try {
			TouringProblem problem = new TouringProblem();			
			problem.addInitialState(problem.gatherInitialPercepts());
			
			System.out.println("Depth First");
			problem.solve(DepthFSwithLog.getInstance());
			System.out.println("Breadth First");
			problem.solve(BreadthFSwithLog.getInstance());
			System.out.println("Best First");
			problem.solve(new BestFSwithLog(new EvaluacionDeMovimientos()));
			
		} catch (Exception ex) {
			System.err.println("% [Main Program] Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}
