package es.deusto.ingenieria.is.search.touring.formulacion;



public class Distancia {
	private Ciudad Origen;
	private Ciudad Destino;
	private float distancia;
	public Ciudad getOrigen() {
		return Origen;
	}
	Distancia(){
		
	}
	public void setOrigen(Ciudad origen) {
		Origen = origen;
	}
	public Ciudad getDestino() {
		return Destino;
	}
	public void setDestino(Ciudad destino) {
		this.Destino = destino;
	}
	public float getDistanciaTotal() {
		return distancia;
	}
	public void setDistanciaTotal(float distanciaTotal) {
		this.distancia = distanciaTotal;
	}
	public Distancia(Ciudad origen, Ciudad destino, float distancia) {
		
		Origen = origen;
		this.Destino = destino;
		this.distancia = distancia;
	}
	@Override
	public String toString() {
		return "Distancia [Origen=" + Origen + ", destino=" + Destino
				+ ", distanciaTotal=" + distancia + "]";
	}



}
