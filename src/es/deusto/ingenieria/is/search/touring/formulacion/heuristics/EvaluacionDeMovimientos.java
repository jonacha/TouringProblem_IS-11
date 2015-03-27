package es.deusto.ingenieria.is.search.touring.formulacion.heuristics;
import es.deusto.ingenieria.is.search.algorithms.Node;
import es.deusto.ingenieria.is.search.algorithms.heuristic.EvaluationFunction;
import es.deusto.ingenieria.is.search.touring.formulacion.Ciudad;
import es.deusto.ingenieria.is.search.touring.formulacion.Desplazarse;
import es.deusto.ingenieria.is.search.touring.formulacion.Entorno;
public class EvaluacionDeMovimientos extends EvaluationFunction {

 @Override
 public double calculateG(Node node) {
 // TODO Auto-generated method stub
 
 return 0;
 }

 @Override
 public double calculateH(Node node) {
 Entorno entorno= (Entorno) node.getState(); 
 double distancia=0;
 double distanciafin=0;
 Desplazarse d=new Desplazarse(entorno.getFin());
 d.calcularCoste(entorno);
 distanciafin=d.getCost();
 Ciudad c=new Ciudad();
 for(int i=0;i<entorno.getCiudades().size();i++){
 if(entorno.getCiudadesVisitadas().contains(entorno.getCiudades().get(i))){
 c=entorno.getCiudades().get(i);
 d.setDestino(c);
 d.calcularCoste(entorno);
 distancia=distancia +d.getCost();
 entorno.setActual(c);
 }
 }
 if(distancia<=distanciafin){
 return distanciafin;
 
 }
 else{
	 
 
 return distancia;
 }}

}