package es.deusto.ingenieria.is.search.touring.formulacion;

import es.deusto.ingenieria.is.search.formulation.Operator;
import es.deusto.ingenieria.is.search.formulation.State;



public class Desplazarse extends Operator {
	private Distancia distancia;

	public Desplazarse()
	{
		super("Desplazarse", 1d);
	}
	public Distancia getDistancia() {
		return distancia;
	}
	public void setDistanciaTotal(Distancia distanciaTotal) {
		this.distancia = distanciaTotal;
	}
	protected void MoverCiudad(){
		//seleccionara el camino mas corto actualizando el orden del array list statico
	}

	protected boolean isApplicable(State estado) {
		Entorno entorno = (Entorno) estado;
		//detectar visitadas, al resto puedo moverme
		int i = 0;
		boolean enc = false;
		if(entorno.getCiudadesVisitadas().size() != 0)
		{
			while(!enc && i <= entorno.getCiudadesVisitadas().size())
			{
				if(entorno.getCiudadesVisitadas().get(i).getNombre().equals(distancia.getDestino().getNombre()))
				{
					enc = true;
				}
				else
				{
					System.out.println(entorno.getCiudadesVisitadas().get(i).getNombre() + " " + distancia.getDestino().getNombre());
					i++;
				}
			}
		}

		if(enc)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	/*Añade la nueva ciudad al array de visitadas y le da el nº del orden. Calcula la distancia de la ciudad actual con la ciudad destino
	 * Muestra la ciudad origen y la destino para mostrar el recorrido.
	 */
	protected State effect(State estado) {

		Entorno nuevoEntorno = (Entorno)((Entorno) estado).clone();
		System.out.println(distancia); // muestra la distancia entre la ciudad origen y destino actuales que llevarán a cabo la acción de desplazarse
		distancia.calcularDistancia();
		distancia.getDestino().setOrden(nuevoEntorno.getCiudadesVisitadas().size() + 1);
		nuevoEntorno.getCiudadesVisitadas().add(distancia.getDestino());
		System.out.println("Ciudades visitadas: " + nuevoEntorno.getCiudadesVisitadas());
		nuevoEntorno.setDistanciaTotal(nuevoEntorno.getDistanciaTotal() + distancia.getDistancia());
		distancia.setOrigen(distancia.getDestino());
		nuevoEntorno.setActual(distancia.getDestino());
	//	nuevoEntorno.getActual().getCiudadesPosibles().remove(nuevoEntorno.getActual());
		distancia.setDestino(null);
		return nuevoEntorno;
	}
}