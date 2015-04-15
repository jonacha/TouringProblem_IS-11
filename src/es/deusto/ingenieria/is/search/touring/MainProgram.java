package es.deusto.ingenieria.is.search.touring;

import es.deusto.ingenieria.is.search.algorithms.blind.BreadthFS;
import es.deusto.ingenieria.is.search.algorithms.blind.BreadthFSwithLog;
import es.deusto.ingenieria.is.search.algorithms.blind.DepthFS;
import es.deusto.ingenieria.is.search.algorithms.blind.DepthFSwithLog;
import es.deusto.ingenieria.is.search.algorithms.heuristic.BestFS;
import es.deusto.ingenieria.is.search.algorithms.heuristic.BestFSwithLog;
import es.deusto.ingenieria.is.search.algorithms.heuristic.EvaluationFunction;
import es.deusto.ingenieria.is.search.touring.formulacion.CUBestF;
import es.deusto.ingenieria.is.search.touring.formulacion.TouringProblem;
import es.deusto.ingenieria.is.search.touring.formulacion.heuristics.DistanciaManhattan;
import es.deusto.ingenieria.is.search.touring.formulacion.heuristics.EvaluacionDeMovimientos;


public class MainProgram {

	/**
	 * Para realizar el log correctamente primero debe ir al toString de Entorno para poder poner en comentarios los atributos innecesarios 
	 * para el archivo TXT del log. Si se quiere probar los algoritmos y generar el archivo log descomentelos y comente los allgoritmos que 
	 * no crean los TXT.
	 * Los Warning aparecen por la parte en comentario, una vez descomentado no aparecerán.
	 * Si se ejecuta tal y como está ahora se muestra en pantalla los recorridos elegidos por los algoritmos con toda la información.
	 * @param args
	 */
	
	public static void main(String[] args) {
		try {
			TouringProblem problem = new TouringProblem();			
			problem.addInitialState(problem.gatherInitialPercepts());

	//		problem.solve(DepthFS.getInstance()); // resuelve el recorrido sin registrar los datos en un txt algoritmo Depth First.
	//	    problem.solve(DepthFSwithLog.getInstance()); // resuelve el recorrido registrando los datos en un txt algoritmo Depth First.
	//	 	problem.solve(BreadthFS.getInstance()); // resuelve el recorrido sin registrar los datos en un txt algoritmo Breadth First.
	//		problem.solve(BreadthFSwithLog.getInstance()); // resuelve el recorrido registrando los datos en un txt algoritmo Breadth First.			
	//      problem.solve(new BestFS(new Manhattan())); // resuelve el recorrido sin registrar los datos en un txt algoritmo Best First.
	//		problem.solve(new BestFSwithLog(new EvaluacionDeMovimientos())); // resuelve el recorrido registrando los datos en un txt algoritmo Best First.
		//problem.solve(CosteUniforme.getInstance());	
	
			//problem .solve(CosteUniformeGrafSeach.getInstance());
		problem.solve(new CUBestF(new DistanciaManhattan()));
		} catch (Exception ex) {
			System.err.println("% [Main Program] Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}