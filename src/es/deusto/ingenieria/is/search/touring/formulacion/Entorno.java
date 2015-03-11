package es.deusto.ingenieria.is.search.touring.formulacion;

import java.util.ArrayList;
import es.deusto.ingenieria.is.search.formulation.State;

public class Entorno extends State implements Cloneable{
	private Ciudad inicio = new Ciudad();
	private Ciudad fin = new Ciudad();
	private Ciudad actual = new Ciudad();
	private double distanciaTotal = 0;

	private  ArrayList <Ciudad>aCiudades=new ArrayList<Ciudad>();
	private ArrayList<Ciudad> aCiudadesVisitadas = new ArrayList<Ciudad>();

	public Ciudad getInicio() {
		return inicio;
	}
	public void setInicio(Ciudad inicio) {
		this.inicio = inicio;
	}
	public Ciudad getFin() {
		return fin;
	}
	public ArrayList<Ciudad> getCiudades() {
		return aCiudades;
	}
	public void setCiudades(ArrayList<Ciudad> ciudades) {
		this.aCiudades =  ciudades;
	}
	public void setFin(Ciudad fin) {
		this.fin = fin;
	}
	public Entorno(){

	}

	public Entorno(Ciudad inicio, Ciudad fin, ArrayList<Ciudad> ciudades) {
		super();
		this.inicio = inicio;
		this.fin = fin;
		aCiudades = ciudades;
	 this.actual=inicio;
	}
	@Override
	public String toString() {
		return "Entorno [inicio=" + inicio + ", fin=" + fin + ", Ciudades="
				+ aCiudades + "]";
		//posteriormente adecuaremos el estrinpara que se ordenen segun las ciudades
	}
	@Override
	public boolean equals(Object ent) 
	{
		boolean enc = true;
		int i = 0;
		if(ent != null && ent instanceof Entorno)
		{
			Entorno e = (Entorno) ent;
			if(e.getActual().getNombre().equals(this.actual.getNombre())
					&&e.getActual().getx()==this.actual.getx()&&e.getActual().gety()==this.actual.gety() 
					&&  e.getCiudadesVisitadas().size()==this.aCiudadesVisitadas.size()){


				while(enc && i < e.getCiudadesVisitadas().size())
				{
					if(e.getCiudadesVisitadas().get(i).getNombre().equals(this.aCiudadesVisitadas.get(i).getNombre())
							&&e.getCiudadesVisitadas().get(i).getx()==this.aCiudades.get(i).getx()
							&&e.getCiudadesVisitadas().get(i).gety()==this.aCiudades.get(i).gety()
							&&e.getCiudadesVisitadas().get(i).getOrden()==this.aCiudades.get(i).getOrden())
					{
						i++;
					}
					else
					{
						enc=false;//para la condicion del array si no se cumple se combierte en false
					}

				}

			}
			else{
				enc=false;//para la condicion de tamaño de ciudad visitad,y la ciudad actual
			}
		}
		else{
			enc=false;//para comprobar si es nulo
		}
		return enc;
	}
	public ArrayList<Ciudad> getCiudadesVisitadas() {
		return aCiudadesVisitadas;
	}
	public void setCiudadesVisitadas(ArrayList<Ciudad> aCiudadesVisitadas) {
		this.aCiudadesVisitadas = aCiudadesVisitadas;
	}

	//clona el entorno actual
	@SuppressWarnings("unchecked")
	public Object clone()
	{
		Entorno clon = null;

		try {
			clon = (Entorno) super.clone();
			clon.inicio = (Ciudad) this.inicio.clone();
			clon.actual = (Ciudad) this.actual.clone();
			clon.fin = (Ciudad) this.fin.clone();
			clon.aCiudades = (ArrayList<Ciudad>) this.aCiudades.clone();
			clon.aCiudadesVisitadas = (ArrayList<Ciudad>) this.aCiudadesVisitadas.clone();
		} catch (CloneNotSupportedException e) {
			System.err.println("% [ERROR] Entorno.clone(): " + e.getMessage());
		}

		return clon;
	}
	public Ciudad getActual() {
		return actual;
	}
	public void setActual(Ciudad actual) {
		this.actual = actual;
	}
	public double getDistanciaTotal() {
		return distanciaTotal;
	}
	public void setDistanciaTotal(double distanciaTotal) {
		this.distanciaTotal = distanciaTotal;
	} 


	public void rellenarCiudadesPotenciales()
	{

	}

	/**
	 * Main
	 * @param args
	 */
	public static void main(String[]args)
	{
		Ciudad s = new Ciudad(1,4,"S");
		Ciudad a = new Ciudad(3,2,"A");
		Ciudad e = new Ciudad(11,1,"E");
		Ciudad z = new Ciudad(15,5,"Z");
		/**
		 * Ya que no vamos a solucionar el problema por el momento hemos decivido no rellenar el 
		 * Array de las ciudades posibles a las que se puede ir
		 * 
		 */
		Desplazarse desp = new Desplazarse(s,a);//Creaccion de desplazarse
		ArrayList<Ciudad> aCiudades = new ArrayList<Ciudad>();
		aCiudades.add(a);
		aCiudades.add(e);
		Entorno ent = new Entorno(s, z, aCiudades); //Creación de un entorno de pruebas
	    System.out.println("Entorno1="+ent);
		if(desp.isApplicable(ent)) //Comprobamos que la acción es aplicable
		{
			System.out.println("Es aplicable");
			ent = (Entorno) desp.effect(ent);

		}
		else
		{
			System.out.println("No soy aplicable");
		}

		desp.setDestino(a);
		if(desp.isApplicable(ent))//Comprobamos que la acción no es aplicable, su sale el interior de este if en pantalla está mal
		{
			System.out.println("No debo salir");
		}
		else{
			System.out.println("Correcto");
		}

		System.out.println(ent); // mostramos el contenido del entorno de pruebas
        ent=new Entorno(s,z,aCiudades);
		Entorno entclon = new Entorno(s,z,aCiudades); // Creamos un entorno vacío en el que vamos a clonar el entorno de pruebas
			System.out.println(ent);
			System.out.println(entclon);
				//entclon = (Entorno) ent.clone(); //Clonamos el entorno
		//System.out.println(entclon); // mostramos el contenido del entorno clon
		if(ent.equals(entclon))
		{
			System.out.println("Soy igual");
		}
		ent.getCiudadesVisitadas().add(s); // añadimos un cambio	
		if(!ent.equals(entclon))
		{
			System.out.println("Soy diferente");
		}
		
	}
}