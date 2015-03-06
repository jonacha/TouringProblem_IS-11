package es.deusto.ingenieria.is.search.touring;

import es.deusto.ingenieria.is.search.touring.formulacion.TouringProblem;

public class MainProgram {

	public static void main(String[] args) {
		try {
			TouringProblem problem = new TouringProblem();			
			problem.addInitialState(problem.gatherInitialPercepts());
			
		System.out.println(problem.getInitialStates());
		} catch (Exception ex) {
			System.err.println("% [Main Program] Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}
