package es.deusto.ingenieria.is.search.touring.formulacion.heuristics;

import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.heuristic.EvaluationFunction;
import es.deusto.ingenieria.is.search.touring.formulacion.Ciudad;
import es.deusto.ingenieria.is.search.touring.formulacion.Desplazarse;
import es.deusto.ingenieria.is.search.touring.formulacion.Entorno;

public class Manhattan extends EvaluationFunction{
	Manhattan(Node node){
		Entorno entorno = (Entorno) node.getState(); 
		double dx=(entorno.getActual().getx()-entorno.getFin().getx());
		double dy=(entorno.getActual().gety()-entorno.getFin().gety());
	
		Entorno movimiento[]=new Entorno[4];
		double Distancia[]=new double[4];
		for(int i =0;i<4;i++){
	    Ciudad actual=new Ciudad();		
		if(i==0){
			actual.setx(entorno.getActual().getx()+1);
			actual.sety(entorno.getActual().gety());
			}
			else if(i==1){
				actual.setx(entorno.getActual().getx()-1);
				actual.sety(entorno.getActual().gety());	
			}
			else if(i==2){
				actual.setx(entorno.getActual().getx());
				actual.sety(entorno.getActual().gety()-1);
			}
			else if(i==3){
				actual.setx(entorno.getActual().getx());
				actual.sety(entorno.getActual().gety()+1);
			}
			
			movimiento[i].setActual(actual);
		    movimiento[i].setFin(entorno.getFin());
		}
		for(int i=0;i<4;i++){
			Desplazarse d = new Desplazarse(movimiento[i].getFin());
			d.calcularCoste(movimiento[i]);	
			Distancia[i]=d.getCost();
		}
		double d=Distancia[0];
	
			for(int j=1;j<4;j++){
				if(d>Distancia[j]){
					d=Distancia[j];
				}
			}
	//	return d*(dx+dy);
		
	}

		@Override
		public double calculateG(Node node) {
			// TODO Auto-generated method stub
 
			return 0;
		}

		/**
		 * Se calcula la distancia de la ciudad actual a la ciudad final de forma directa.
		 * Por lo tanto sabemos que siempre la heuristica siempre va a ser verdadera.
		 * 
		 */
		@Override
		public double calculateH(Node node) {
			Entorno entorno = (Entorno) node.getState(); 
		   
			double distanciafin = 0;
			Desplazarse d = new Desplazarse(entorno.getFin());
			d.calcularCoste(entorno);
			distanciafin = d.getCost();
			return distanciafin;
		}
	
}
