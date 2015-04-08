package es.deusto.ingenieria.is.search.touring.formulacion;

import es.deusto.ingenieria.is.search.formulation.Operator;
import es.deusto.ingenieria.is.search.formulation.State;

public class Desplazarse extends Operator {
    private Ciudad destino;
    
	public Desplazarse() {
		super("Desplazarse", 1d);
	}
	
	public Desplazarse(Ciudad destino) {
		this.destino = destino;
		setName(destino.getNombre());
	}

	public Ciudad getDestino() {
		return destino;
	}

	public void setDestino(Ciudad destino) {
		this.destino = destino;
	}
	
	@Override
	/**  
	 * @param Strate
	 * @return boolean
	 * Comprueba si el estado es aplicable comprobando si la ciudad destino es una ciudad visitadas
	 * Si está en ciudades visitados devuelve un FALSE sino esta devuelve un TRUE 
	 */
	protected boolean isApplicable(State estado) {
		Entorno entorno = (Entorno) estado;
		//detectar visitadas, al resto puedo moverme
		if(entorno.getCiudadesVisitadas().size() != 0) {
			if(entorno.getCiudadesVisitadas().contains(destino)) {
			return false;
			}
			else{
				return true;
			}
		}
		else {
			return true;
		}
	}

	@Override
	/**
	 * toString que muestra la ciudad destino
	 */
	public String toString() {
		return "Desplazarse [destino= " + destino + " Distancia="+this.getCost()+"]";
	}
	
	/**
	 * Calcular la distancia y guardala en coste mediante la formula de calcular la distancia entre dos puntos
	 */
	public void calcularCoste(State estado) {
	Entorno entorno = (Entorno) estado;
		this.setCost(Math.sqrt((Math.pow(destino.getx() - entorno.getActual().getx(), 2)) + (Math.pow(destino.gety() - entorno.getActual().gety(), 2))));
/*	while(entorno.getActual().getx()==this.destino.getx()&&entorno.getActual().gety()==this.destino.gety()) {	  
	        
				
					Entorno movimiento[]=new Entorno[4];
					for(int i=0;i<4;i++){
						movimiento[i]=entorno;
					}
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
				int pos=0;
						for(int j=1;j<4;j++){
							if(d>Distancia[j]){
								d=Distancia[j];
								pos=j;
							}
						}
				entorno.setActual(movimiento[pos].getActual());
				this.setCost(this.getCost()+1);
		       }
	*/
		        }
	
	
	@Override
	/**
	 * @param Strate
	 * @return State
	 * Añade la nueva ciudad al array de visitadas.
	 * Comprueba si el desplazamiento es aplicable. En tal caso:
	 * 		Calcula la distancia de la ciudad actual con la ciudad destino
	 * 		Muestra la ciudad origen y la destino para mostrar el recorrido.
	 * 		Suma la distancia total al coste
	 * 		Devuelve el nuevo entorno.
	 * Si no es aplicable devuelve el entorno anterior.
	 */
	protected State effect(State estado) {
		Entorno nuevoEntorno = (Entorno)((Entorno) estado).clone();
		
	    calcularCoste(nuevoEntorno);
	   // muestra la distancia entre la ciudad origen y destino actuales que llevarán a cabo la acción de desplazarse
		nuevoEntorno.getCiudadesVisitadas().add(this.destino);

		if(!this.isApplicable(nuevoEntorno)){
			nuevoEntorno.setDistanciaTotal(nuevoEntorno.getDistanciaTotal() + this.getCost());
			nuevoEntorno.getDistanciaIndividual().add(this.getCost());
			nuevoEntorno.setActual(this.destino);
			return nuevoEntorno;
		}else{
			return estado;
		}
	}
}