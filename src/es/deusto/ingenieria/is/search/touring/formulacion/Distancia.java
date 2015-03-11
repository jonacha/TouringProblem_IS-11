package es.deusto.ingenieria.is.search.touring.formulacion;



public class Distancia {
	private Ciudad origen;
	private Ciudad destino = null;
	private double distancia;
	public Ciudad getOrigen() {
		return origen;
	}
	Distancia(){
		
	}
	public void setOrigen(Ciudad origen) {
		this.origen = origen;
	}
	public Ciudad getDestino() {
		return destino;
	}
	public void setDestino(Ciudad destino) {
		this.destino = destino;
	}
	public double getDistancia() {
		return distancia;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	public Distancia(Ciudad origen, Ciudad destino, float distancia) {
		
		this.origen = origen;
		this.destino = destino;
		this.distancia = distancia;
	}
	

	@Override
	public String toString() {
		return "Distancia [origen=" + origen + ", destino=" + destino
				+ ", distancia=" + distancia + "]";
	}
	public void calcularDistancia()
	{
		this.distancia = Math.sqrt((Math.pow(destino.getx() - origen.getx(), 2)) + (Math.pow(destino.gety() - origen.gety(), 2)));
	}
}
