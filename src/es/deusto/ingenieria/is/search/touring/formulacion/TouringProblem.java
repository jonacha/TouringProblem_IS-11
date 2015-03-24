package es.deusto.ingenieria.is.search.touring.formulacion;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.SearchMethod;
import es.deusto.ingenieria.is.search.formulation.Problem;
import es.deusto.ingenieria.is.search.formulation.State;

public class TouringProblem extends Problem {

	private Entorno entorno; 

	public TouringProblem() {
		super();
		gatherInitialPercepts();
		this.createOperators();
	}

	public Entorno getEntorno() {
		return entorno;
	}

	/**
	 * Sirve para actualizar el entorno y crear los nuevos operadores
	 * @param entorno
	 */
	public void setEntorno(Entorno entorno) {
		this.entorno = entorno;
	}

	@Override
	/**
	 * Lectura del archivo XMLReader y creacion del entorno
	 *@return State
	 */
	public State gatherInitialPercepts() {
		EntornoXMLReader entornoXMLReader = new EntornoXMLReader("data/InitialState.xml");
		this.entorno = (Entorno) entornoXMLReader.getState();
		return entorno;

	}
	@Override
	/**
	 * Comprueba si el estado es final comparando el tamaño del ArrayList de visitas y el ArrayList de todas
	 * las ciudades a visitar.
	 * @param State
	 * @return boolean
	 */
	public  boolean isFinalState(State estado) {
		Entorno nuevoEntorno = (Entorno)((Entorno) estado);
		if(nuevoEntorno.getCiudades().size() == nuevoEntorno.getCiudadesVisitadas().size()) {
			double distancia=Math.sqrt((Math.pow(nuevoEntorno.getActual().getx() - nuevoEntorno.getFin().getx(), 2)) + (Math.pow(nuevoEntorno.getActual().gety() - entorno.getFin().gety(), 2)));
			nuevoEntorno.getDistanciaIndividual().add(distancia);
			nuevoEntorno.setDistanciaTotal(nuevoEntorno.getDistanciaTotal()+distancia);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Crea un operador por cada ciudad existente en el entorno de acuerdo a la ciudad actual
	 */
	private void createOperators() {
		for(int i = 0; i < entorno.getCiudades().size(); i++ ) {
			if(!entorno.getCiudades().get(i).getNombre().equals(entorno.getActual().getNombre())){
				this.addOperator(new Desplazarse(entorno.getCiudades().get(i)));
			}	
		}
	}

	public void solve(SearchMethod searchMethod) {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss.S");
		Date beginDate = GregorianCalendar.getInstance().getTime();
		System.out.println("\n* Start '" + searchMethod.getClass().getSimpleName() + "' (" + formatter.format(beginDate) + ")");				

		Node finalNode = searchMethod.search(this, this.getInitialStates().get(0));
		
		Date endDate = GregorianCalendar.getInstance().getTime();		
		System.out.println("* End   '" + searchMethod.getClass().getSimpleName() + "' (" + formatter.format(endDate) + ")");
		
		long miliseconds = (int) Math.abs(beginDate.getTime() - endDate.getTime());
		long seconds = miliseconds / 1000;
		miliseconds %= 1000;		
		long minutes = seconds / 60;
		seconds %= 60;
		long hours = minutes / 60;
		minutes %= 60;
		
		String time = "\n* Serach lasts: ";
		time += (hours > 0) ? hours + " h " : " ";
		time += (minutes > 0) ? minutes + " m " : " ";
		time += (seconds > 0) ? seconds + "s " : " ";
		time += (miliseconds > 0) ? miliseconds + "ms " : " ";
		
		System.out.println(time);
		
		if (finalNode != null) {
			System.out.println("\n- Solution found!     :)");
			List<String> operators = new ArrayList<String>();
			searchMethod.solutionPath(finalNode, operators);
			searchMethod.createSolutionLog(operators);			
			System.out.println("- Final state:\n" + finalNode.getState());
		} else {
			System.out.println("\n- Unable to find the solution!     :(");
		}
	}
}